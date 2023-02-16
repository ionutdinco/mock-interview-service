package com.fullstack.mockinterviewservice.entity;

import com.fullstack.mockinterviewservice.model.Question;
import com.fullstack.mockinterviewservice.model.Quiz;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String title;
    private String timer;
    @ElementCollection
    private List<Question> questions;
}
