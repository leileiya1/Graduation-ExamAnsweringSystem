package com.sapiece.controller.exception;

import com.sapiece.entity.RestBean;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author SAPiece
 * @Create 2024-01-01 19:52
 * @Package com.sapiece.controller.exception
 * @Project GraduationDesign
 * @Filename AuthorizeController
 * @Version 1.0
 */
/**
 * 用于接口参数校验处理的控制器
 */
@Slf4j
@RestControllerAdvice
public class ValidationController {
    @ExceptionHandler(ValidationException.class)
    public RestBean<Void> validateError(ValidationException exception) {
        log.warn("Resolved [{}: {}]", exception.getClass().getName(), exception.getMessage());
        return RestBean.failure(400, "请求参数有误");
    }
}
