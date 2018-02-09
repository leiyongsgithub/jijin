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
DROP TABLE IF EXISTS `data_fund_share`;
CREATE TABLE `data_fund_share` (
  `fund_id` varchar(8) DEFAULT NULL COMMENT '基金code',
  `fund_name` varchar(20) DEFAULT NULL COMMENT '基金名称',
  `top_10` tinyint(1) DEFAULT NULL COMMENT '前10:0否 1是',
  `date` date DEFAULT NULL COMMENT '统计日期',
  `share_id` varchar(8) DEFAULT NULL COMMENT '股票code',
  `share_name` varchar(20) DEFAULT NULL COMMENT '股票名称',
  `holding_ratio` decimal(4,4) DEFAULT NULL COMMENT '持有率'
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of temp_excel
-- ----------------------------
