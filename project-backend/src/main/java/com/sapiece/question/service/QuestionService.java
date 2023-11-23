package com.sapiece.question.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sapiece.entity.dto.Question;

import java.util.List;
import java.util.Map;

/**
 * @Author SAPiece
 * @Create 2023-11-18 20:05
 * @Package com.sapiece.question.service.impl
 * @Project GraduationDesign
 * @Filename QuestionsService
 * @Version 1.0
 */
public interface QuestionService extends IService<Question> {
    List<Question> fetchAndRandomizeQuestions();
    List<Question> fetchAndProcessQuestions(String type, int count);
    List<Question> fetchRandomQuestions(String type, int count);
    void markQuestionsAsSelected(List<Question> questions);
    void randomizeOptionsAndAnswers(List<Question> questions, boolean isMultipleChoice);
    Map<String, String> createAnswerMap(List<String> options);
    String updateCorrectAnswer(Map<String, String> answerMap, String correctAnswer, boolean isMultipleChoice);
}
