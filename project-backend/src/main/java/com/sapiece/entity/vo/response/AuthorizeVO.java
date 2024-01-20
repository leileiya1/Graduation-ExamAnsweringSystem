package com.sapiece.entity.vo.response;

import lombok.Data;

import java.util.Date;

/**
 * @Author SAPiece
 * @Create 2023-11-08 13:02
 * @Package com.sapiece.entity.vo.response
 * @Project GraduationDesign
 * @Filename AuthorizeVO
 * @Version 1.0
 */
@Data
public class AuthorizeVO {
    private Integer id;
    String username;
    String role;
    String token;
    Date expire;

}
