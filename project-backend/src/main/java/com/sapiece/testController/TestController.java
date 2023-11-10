package com.sapiece.testController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author SAPiece
 * @Create 2023-11-10 16:52
 * @Package com.sapiece.testController
 * @Project GraduationDesign
 * @Filename TestController
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/hello")
    public String test(){
        return "Hello world";
    }
}
