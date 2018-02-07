/*
Navicat MySQL Data Transfer

Source Server         : ga
Source Server Version : 50719
Source Host           : 10.9.50.25:3306
Source Database       : gapark

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-07 16:05:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shares_ratio
-- ----------------------------
DROP TABLE IF EXISTS `shares_ratio`;
CREATE TABLE `shares_ratio` (
  `shares_name` varchar(20) DEFAULT NULL,
  `holding_ratio` decimal(5,4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shares_ratio
-- ----------------------------
