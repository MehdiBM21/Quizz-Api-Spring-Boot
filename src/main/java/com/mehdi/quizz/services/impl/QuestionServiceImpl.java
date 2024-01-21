package com.mehdi.quizz.services.impl;

import com.mehdi.quizz.domain.entitites.Question;
import com.mehdi.quizz.repositories.QuestionRepository;
import com.mehdi.quizz.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    @Override
    public List<Question> listAllQuestions() {
        return questionRepository.findAll();
    }
}
