package com.sapiece.question.controller;

import com.sapiece.entity.RestBean;
import com.sapiece.entity.dto.ExamResult;
import com.sapiece.entity.dto.ExamSubmission;
import com.sapiece.entity.dto.Exams;
import com.sapiece.entity.dto.Question;
import com.sapiece.question.service.ExamResultService;
import com.sapiece.question.service.ExamsService;
import com.sapiece.question.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
@Tag(name = "题库拉取", description = "试题的获取和考试成绩的录入")
public class QuestionController {
    @Resource
    private QuestionService questionsService;
    @Resource
    private ExamsService examsService;
    @Resource
    private ExamResultService resultService;

    @GetMapping("/fetch")
    @Operation(summary = "随机拉取问题")
    public ResponseEntity<List<Question>> fetchQuestions() {
        List<Question> questions = questionsService.fetchAndRandomizeQuestions();
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/result-submission")
    @Operation(summary = "将用户的成绩和考试时间输入数据库并保存")
    public RestBean<Void> insertScoreAndRecord(@RequestBody ExamSubmission examSubmission) {
        Exams exams = examSubmission.getExams();
        ExamResult result = examSubmission.getResult();
        boolean examsRecord = examsService.saveOrUpdate(exams);
        boolean resultRecord = resultService.saveOrUpdate(result);
        return examsRecord && resultRecord ? RestBean.success() : RestBean.failure(400, "更新失败");
    }

}
