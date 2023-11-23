package com.sapiece;

import com.sapiece.entity.dto.Question;
import com.sapiece.question.mapper.QuestionMapper;
import com.sapiece.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectBackendApplicationTests {
    @Resource
    AccountMapper accountMapper;
@Resource
QuestionMapper questionsMapper;
    @Test
    void contextLoads() {
        List<Question> questions = questionsMapper.selectList(null);
        questions.forEach(System.out::println);
    }

}
