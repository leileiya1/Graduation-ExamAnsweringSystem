package com.sapiece;

import com.sapiece.question.mapper.ExamsMapper;
import com.sapiece.question.mapper.QuestionMapper;
import com.sapiece.question.service.ExamsService;
import com.sapiece.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectBackendApplicationTests {
    @Resource
    AccountMapper accountMapper;
    @Autowired
    ExamsMapper examsMapper;
    @Resource
    ExamsService examsService;
    @Resource
    QuestionMapper questionsMapper;

    @Test
    void test() {

    }

}
