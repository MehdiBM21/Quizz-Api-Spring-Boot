package com.mehdi.quizz.services;

import com.mehdi.quizz.domain.entitites.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    List<Question> listAllQuestions();

    List<Question> listQuestionsByCategory(String category);

    Question addQuestion(Question question);
}
