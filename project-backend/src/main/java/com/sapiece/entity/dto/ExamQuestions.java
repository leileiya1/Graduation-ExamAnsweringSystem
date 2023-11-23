package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:42
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename ExamQuestions
 * @Version 1.0
 */
@TableName("exam_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamQuestions {
    @TableId(type = IdType.AUTO)
    private Exams examId;
    private Question questionId;
}
