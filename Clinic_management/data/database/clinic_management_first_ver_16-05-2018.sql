/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : clinic_management

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-05-16 19:08:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tblbill
-- ----------------------------
DROP TABLE IF EXISTS `tblbill`;
CREATE TABLE `tblbill` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `amount` decimal(65,0) NOT NULL,
  `payTime` datetime(6) NOT NULL,
  `amountPaid` decimal(65,30) NOT NULL,
  `nurseId` int(11) NOT NULL,
  `tblPatientProfileId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nurseId` (`nurseId`),
  KEY `tblPatientProfileId` (`tblPatientProfileId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblbill
-- ----------------------------

-- ----------------------------
-- Table structure for tblclinictype
-- ----------------------------
DROP TABLE IF EXISTS `tblclinictype`;
CREATE TABLE `tblclinictype` (
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblclinictype
-- ----------------------------
INSERT INTO `tblclinictype` VALUES ('HIV', '1');
INSERT INTO `tblclinictype` VALUES ('Răng miệng', '2');
INSERT INTO `tblclinictype` VALUES ('Ung thư', '3');

-- ----------------------------
-- Table structure for tblmedicinedata
-- ----------------------------
DROP TABLE IF EXISTS `tblmedicinedata`;
CREATE TABLE `tblmedicinedata` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblmedicinedata
-- ----------------------------

-- ----------------------------
-- Table structure for tblpatient
-- ----------------------------
DROP TABLE IF EXISTS `tblpatient`;
CREATE TABLE `tblpatient` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `healthInsuranceCardNumber` varchar(20) DEFAULT NULL,
  `identityCardNumber` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblpatient
-- ----------------------------
INSERT INTO `tblpatient` VALUES ('1', 'Hải Đặng', '1997-02-27', 'Male', 'VN', '123456@Hai', null);
INSERT INTO `tblpatient` VALUES ('2', 'Trung Đức', '1997-05-06', 'Male', 'Frances', 'IloveU@Duc', null);
INSERT INTO `tblpatient` VALUES ('3', 'Tuấn Malrid', '1997-12-30', 'Male', 'Ptit', 'chairman@ptit.vn', null);

-- ----------------------------
-- Table structure for tblpatientprofile
-- ----------------------------
DROP TABLE IF EXISTS `tblpatientprofile`;
CREATE TABLE `tblpatientprofile` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `examinationDate` date DEFAULT NULL,
  `examinationPrice` decimal(10,2) NOT NULL,
  `doctorId` int(11) NOT NULL,
  `tblPatientId` int(11) NOT NULL,
  `clinicResults` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `doctorId` (`doctorId`),
  KEY `tblPatientId` (`tblPatientId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblpatientprofile
-- ----------------------------
INSERT INTO `tblpatientprofile` VALUES ('1', '2018-05-13', '50000.00', '1', '1', 'Chưa đưa ra kết luận ban đầu.');

-- ----------------------------
-- Table structure for tblroom
-- ----------------------------
DROP TABLE IF EXISTS `tblroom`;
CREATE TABLE `tblroom` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `clinicType` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clinicType` (`clinicType`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblroom
-- ----------------------------
INSERT INTO `tblroom` VALUES ('1', 'Clinic Room 1', 'clinic', 'Răng miệng');
INSERT INTO `tblroom` VALUES ('4', 'Clinic Room 3', 'clinic', 'HIV');
INSERT INTO `tblroom` VALUES ('5', 'Testing Room 1', 'testing', 'Răng miệng');
INSERT INTO `tblroom` VALUES ('6', 'Testing Room 2', 'testing', 'Ung thư');
INSERT INTO `tblroom` VALUES ('7', 'Testing Room 3', 'testing', 'HIV');
INSERT INTO `tblroom` VALUES ('2', 'Clinic Room 2', 'clinic', 'Ung thư');

-- ----------------------------
-- Table structure for tblroomqueue
-- ----------------------------
DROP TABLE IF EXISTS `tblroomqueue`;
CREATE TABLE `tblroomqueue` (
  `registerTime` datetime(6) NOT NULL,
  `tblRoomId` int(11) NOT NULL,
  `tblPatientId` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `tblRoomId` (`tblRoomId`),
  KEY `tblPatientId` (`tblPatientId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblroomqueue
-- ----------------------------
INSERT INTO `tblroomqueue` VALUES ('2018-05-13 18:03:55.000000', '3', '2', '1');
INSERT INTO `tblroomqueue` VALUES ('2018-05-13 18:04:03.000000', '1', '3', '2');

-- ----------------------------
-- Table structure for tblroomschedule
-- ----------------------------
DROP TABLE IF EXISTS `tblroomschedule`;
CREATE TABLE `tblroomschedule` (
  `startTime` datetime(6) DEFAULT NULL,
  `endTime` datetime(6) DEFAULT NULL,
  `tblUserId` int(11) NOT NULL,
  `tblRoomId` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `tblUserId` (`tblUserId`),
  KEY `tblRoomId` (`tblRoomId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblroomschedule
-- ----------------------------
INSERT INTO `tblroomschedule` VALUES ('2018-05-13 18:36:25.000000', '2018-05-19 18:36:29.000000', '1', '3', '1');
INSERT INTO `tblroomschedule` VALUES ('2018-05-13 18:37:13.000000', '2018-05-19 18:37:15.000000', '2', '6', '2');

-- ----------------------------
-- Table structure for tbltestingdata
-- ----------------------------
DROP TABLE IF EXISTS `tbltestingdata`;
CREATE TABLE `tbltestingdata` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `testingRoomId` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `testingRoomId` (`testingRoomId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbltestingdata
-- ----------------------------
INSERT INTO `tbltestingdata` VALUES ('1', 'Thử máu', '100000.00', '6', null);
INSERT INTO `tbltestingdata` VALUES ('2', 'Thử nước tiểu', '100000.00', '6', null);

-- ----------------------------
-- Table structure for tblusedmedicine
-- ----------------------------
DROP TABLE IF EXISTS `tblusedmedicine`;
CREATE TABLE `tblusedmedicine` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `quantity` smallint(6) NOT NULL,
  `amount` decimal(65,30) NOT NULL,
  `tblMedicineDataId` int(11) NOT NULL,
  `tblPatientProfileId` int(11) NOT NULL,
  `isPaid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tblMedicineDataId` (`tblMedicineDataId`),
  KEY `tblPatientProfileId` (`tblPatientProfileId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblusedmedicine
-- ----------------------------

-- ----------------------------
-- Table structure for tblusedtesting
-- ----------------------------
DROP TABLE IF EXISTS `tblusedtesting`;
CREATE TABLE `tblusedtesting` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `quantity` smallint(6) NOT NULL,
  `amount` decimal(65,0) NOT NULL,
  `tblTestingDataId` int(11) NOT NULL,
  `tblPatientProfileId` int(11) NOT NULL,
  `isPaid` int(11) NOT NULL,
  `testResults` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tblTestingDataId` (`tblTestingDataId`),
  KEY `tblPatientProfileId` (`tblPatientProfileId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tblusedtesting
-- ----------------------------
INSERT INTO `tblusedtesting` VALUES ('1', '1', '100000', '1', '1', '0', 'fine');
INSERT INTO `tblusedtesting` VALUES ('2', '1', '100000', '2', '1', '0', '100 m/a');

-- ----------------------------
-- Table structure for tbluser
-- ----------------------------
DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `position` varchar(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbluser
-- ----------------------------
INSERT INTO `tbluser` VALUES ('1', 'Lê Lợi', '1997-08-08', 'Male', 'Ptit', 'doctor', 'leloi', 'c56d0e9a7ccec67b4ea131655038d604');
INSERT INTO `tbluser` VALUES ('2', 'Bảo Chiến', '1997-01-01', 'Male', 'P205 B5', 'doctor', 'baochien', 'c56d0e9a7ccec67b4ea131655038d604');
INSERT INTO `tbluser` VALUES ('3', 'Đỗ Tuấn', '1997-05-05', 'Male', 'VN', 'receptionist', 'dotuan', 'c56d0e9a7ccec67b4ea131655038d604');
INSERT INTO `tbluser` VALUES ('4', 'Dương Vũ', '1997-06-06', 'Male', 'Frances', 'accountant', 'duongvu', 'c56d0e9a7ccec67b4ea131655038d604');
SET FOREIGN_KEY_CHECKS=1;
