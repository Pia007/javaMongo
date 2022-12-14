package com.javadev.joblisting.services;

import java.util.*;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.javadev.joblisting.models.Post;
import com.javadev.joblisting.repository.SearchRepository;
import com.mongodb.client.*;
// import org.springframework.data.mongodb.core.convert.MongoConverter;
// import com.mongodb.client.AggregateIterable;
// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;

@Service
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        
        final List<Post> posts = new ArrayList<>();
        
        
        MongoDatabase database = client.getDatabase("javaMongo");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                new Document("query", text)
                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                new Document("exp", 1L)),
                new Document("$limit", 5L)));

        // read(class, what to read)
        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));


        return posts;
    }
    
}


/* Created aggregate pipeline in MongoAtlas, stage order search, sort, limit */
