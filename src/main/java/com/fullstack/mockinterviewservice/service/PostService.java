package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPosts();
}
