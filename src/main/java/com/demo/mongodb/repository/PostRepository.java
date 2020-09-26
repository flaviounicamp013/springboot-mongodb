package com.demo.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
 
}

