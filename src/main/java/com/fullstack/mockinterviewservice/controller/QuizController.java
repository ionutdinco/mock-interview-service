package com.fullstack.mockinterviewservice.controller;

import com.fullstack.mockinterviewservice.entity.QuizNotificationEntity;
import com.fullstack.mockinterviewservice.model.Quiz;
import com.fullstack.mockinterviewservice.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/quiz")
@Slf4j
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz newQuiz = quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getQuiz(@RequestParam String email){
        List<Quiz> quizzes = quizService.getByEmail(email);
        return ResponseEntity.ok(quizzes);
    }

    @PostMapping("/notification")
    public ResponseEntity<Boolean> addQuizNotification(@RequestParam Map<String, Object> requestParams){
        log.info("email:{},ID:{}",requestParams.get("email"), Arrays.asList(requestParams.get("id")));
        quizService.addQuizNotification(requestParams.get("email"), Stream.of(requestParams.get("id")).mapToLong(num -> Long.parseLong((String) num)).boxed().collect(Collectors.toList()));
        return ResponseEntity.ok(true);
    }

    @GetMapping("/notification")
    public ResponseEntity<QuizNotificationEntity> getQuizNotifications(@RequestParam String email){
        QuizNotificationEntity quizNotificationEntities = quizService.getNotQuizByEmail(email);
        return ResponseEntity.ok(quizNotificationEntities);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String id){
        log.info("id-{}", id);
        Quiz quiz = quizService.getQuizById(id);
        log.info("quiz-{}", quiz);

        return ResponseEntity.ok(quiz);
    }

    @PostMapping("/verify")
    public ResponseEntity<Integer> verifyAnswers(@RequestBody Boolean[][] checkboxArray, @RequestParam String id){
        Integer answers = quizService.checkAnswers(checkboxArray, id);
        return ResponseEntity.ok(answers);
    }
}
