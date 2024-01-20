package com.sapiece.question.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author SAPiece
 * @Create 2024-01-19 9:19
 * @Package com.sapiece.question.aspect
 * @Project GraduationDesign
 * @Filename QuestionLog
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class QuestionLogging {
    @Pointcut("execution(* com.sapiece.question.controller.QuestionController.*(..))")
    public void questionLogging() {
    }

    @After("questionLogging()")
    public void testRecord(JoinPoint joinPoint) {
        System.out.println("我输出咯");
        Object[] args = joinPoint.getArgs();
        System.out.println("相关信息:" + Arrays.toString(args));
    }
}
