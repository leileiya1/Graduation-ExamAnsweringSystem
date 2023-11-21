package com.sapiece.question.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sapiece.entity.dto.Account;
import com.sapiece.entity.dto.ScoreAnalysis;
import com.sapiece.question.mapper.ScoreAnalysisMapper;
import com.sapiece.question.service.ScoreAnalysisService;
import com.sapiece.user.mapper.AccountMapper;
import org.springframework.stereotype.Service;

/**
 * @Author SAPiece
 * @Create 2023-11-18 20:05
 * @Package com.sapiece.question.service.impl.impl
 * @Project GraduationDesign
 * @Filename ScoreAnalysisImpl
 * @Version 1.0
 */
@Service
public class ScoreAnalysisServiceImpl extends ServiceImpl<ScoreAnalysisMapper,ScoreAnalysis> implements ScoreAnalysisService {
}
