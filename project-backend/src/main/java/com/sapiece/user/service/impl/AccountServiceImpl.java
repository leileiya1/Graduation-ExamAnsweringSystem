package com.sapiece.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sapiece.entity.dto.Account;
import com.sapiece.user.mapper.AccountMapper;
import com.sapiece.user.service.AccountService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:03
 * @Package com.sapiece.user.service
 * @Project GraduationDesign
 * @Filename AccountServiceImpl
 * @Version 1.0
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.findByUsernameOrEmail(username);
        if (account==null) {
            throw  new UsernameNotFoundException("用户名账号或密码错误");
        }
        return User
                .withUsername(username)
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

    @Override
    public Account findByUsernameOrEmail(String text) {
        return this.query()
                .eq("username", text).or()
                .eq("email", text).one();
    }
}
