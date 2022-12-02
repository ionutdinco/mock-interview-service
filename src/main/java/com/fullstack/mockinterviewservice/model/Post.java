package com.fullstack.mockinterviewservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private String post;
    private String name;
    private String email;
    private String image;
    private String profilePicture;
    private String timeStamp;
    private String file;
}
