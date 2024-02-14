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

 Date: 14/02/2024 10:15:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exams
-- ----------------------------
DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams`  (
  `exam_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `test_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`exam_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exams
-- ----------------------------
INSERT INTO `exams` VALUES (1, 'wangwu', '2024-01-14 10:37:28');
INSERT INTO `exams` VALUES (52, 'admin', '2024-01-16 17:27:16');
INSERT INTO `exams` VALUES (53, 'admin', '2024-01-17 12:48:32');
INSERT INTO `exams` VALUES (54, 'admin', '2024-01-17 15:15:56');
INSERT INTO `exams` VALUES (55, 'admin', '2024-01-17 18:32:03');
INSERT INTO `exams` VALUES (56, 'admin', '2024-01-19 09:34:51');
INSERT INTO `exams` VALUES (57, 'admin', '2024-01-19 09:35:45');

SET FOREIGN_KEY_CHECKS = 1;
