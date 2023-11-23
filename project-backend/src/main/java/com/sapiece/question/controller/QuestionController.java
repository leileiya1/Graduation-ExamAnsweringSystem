package com.sapiece.question.controller;

import com.sapiece.entity.dto.Question;
import com.sapiece.question.service.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2023-11-23 17:04
 * @Package com.sapiece.question.controller
 * @Project GraduationDesign
 * @Filename QuestionsController
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Resource
    private QuestionService questionsService;
    @GetMapping("/fetch")
    public ResponseEntity<List<Question>> fetchQuestions(){
        List<Question> questions = questionsService.fetchAndRandomizeQuestions();
        return ResponseEntity.ok(questions);
    }

}
