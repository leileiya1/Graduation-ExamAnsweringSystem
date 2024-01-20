package com.sapiece.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author SAPiece
 * @Create 2023-11-18 18:56
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename Account
 * @Version 1.0
 */
@TableName("users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;
    private Integer age;
    private LocalDate registerTime;
    private byte[] avatar; // BLOB字段用户头像
}
