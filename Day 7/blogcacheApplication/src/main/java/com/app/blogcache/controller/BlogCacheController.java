package com.app.blogcache.controller;

import com.app.blogcache.model.BlogCache;
import com.app.blogcache.service.BlogCacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogCacheController {

    @Autowired
    private BlogCacheService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getBlogPost(@PathVariable Long id) {
        blogService.getBlogPostById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Blog Found!");
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> createBlogPost(@RequestBody BlogCache blogPost){
        blogService.createBlogPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog Created Successfully");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlogPost(@PathVariable Long id) {
        blogService.deleteBlogPost(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Blog Deleted Successfully");
    }
}