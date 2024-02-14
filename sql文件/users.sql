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

 Date: 14/02/2024 10:15:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `register_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `unique_name`(`username` ASC) USING BTREE,
  UNIQUE INDEX `unique_phone`(`phone` ASC) USING BTREE,
  UNIQUE INDEX `unique_email`(`email` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'sapiece', '$2a$10$W9c6GUFUjc3j2dy76d32zOy5YeH71yRiX/nwhFi16XwAAXJ7Hycoq', 'admin', 'ogawadaichi@gmail.com', '28-210-6893', 28, '2023-11-18 18:42:01');
INSERT INTO `users` VALUES (13, 'admin', '$2a$10$FAXo.PtbAd.8CKby4hqd2OKN1j4UKtv0SI1HCxzoWux.df1bMXSbG', 'admin', '123456@qq.com', NULL, 19, '2024-01-05 09:14:57');
INSERT INTO `users` VALUES (17, 'lose', '$2a$10$4BfWD7LBI3kcE8ySq104HOJo12b.A0L4O35Nx4dejoDD6lo9cVwQu', 'user', '2433589029@qq.com', NULL, 0, '2024-01-05 09:14:36');

SET FOREIGN_KEY_CHECKS = 1;
