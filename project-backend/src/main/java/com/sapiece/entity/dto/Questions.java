package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:39
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename Questions
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("questions")
public class Questions {
    @TableId(type = IdType.AUTO)
    private Integer questionId;
    private String type;
    private String content;
    private String options;
    private String answer;
}
