package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:42
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename Exams
 * @Version 1.0
 */
@TableName("exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exams {
    @TableId(type = IdType.AUTO)
    private Integer examId;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime testTime;
}
