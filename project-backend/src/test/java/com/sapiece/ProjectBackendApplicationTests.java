package com.sapiece;

import com.sapiece.entity.dto.Question;
import com.sapiece.question.mapper.QuestionMapper;
import com.sapiece.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class ProjectBackendApplicationTests {
    @Resource
    AccountMapper accountMapper;
@Resource
QuestionMapper questionsMapper;
    @Test
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
