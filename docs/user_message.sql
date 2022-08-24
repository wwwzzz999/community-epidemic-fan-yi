/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : pss_db

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2020-06-20 20:11:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `userNo` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userNo`) USING BTREE,
  UNIQUE KEY `userNo` (`userNo`) USING BTREE,
  UNIQUE KEY `userName` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10025 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=4096;

-- ----------------------------
-- Records of user_message
-- ----------------------------
INSERT INTO `user_message` VALUES ('10001', '管理员', null, '123', '13411110000', null, '2017-03-15 15:23:59');
INSERT INTO `user_message` VALUES ('10002', '天天', null, '321', '13200001111', null, null);
INSERT INTO `user_message` VALUES ('10003', '月月', null, '666', null, null, null);
INSERT INTO `user_message` VALUES ('10004', '小米', null, '888', '13456789543', null, null);
INSERT INTO `user_message` VALUES ('10005', '的骷髅法师', '', '111', '', 'sdg@163.com', '2017-03-17 09:42:59');
INSERT INTO `user_message` VALUES ('10006', 'hjhv', '', '111', '', 'sdg@163.com', '2017-03-17 09:43:40');
INSERT INTO `user_message` VALUES ('10007', '2316546', '', '1024', '', 'sdg@163.com', '2017-03-17 09:43:53');
INSERT INTO `user_message` VALUES ('10008', '45867', '', '5467', '', 'sdg@163.com', '2017-03-17 09:44:04');
INSERT INTO `user_message` VALUES ('10009', '6+85', '', '56+8', '', 'sdg@163.com', '2017-03-17 09:44:13');
INSERT INTO `user_message` VALUES ('10010', '45678', '', '787', '', 'sdg@163.com', '2017-03-17 09:46:42');
INSERT INTO `user_message` VALUES ('10011', 'djkfh', '', '45785', '', 'sdg@163.com', '2017-03-17 09:46:56');
INSERT INTO `user_message` VALUES ('10012', '456762', '', '123', '', 'sdg@163.com', '2017-03-17 09:47:10');
INSERT INTO `user_message` VALUES ('10013', 'hghjh', '', 'hmmn', '', 'sdg@163.com', '2017-03-17 09:48:35');
INSERT INTO `user_message` VALUES ('10014', 'iewriotrio', '', '45675', '', 'sdg@163.com', '2017-03-17 09:48:56');
INSERT INTO `user_message` VALUES ('10015', 'lkjk', '', '21jk', '', 'sdg@163.com', '2017-03-17 09:49:14');
INSERT INTO `user_message` VALUES ('10024', 'yyyyyyy', '时高时低', '1111', '8888', '88888@qq.com', '2020-09-09 00:00:00');
