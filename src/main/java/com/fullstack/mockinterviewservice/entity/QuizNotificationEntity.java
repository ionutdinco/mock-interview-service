package com.fullstack.mockinterviewservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizNotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String timeStamp;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private List<QuizEntity> quizEntity;

}
