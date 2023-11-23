package com.sapiece.question.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sapiece.entity.dto.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:57
 * @Package com.sapiece.question.mapper
 * @Project GraduationDesign
 * @Filename Questions
 * @Version 1.0
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    void batchUpdateIsSelected(@Param("questionIds") List<Integer> questionIds, @Param("isSelected") boolean isSelected);
}
