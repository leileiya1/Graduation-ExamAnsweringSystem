package com.sapiece;

import com.sapiece.question.mapper.ExamsMapper;
import com.sapiece.question.mapper.QuestionMapper;
import com.sapiece.question.service.ExamsService;
import com.sapiece.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;

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
        String filePath = "src/main/java/com/sapiece/store/img/sapiece.png";  // 替换为图片的路径
        File file = new File(filePath);
        byte[] fileContent = new byte[(int) file.length()];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            inputStream.read(fileContent);

            // 将二进制数据转换为十六进制字符串
            try (Formatter formatter = new Formatter()) {
                for (byte b : fileContent) {
                    formatter.format("%02x", b);
                }
                System.out.println("我的二进制是:"+formatter.toString()); // 输出十六进制字符串
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
