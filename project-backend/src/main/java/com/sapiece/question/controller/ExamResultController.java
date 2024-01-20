package com.sapiece.question.controller;

import com.sapiece.entity.dto.ExamResult;
import com.sapiece.question.mapper.ExamResultMapper;
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
 * @Create 2024-01-17 16:47
 * @Package com.sapiece.question.controller
 * @Project GraduationDesign
 * @Filename ExamResultController
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/test-data")
@Tag(name = "考试信息", description = "用户考试信息和考试成绩")
public class ExamResultController {
    @Resource
    ExamResultMapper examResultMapper;

    @GetMapping("/user-test-data")
    @Operation(summary = "用户的考试信息的提取")
    public ResponseEntity<List<ExamResult>> loadUserTestData() {
        List<ExamResult> examResults = examResultMapper.selectList(null);
        return ResponseEntity.ok(examResults);
    }
}
