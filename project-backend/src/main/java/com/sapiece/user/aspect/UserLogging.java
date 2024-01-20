package com.sapiece.user.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author SAPiece
 * @Create 2024-01-19 8:42
 * @Package com.sapiece.user.aspect
 * @Project GraduationDesign
 * @Filename UserLogging
 * @Version 1.0
 */
@Aspect
@Slf4j
@Component
public class UserLogging {
    @Pointcut("execution(* com.sapiece.user.controller.AuthorizeController.*(..))")
    public void userPointCut() {}

    @After("userPointCut()")
    public void userAroundAdvice(JoinPoint joinPoint) {
        Object[] userInfo = joinPoint.getArgs();
        for (Object user : userInfo) {
            System.out.println(user);
        }
    }
}
