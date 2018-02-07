/*
Navicat MySQL Data Transfer

Source Server         : ga
Source Server Version : 50719
Source Host           : 10.9.50.25:3306
Source Database       : gapark

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-07 16:04:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `fund_id` varchar(8) NOT NULL,
  `fund_name` varchar(20) DEFAULT NULL,
  `top_10` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fund
-- ----------------------------
