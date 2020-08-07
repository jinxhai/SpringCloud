/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : cloud

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-08-07 11:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '尚硅谷');
INSERT INTO `payment` VALUES ('2', 'alibaba');
INSERT INTO `payment` VALUES ('3', '京东');
INSERT INTO `payment` VALUES ('4', '头条');
INSERT INTO `payment` VALUES ('5', '1111');
INSERT INTO `payment` VALUES ('6', 'xxxx');
INSERT INTO `payment` VALUES ('7', 'wwwww');
