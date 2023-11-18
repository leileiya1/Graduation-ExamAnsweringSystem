package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.runtime.Inner;

import java.math.BigDecimal;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:43
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename ScoreAnalysis
 * @Version 1.0
 */
@TableName("score_analysis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreAnalysis {
    @TableId(type = IdType.AUTO)
    private Integer analysisId;
    private Exams examId;
    private BigDecimal averageScore;
    private Integer maxScore;
    private Integer minScore;
}
