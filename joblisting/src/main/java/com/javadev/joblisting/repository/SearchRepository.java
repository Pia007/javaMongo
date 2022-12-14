package com.javadev.joblisting.repository;

import java.util.List;

import com.javadev.joblisting.models.Post;

public interface SearchRepository {

    List<Post> findByText(String text);
    
}
