package com.sapiece;

import com.sapiece.entity.dto.Account;
import com.sapiece.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ProjectBackendApplicationTests {
    @Resource
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
        Account account = accountMapper.selectById(1);
        System.out.println(account);
    }

}
