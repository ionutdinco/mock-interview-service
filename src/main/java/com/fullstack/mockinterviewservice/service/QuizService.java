package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.QuizNotificationEntity;
import com.fullstack.mockinterviewservice.model.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService{
    Quiz addQuiz(Quiz quiz);

    List<Quiz> getByEmail(String email);

    void addQuizNotification(Object email, List<Long> id);

    QuizNotificationEntity getNotQuizByEmail(String email);

    Quiz getQuizById(String id);

    Integer checkAnswers(Boolean[][] checkboxArray, String id);
}
