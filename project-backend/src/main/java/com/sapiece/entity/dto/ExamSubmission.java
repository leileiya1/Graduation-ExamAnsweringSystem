package com.sapiece.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;

/**
 * @Author SAPiece
 * @Create 2024-01-14 9:38
 * @Package com.sapiece.entity.dto
 * @Project GraduationDesign
 * @Filename ExamSubmission
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamSubmission {
    private Exams exams;
    private ExamResult result;
}
