package com.mehdi.quizz.services;

import com.mehdi.quizz.domain.dto.QuestionDto;
import com.mehdi.quizz.domain.entitites.Question;
import com.mehdi.quizz.domain.entitites.Quizz;
import com.mehdi.quizz.domain.entitites.Response;

import java.util.List;

public interface QuizzService {
    Quizz create(String category, int numQ, String title);

    List<QuestionDto> getQuizzQuestions(Integer id);

    Integer calculateResult(Integer id, List<Response> responses);
}
