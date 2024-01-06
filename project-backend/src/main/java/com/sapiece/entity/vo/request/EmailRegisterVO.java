package com.sapiece.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Author SAPiece
 * @Create 2023-12-29 13:33
 * @Package com.sapiece.entity.vo.request
 * @Project GraduationDesign
 * @Filename EmailRegisterVO
 * @Version 1.0
 */
@Data
public class EmailRegisterVO {
    @Email
    String email;
    @Length(max = 6, min = 6)
    String code;
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$")
    @Length(min = 1, max = 10)
    String username;
    @Length(min = 6, max = 20)
    String password;
    @Length(max = 11)
    String iphone;
    int age;
}