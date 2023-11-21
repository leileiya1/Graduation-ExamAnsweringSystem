package com.sapiece.question.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sapiece.entity.dto.Account;
import com.sapiece.entity.dto.ExamResult;
import com.sapiece.question.mapper.ExamResultMapper;
import com.sapiece.question.service.ExamResultService;
import com.sapiece.user.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @Author SAPiece
 * @Create 2023-11-18 20:07
 * @Package com.sapiece.question.service.impl.impl
 * @Project GraduationDesign
 * @Filename ExamResultServiceImpl
 * @Version 1.0
 */
@Service
public class ExamResultServiceImpl extends ServiceImpl<ExamResultMapper, ExamResult> implements ExamResultService {
}
