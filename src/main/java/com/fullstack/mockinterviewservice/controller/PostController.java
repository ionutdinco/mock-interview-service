package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.model.Post;
import com.fullstack.mockinterviewservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@RequestParam Map<String, String> requestParams) throws Exception {
        String strPost= requestParams.get("post");
        String email= requestParams.get("email");
        String name= requestParams.get("name");
        String file= requestParams.get("file");
        String profileImage= requestParams.get("profileImage");

        Post post = Post.builder()
                .file(file)
                .name(name)
                .email(email)
                .profilePicture(profileImage)
                .post(strPost)
                .timeStamp(new Date().toString())
                .build();

        post = postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }
}
