package com.app.blogcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogcache.model.BlogCache;

public interface BlogCacheRepository extends JpaRepository<BlogCache, Long> {
}
