/*
 Navicat Premium Data Transfer

 Source Server         : linux
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : 192.168.100.137:3306
 Source Schema         : graduation_design

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 14/02/2024 10:15:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score_analysis
-- ----------------------------
DROP TABLE IF EXISTS `score_analysis`;
CREATE TABLE `score_analysis`  (
  `analysis_id` int NOT NULL AUTO_INCREMENT COMMENT '分析主键',
  `exam_id` int NULL DEFAULT NULL COMMENT '题目主键',
  `average_score` decimal(5, 2) NULL DEFAULT NULL COMMENT '平均成绩',
  `max_score` int NULL DEFAULT NULL COMMENT '最高分',
  `min_score` int NULL DEFAULT NULL COMMENT '最低分',
  PRIMARY KEY (`analysis_id`) USING BTREE,
  INDEX `exam_id`(`exam_id` ASC) USING BTREE,
  CONSTRAINT `score_analysis_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_analysis
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
