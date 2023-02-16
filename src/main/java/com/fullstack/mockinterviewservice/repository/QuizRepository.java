package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.QuizEntity;
import com.fullstack.mockinterviewservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    List<QuizEntity> getByEmail(String email);
}
