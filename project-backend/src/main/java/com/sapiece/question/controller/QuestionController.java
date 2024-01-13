package com.sapiece.question.controller;

import com.sapiece.entity.dto.Question;
import com.sapiece.question.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "题库拉取",description = "试题的获取和考试成绩的录入")
public class QuestionController {
    @Resource
    private QuestionService questionsService;
    @GetMapping("/fetch")
    @Operation(summary = "随机拉取问题")
    public ResponseEntity<List<Question>> fetchQuestions(){
        List<Question> questions = questionsService.fetchAndRandomizeQuestions();
        return ResponseEntity.ok(questions);
    }

}
