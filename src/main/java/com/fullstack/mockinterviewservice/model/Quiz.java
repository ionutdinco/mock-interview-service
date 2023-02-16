package com.fullstack.mockinterviewservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {
    private Long id;
    private String email;
    private String title;
    private String timer;
    private List<Question> questions;

}
