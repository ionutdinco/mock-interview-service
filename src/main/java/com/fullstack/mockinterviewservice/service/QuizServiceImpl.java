package com.fullstack.mockinterviewservice.service;

import com.fullstack.mockinterviewservice.entity.QuizEntity;
import com.fullstack.mockinterviewservice.entity.QuizNotificationEntity;
import com.fullstack.mockinterviewservice.model.Question;
import com.fullstack.mockinterviewservice.model.Quiz;
import com.fullstack.mockinterviewservice.repository.ContactRepository;
import com.fullstack.mockinterviewservice.repository.QuizNotifyRepository;
import com.fullstack.mockinterviewservice.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizNotifyRepository quizNotifyRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        QuizEntity quizEntity = new QuizEntity();
        BeanUtils.copyProperties(quiz, quizEntity);
        log.info("quiz:{}\nquizEntity:{}",quiz, quizEntity);
        quizEntity = quizRepository.save(quizEntity);
        log.info("\nquizEntity22222222:{}", quizEntity);

        quiz.setId(quizEntity.getId());
        return quiz;
    }

    @Override
    public List<Quiz> getByEmail(String email) {
        List<QuizEntity> quizzes = quizRepository.getByEmail(email);
        return quizzes.stream().map((quizEntity -> Quiz
                        .builder()
                        .title(quizEntity.getTitle())
                        .timer(quizEntity.getTimer())
                        .id(quizEntity.getId())
                        .questions(quizEntity.getQuestions())
                        .build()))
                .toList();
    }

    @Override
    public void addQuizNotification(Object email, List<Long> id) {
        Optional<QuizNotificationEntity> quizNotification = quizNotifyRepository.findByEmail(email);
        if (quizNotification.isEmpty()) {
            List<Optional<QuizEntity>> quizEntities = id.stream().map(key -> quizRepository.findById(key)).toList();
            log.info("quizEntities:{}", quizEntities);
            QuizNotificationEntity quizNotificationEntity = QuizNotificationEntity.builder()
                    .email(email.toString())
                    .timeStamp(new Date().toString())
                    .quizEntity(quizEntities.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList()))
                    .build();
            quizNotifyRepository.save((quizNotificationEntity));
        }else{
            List<QuizEntity> quizEntities = id.stream().map(key -> quizRepository.findById(key)).filter(Optional::isPresent).map(Optional::get).toList();
            quizEntities.forEach(quizEntity -> quizNotification.get().getQuizEntity().add(quizEntity));
        }

    }

    @Override
    public QuizNotificationEntity getNotQuizByEmail(String email) {
        Optional<QuizNotificationEntity> quiz = quizNotifyRepository.findByEmail(email);
        return quiz.orElse(null);
    }

    @Override
    public Quiz getQuizById(String id) {
        Optional<QuizEntity> quizEntity = quizRepository.findById(Long.parseLong(id));
        Quiz quiz = new Quiz();
        quizEntity.ifPresent(entity -> BeanUtils.copyProperties(entity, quiz));
        return quiz;
    }

    @Override
    public Integer checkAnswers(Boolean[][] checkboxArray, String id) {
        Optional<QuizEntity> quizEntity = quizRepository.findById(Long.parseLong(id));
        int correctAnswers = -1;
        if (quizEntity.isPresent()){
            List<Question> result = quizEntity.get().getQuestions();
            correctAnswers = result.size();
            for (int i = 0; i < result.size(); i++){
                var ans = result.get(i).getAnswersTypes();
                for (int j = 0; j< ans.size(); j++){
                     if ((!ans.get(j) && checkboxArray[i][j]) || (ans.get(j) && !checkboxArray[i][j])){
                         correctAnswers -= 1;
                         break;
                     }
                }
            }

        }
        return correctAnswers;
    }

}
