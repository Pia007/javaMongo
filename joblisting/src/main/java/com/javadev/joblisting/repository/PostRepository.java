package com.javadev.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javadev.joblisting.models.Post;

// mongo repository will provide all the basic CRUD operations
public interface PostRepository extends MongoRepository<Post, String> {
    
}
