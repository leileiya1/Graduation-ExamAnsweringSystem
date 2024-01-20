package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:42
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename ExamResult
 * @Version 1.0
 */
@TableName("exam_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
    @TableId(type = IdType.AUTO)
    private Integer resultId;
    private Integer examId;//从考试中获取
    private Integer userId;//用户的id主键方便找到该用户
    private String name;
    private String userAnswers;
    private Integer score;
    private LocalDateTime testTime;
}
