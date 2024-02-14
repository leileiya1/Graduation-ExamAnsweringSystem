package com.sapiece.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sapiece.entity.dto.Question;
import com.sapiece.question.mapper.QuestionMapper;
import com.sapiece.question.service.QuestionService;
import com.sapiece.util.Const;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author SAPiece
 * @Create 2023-11-18 20:06
 * @Package com.sapiece.question.service.impl.impl
 * @Project GraduationDesign
 * @Filename QuestionsServiceImpl
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    /**
     * 按顺序抽取并随机化不同类型题目的主方法。
     * @return 按顺序随机化后的题目列表。
     */
    public List<Question> fetchAndRandomizeQuestions() {
        List<Question> allQuestions = new ArrayList<>();

        // 按照固定顺序和数量抽取不同类型的题目
        allQuestions.addAll(fetchAndProcessQuestions("single_choice", Const.SINGLE_CHOICE));
        allQuestions.addAll(fetchAndProcessQuestions("multiple_choice", Const.MULTIPLE_CHOICE));
        allQuestions.addAll(fetchAndProcessQuestions("fill_in_the_blank", Const.FILL_IN_THE_BLANK));
        allQuestions.addAll(fetchAndProcessQuestions("essay", Const.ESSAY));

        // 返回所有抽取和处理过的题目
        return allQuestions;
    }

    /**
     * 抽取并处理指定类型和数量的题目。
     * @param type 题目类型。
     * @param count 抽取数量。
     * @return 处理后的题目列表。
     */
    public List<Question> fetchAndProcessQuestions(String type, int count) {
        List<Question> questions = fetchRandomQuestions(type, count);
        if ("single_choice".equals(type) || "multiple_choice".equals(type)) {
            randomizeOptionsAndAnswers(questions, "multiple_choice".equals(type));
        }
       // markQuestionsAsSelected(questions);增进功能到时候可以让所有人的题目不一样
        return questions;
    }

    /**
     * 随机抽取指定类型和数量的题目。
     * @param type 题目类型。
     * @param count 抽取数量。
     * @return 随机抽取的题目列表。
     */
    public List<Question> fetchRandomQuestions(String type, int count) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type)
                .eq("is_selected", false)
                .last("ORDER BY RAND() LIMIT " + count);

        return questionMapper.selectList(queryWrapper);
    }

    /**
     * 批量更新题目状态为已选。
     * @param questions 题目列表。
     * 后面传入是否考试字段进行打乱不能相同直接加一个判断把isSelected设置为true即可
     */
    public void markQuestionsAsSelected(List<Question> questions) {
        List<Integer> questionIds = questions.stream().map(Question::getQuestionId).toList();
//        if (!questionIds.isEmpty()) {
//            questionMapper.batchUpdateIsSelected(questionIds,false);
//        }
    }

    /**
     * 随机化选项和答案。
     * @param questions 题目列表。
     * @param isMultipleChoice 是否为多选题。
     */
    public void randomizeOptionsAndAnswers(List<Question> questions, boolean isMultipleChoice) {
        for (Question question : questions) {
            if (question.getOptions() != null && !question.getOptions().isEmpty()) {
                // 分割选项，并保留标签（如 A, B, C, D）
                List<String> optionsList = new ArrayList<>(Arrays.asList(question.getOptions().split(",")));

                // 只随机化答案文本部分，保留标签顺序
                List<String> shuffledAnswers = optionsList.stream()
                        .map(opt -> opt.substring(opt.indexOf('.') + 1).trim())
                        .collect(Collectors.toList());
                Collections.shuffle(shuffledAnswers);

                // 重新组合标签和随机化的答案文本
                for (int i = 0; i < optionsList.size(); i++) {
                    String label = optionsList.get(i).substring(0, optionsList.get(i).indexOf('.')).trim();
                    optionsList.set(i, label + "." + shuffledAnswers.get(i));
                }

                Map<String, String> answerMap = createAnswerMap(optionsList);
                question.setAnswer(updateCorrectAnswer(answerMap, question.getAnswer(), isMultipleChoice));

                String shuffledOptions = String.join(",", optionsList);
                question.setOptions(shuffledOptions);
            }
        }
    }

    /**
     * 创建答案映射。
     * @param options 选项列表。
     * @return 选项文本到标签的映射。
     */
    public Map<String, String> createAnswerMap(List<String> options) {
        Map<String, String> answerMap = new HashMap<>();
        for (String option : options) {
            String[] parts = option.split("\\.", 2);
            String key = parts[0].trim(); // 选项标签，如 "A"
            String value = parts[1].trim(); // 答案文本，如 "答案一"
            answerMap.put(value, key);
        }
        return answerMap;
    }

    /**
     * 更新正确答案以匹配随机化的选项。
     * @param answerMap 答案映射。
     * @param correctAnswer 正确答案。
     * @param isMultipleChoice 是否为多选题。
     * @return 更新后的正确答案。
     */
    public String updateCorrectAnswer(Map<String, String> answerMap, String correctAnswer, boolean isMultipleChoice) {
        if (isMultipleChoice) {
            // 分割多选题答案，假设答案是 "答案一.答案二" 这样的格式
            String[] answers = correctAnswer.split("\\."); // 分割答案
            return Arrays.stream(answers)
                    .map(String::trim) // 去除空格
                    .map(answerMap::get) // 映射到标签
                    .filter(Objects::nonNull) // 过滤空值
                    .sorted() // 根据标签顺序排序答案
                    .collect(Collectors.joining("."));
        } else {
            // 单选题：答案是单个答案文本
            return answerMap.getOrDefault(correctAnswer.trim(), "");
        }
    }


}
