/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : ssm_zy

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 15/03/2023 23:02:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '安徒生童话', '20.00', '安徒生封面', '安徒生', '2023-03-15 18:22:00', '2023-03-15 18:22:00', 1);
INSERT INTO `book` VALUES (2, '格林童话', '35.00', '格林封面', '格林', '2023-03-15 18:22:01', '2023-03-15 18:22:01', 1);
INSERT INTO `book` VALUES (24, 'Java从入门到精通', '58', 'Java从入门到精通封面', '赵成成', '2023-03-15 18:22:01', '2023-03-15 18:22:01', 1);
INSERT INTO `book` VALUES (25, '水浒传', '23', '水浒传封面', '大大大', '2023-03-15 18:22:02', '2023-03-15 18:22:02', 1);
INSERT INTO `book` VALUES (26, '西游记4', '124', '西游记封面4', '笑笑笑4', '2023-03-15 22:53:09', '2023-03-15 22:53:09', 1);
INSERT INTO `book` VALUES (27, '红楼梦444', '444', '红楼梦封面444', '酷酷酷444', '2023-03-15 22:53:01', '2023-03-15 22:53:01', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `locked` int(10) NULL DEFAULT 0,
  `role` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 0, 1);
INSERT INTO `user` VALUES (2, '111', '111', 0, 0);
INSERT INTO `user` VALUES (3, '222', '222', 0, 0);
INSERT INTO `user` VALUES (4, '333', '333', 0, 0);
INSERT INTO `user` VALUES (5, '444', '444', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
