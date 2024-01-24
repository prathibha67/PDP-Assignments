package com.app.blogcache.service;

import com.app.blogcache.model.BlogCache;
import com.app.blogcache.repository.BlogCacheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BlogCacheService {

    @Autowired
    private BlogCacheRepository blogPostRepository;

    @Cacheable(value = "blogPost", key = "#id")
    public BlogCache getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = "blogPost", key = "#id")
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public void createBlogPost(BlogCache blogPost){
        blogPostRepository.save(blogPost);
    }
}