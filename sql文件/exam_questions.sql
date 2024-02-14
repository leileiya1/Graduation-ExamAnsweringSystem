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

 Date: 14/02/2024 10:14:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_questions
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions`;
CREATE TABLE `exam_questions`  (
  `exam_id` int NOT NULL,
  `question_id` int NOT NULL,
  PRIMARY KEY (`exam_id`, `question_id`) USING BTREE,
  INDEX `question_id`(`question_id` ASC) USING BTREE,
  CONSTRAINT `exam_questions_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exam_questions_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_questions
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
