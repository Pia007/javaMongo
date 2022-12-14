package com.javadev.joblisting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javadev.joblisting.models.Post;
import com.javadev.joblisting.repository.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PostController {

    // create an instance of PostRepository
    @Autowired 
    private PostRepository postRepo;

    // implementing a search option of the entire db using indexing (atlas search)
    @Autowired
    private SearchRepository searchRepo;

    
    // get all posts
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    // post data
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postRepo.save(post);
    }

    // search
    @GetMapping("/posts/{text}")
    public List<Post> searchPost(@PathVariable String text) {
        return searchRepo.findByText(text);
    }

}
