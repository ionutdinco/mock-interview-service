package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.PostEntity;
import com.fullstack.mockinterviewservice.model.Post;
import com.fullstack.mockinterviewservice.repository.PostEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService{

    @Autowired
    private PostEntityRepository postEntityRepository;

    @Override
    public Post addPost(Post post) throws Exception {
        try{
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post, postEntity);
            if(post.getFile() != null && post.getFile().equalsIgnoreCase("null")){
                postEntity.setImage(post.getFile());
            }else
                postEntity.setImage(null);
            postEntity = postEntityRepository.save(postEntity);
            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());
        }catch (Exception e){
            log.info("{}", e.getMessage());
            throw new Exception("Could not save Post: " + e);
        }
        return post;
    }

    @Override
    public List<Post> getPosts() {
        List<PostEntity> postEntities =
                postEntityRepository.findAll(Sort.by("timeStamp").descending());
        List<Post> posts = new ArrayList<>();
        BeanUtils.copyProperties(postEntities, posts);
        posts = postEntities.stream()
                .map((postEntity -> Post.builder()
                        .id(postEntity.getId())
                        .name(postEntity.getName())
                        .email(postEntity.getEmail())
                        .image(postEntity.getImage())
                        .post(postEntity.getPost())
                        .profilePicture(postEntity.getProfilePicture())
                        .timeStamp(postEntity.getTimeStamp())
                        .build()))
                .collect(Collectors.toList());
        return null;
    }
}
