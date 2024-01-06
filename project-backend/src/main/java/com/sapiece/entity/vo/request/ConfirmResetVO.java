package com.sapiece.entity.vo.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Author SAPiece
 * @Create 2023-12-29 13:32
 * @Package com.sapiece.entity.vo.response
 * @Project GraduationDesign
 * @Filename ConfirmResetVO
 * @Version 1.0
 */

@Data
@AllArgsConstructor
public class ConfirmResetVO {
    @Email
    String email;
    @Length(max = 6, min = 6)
    String code;
}
