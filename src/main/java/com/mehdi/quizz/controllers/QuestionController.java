package com.mehdi.quizz.controllers;

import com.mehdi.quizz.domain.entitites.Question;
import com.mehdi.quizz.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    private QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService=questionService;
    }
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> listAllQuestions(){
        return new ResponseEntity<>(questionService.listAllQuestions(), HttpStatus.OK);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> listQuestionsByCategory(
            @PathVariable("category") String category){
        return new ResponseEntity<>(
                questionService.listQuestionsByCategory(category),
                HttpStatus.OK);
    }
    @PostMapping("addQuestions")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(
                questionService.addQuestion(question),
                HttpStatus.CREATED);
    }



}
