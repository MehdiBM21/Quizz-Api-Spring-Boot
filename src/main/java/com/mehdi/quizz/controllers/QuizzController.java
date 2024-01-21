package com.mehdi.quizz.controllers;

import com.mehdi.quizz.domain.dto.QuestionDto;
import com.mehdi.quizz.domain.entitites.Question;
import com.mehdi.quizz.domain.entitites.Quizz;
import com.mehdi.quizz.domain.entitites.Response;
import com.mehdi.quizz.services.QuizzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizz")
public class QuizzController {
    private QuizzService quizzService;
    public QuizzController(QuizzService quizzService) {
        this.quizzService = quizzService;
    }
    @PostMapping("create")
    public ResponseEntity<Quizz> createQuizz(
            @RequestParam String category,
            @RequestParam int numQ,
            @RequestParam String title){
        return new ResponseEntity<>(
                quizzService.create(category, numQ, title),
                HttpStatus.CREATED);
    }
    @GetMapping(path = "/getQuizzQuestions/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizzQuestions(
            @PathVariable("id") Integer id){
        return new ResponseEntity<>(
                quizzService.getQuizzQuestions(id),
                HttpStatus.OK);
    }
    @PostMapping("submit/{id}")
    //returns the score(n) correct answers
    public ResponseEntity<Integer> submitQuizz(
            @PathVariable Integer id,
            @RequestBody List<Response> responses){

        return new ResponseEntity<>(
                quizzService.calculateResult(id, responses),
                HttpStatus.OK);
    }
}
