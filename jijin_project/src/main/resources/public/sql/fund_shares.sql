/*
Navicat MySQL Data Transfer

Source Server         : ga
Source Server Version : 50719
Source Host           : 10.9.50.25:3306
Source Database       : gapark

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-07 16:04:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fund_shares
-- ----------------------------
DROP TABLE IF EXISTS `fund_shares`;
CREATE TABLE `fund_shares` (
  `fund_id` varchar(8) DEFAULT NULL,
  `shares_name` varchar(20) DEFAULT NULL,
  `holding_ratio` decimal(5,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fund_shares
-- ----------------------------
