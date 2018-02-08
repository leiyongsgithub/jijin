/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jijin

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-08 21:28:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for temp_excel
-- ----------------------------
DROP TABLE IF EXISTS `temp_excel`;
CREATE TABLE `temp_excel` (
  `fund_id` varchar(8) DEFAULT NULL COMMENT '基金code',
  `fund_name` varchar(20) DEFAULT NULL,
  `top_10` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `shares_id` varchar(8) DEFAULT NULL,
  `shares_name` varchar(20) DEFAULT NULL,
  `holding_ratio` decimal(4,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of temp_excel
-- ----------------------------
