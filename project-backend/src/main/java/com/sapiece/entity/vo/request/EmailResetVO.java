package com.sapiece.entity.vo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
/**
 * @Author SAPiece
 * @Create 2023-12-29 13:34
 * @Package com.sapiece.entity.vo.request
 * @Project GraduationDesign
 * @Filename EmailResetVO
 * @Version 1.0
 */
/**
 * 密码重置表单实体
 */
@Data
public class EmailResetVO {
    @Email
    String email;
    @Length(max = 6, min = 6)
    String code;
    @Length(min = 6, max = 20)
    String password;
}