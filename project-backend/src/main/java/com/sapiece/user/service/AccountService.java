package com.sapiece.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sapiece.entity.dto.Account;
import com.sapiece.entity.vo.request.ConfirmResetVO;
import com.sapiece.entity.vo.request.EmailRegisterVO;
import com.sapiece.entity.vo.request.EmailResetVO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author SAPiece
 * @Create 2023-11-18 19:02
 * @Package com.sapiece.user.service
 * @Project GraduationDesign
 * @Filename AccountService
 * @Version 1.0
 */
public interface AccountService extends IService<Account> , UserDetailsService {
    Account findByUsernameOrEmail(String text);
    String registerEmailVerifyCode(String type, String email, String address);
    String registerEmailAccount(EmailRegisterVO info);
    String resetEmailAccountPassword(EmailResetVO info);
    String resetConfirm(ConfirmResetVO info);
}
