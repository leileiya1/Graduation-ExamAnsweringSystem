package com.sapiece.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sapiece.entity.dto.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:01
 * @Package com.sapiece.user.mapper
 * @Project GraduationDesign
 * @Filename AccountMapper
 * @Version 1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
