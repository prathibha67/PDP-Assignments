package com.demo.blog.controller;

import com.demo.blog.model.Blog;
import com.demo.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/dateWise")
    public List<Blog> getDateWiseBlogs(){
        LocalDate date = LocalDate.now();
        return blogService.getBlogsByDate(date);
    }

    @GetMapping("/sortedByPosts")
    public List<Blog> getBlogsSortedByPosts(){
        return blogService.getBlogsSortedByPosts();
    }

    @GetMapping("/active")
    public List<Blog> getActiveBlogs(){
        return blogService.getActiveBlogs();
    }

    @GetMapping("/dormant")
    public List<Blog> getDormantBlogs(){
        return blogService.getDormantBlogs();
    }

    @GetMapping("/blogOwners/sortedByPosts")
    public List<Blog> getBlogOwnersSortedByPosts(){
        return blogService.getBlogOwnersSortedByPosts();
    }

    @PostMapping("/blogcreate")
    public Blog createBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);

    }
}
