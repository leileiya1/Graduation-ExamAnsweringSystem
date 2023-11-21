package com.sapiece.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sapiece.entity.dto.Account;
import com.sapiece.entity.dto.Questions;
import com.sapiece.question.mapper.QuestionsMapper;
import com.sapiece.question.service.QuestionsService;
import com.sapiece.user.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @Author SAPiece
 * @Create 2023-11-18 20:06
 * @Package com.sapiece.question.service.impl.impl
 * @Project GraduationDesign
 * @Filename QuestionsServiceImpl
 * @Version 1.0
 */
@Service
public class QuestionsServiceImpl extends ServiceImpl<QuestionsMapper, Questions> implements QuestionsService {
}
