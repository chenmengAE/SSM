/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : springmvc

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 21/02/2023 14:19:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `productid` int(0) NOT NULL AUTO_INCREMENT,
  `productname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `inventory` int(0) NULL DEFAULT NULL,
  `description` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`productid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (15, '一', 122.00, 223, '大奖赛');
INSERT INTO `t_product` VALUES (18, '二', 122.00, 221, '案件覅大家佛');
INSERT INTO `t_product` VALUES (19, '三', 123.00, 223, '很发达');
INSERT INTO `t_product` VALUES (20, '四', 23.00, 112, '大风日期');
INSERT INTO `t_product` VALUES (21, '五', 33.00, 231, '放假啊骄傲i');
INSERT INTO `t_product` VALUES (22, '六', 21.00, 233, '很符合我国');
INSERT INTO `t_product` VALUES (23, '七', 43.00, 445, '工业污染规划');
INSERT INTO `t_product` VALUES (24, '八', 21.00, 441, '放假放假且');
INSERT INTO `t_product` VALUES (25, '九', 11.00, 331, '返回求复合');
INSERT INTO `t_product` VALUES (26, '十', 22.00, 233, '附件二穷富');
INSERT INTO `t_product` VALUES (27, '十一', 32.00, 221, '高级外交官');
INSERT INTO `t_product` VALUES (28, '十二', 122.00, 333, '十二');
INSERT INTO `t_product` VALUES (29, '十三', 22.00, 4123, '十三');
INSERT INTO `t_product` VALUES (30, '十四', 33.00, 221, '十四');
INSERT INTO `t_product` VALUES (31, '十五', 332.00, 2312, '十五');
INSERT INTO `t_product` VALUES (32, '十六', 221.00, 233, '十六');
INSERT INTO `t_product` VALUES (33, '十七', 21.00, 489, '十七');
INSERT INTO `t_product` VALUES (34, '十八', 34.00, 223, '十八');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'hkd1', '1123');
INSERT INTO `t_user` VALUES (2, 'hkd2', '1233');
INSERT INTO `t_user` VALUES (3, 'root', '123');

SET FOREIGN_KEY_CHECKS = 1;
