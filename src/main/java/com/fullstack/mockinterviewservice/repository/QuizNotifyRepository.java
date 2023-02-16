package com.fullstack.mockinterviewservice.repository;

import com.fullstack.mockinterviewservice.entity.QuizNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizNotifyRepository extends JpaRepository<QuizNotificationEntity, Long> {
    Optional<QuizNotificationEntity> findByEmail(Object email);

    List<QuizNotificationEntity> findAllByEmail(String email);
}
