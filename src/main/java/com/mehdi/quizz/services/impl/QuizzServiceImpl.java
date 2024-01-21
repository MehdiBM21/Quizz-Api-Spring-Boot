package com.mehdi.quizz.services.impl;

import com.mehdi.quizz.domain.dto.QuestionDto;
import com.mehdi.quizz.domain.entitites.Question;
import com.mehdi.quizz.domain.entitites.Quizz;
import com.mehdi.quizz.domain.entitites.Response;
import com.mehdi.quizz.repositories.QuestionRepository;
import com.mehdi.quizz.repositories.QuizzRepository;
import com.mehdi.quizz.services.QuizzService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizzServiceImpl implements QuizzService {
    private QuestionRepository questionRepository;
    private QuizzRepository quizzRepository;
    public QuizzServiceImpl(QuestionRepository questionRepository, QuizzRepository quizzRepository) {
        this.questionRepository = questionRepository;
        this.quizzRepository = quizzRepository;
    }
    @Override
    public Quizz create(String category, int numQ, String title) {
        List<Question> questions = questionRepository.
                findRandomQuestionsByCategory(category, numQ);
        Quizz quizz = new Quizz();
        quizz.setTitle(title);
        quizz.setQuestions(questions);

        return quizzRepository.save(quizz);
    }

    @Override
    public List<QuestionDto> getQuizzQuestions(Integer id) {
        Optional<Quizz> quizz = quizzRepository.findById(id);
        //not optimal, check the optional if present!!
        List<Question> questions = quizz.get().getQuestions();
        List<QuestionDto> questionsDto = new ArrayList<>();
        questionsDto.forEach(question -> {
            questionsDto.add(
                    new QuestionDto(question.getId(),
                            question.getQuestionTitle(),
                            question.getOption1(),
                            question.getOption2(),
                            question.getOption3(),
                            question.getOption4()));
        });
        return questionsDto;
    }

    @Override
    public Integer calculateResult(Integer id, List<Response> responses) {
        //not optimal, check the optional if present!!
        Quizz quizz = quizzRepository.findById(id).get();
        List<Question> questions = quizz.getQuestions();
        int right = 0;
        int i =0;
        for(Response response : responses) {
            if (questions.get(i).getRightAnswer().equals(response.getResponse())) {
                right += 1;
            }
            i++;
        }
        return right;
    }
}
