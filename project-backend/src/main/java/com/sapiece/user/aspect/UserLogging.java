package com.sapiece.user.aspect;

import jakarta.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

@Log4j2
@Component
public class UserLogging {
    private static final Logger userOperationLogger = LogManager.getLogger("UserOperationLogger");

    @Pointcut("execution(* com.sapiece.user.controller.AuthorizeController.*(..))")
    public void userPointCut() {
    }

    /**
     * 这段代码用于在系统中记录用户的操作。它使用SecurityContextHolder获取当前身份验证用户的名称，
     * 并使用JoinPoint获取调用的方法。然后将此信息记录到userOperationLogger中。
     *
     * @param point JoinPoint对象，它包含有关调用的方法的信息
     */
    @After("userPointCut()")
    public void userAroundAdvice(@NotNull JoinPoint point) {
        String user = getCurrentUser();
        String method = point.getSignature().getName();
        userOperationLogger.info("用户:" + user + "调用了" + method + "方法");
    }

    /**
     * 这段代码用于从SecurityContextHolder获取当前身份验证用户的名称。
     *
     * @return 当前身份验证用户的名称
     */
    public String getCurrentUser() {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        return user.getName();
    }
}
