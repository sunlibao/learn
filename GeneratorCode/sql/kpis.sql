/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : hrmdev

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-08-31 10:24:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kpis
-- ----------------------------
DROP TABLE IF EXISTS `kpis`;
CREATE TABLE `kpis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID KPI 主键',
  `title` varchar(500) DEFAULT NULL COMMENT 'KPI标题',
  `epmid` bigint(20) DEFAULT NULL COMMENT '绩效id',
  `taskname` text COMMENT '绩效任务内容',
  `taskresult` varchar(4000) DEFAULT NULL COMMENT '绩效结果',
  `target` varchar(4000) DEFAULT NULL COMMENT 'kpi 目标',
  `resource` varchar(4000) DEFAULT NULL COMMENT '绩效评测数据来源',
  `efunction` text COMMENT '绩效评测使用工程',
  `mevaluate` text COMMENT '经理评价',
  `evaluate` text COMMENT '员工自评',
  `score` float DEFAULT NULL COMMENT '打分值',
  `niveau` varchar(50) DEFAULT NULL  COMMENT '等级',
  `taux` int(11) DEFAULT NULL  COMMENT '占百分比',
  `priority` varchar(50) DEFAULT NULL  COMMENT '紧急性',
  `imprtance` varchar(50) DEFAULT NULL  COMMENT '重要性',
  `weighting` float DEFAULT NULL COMMENT '百分比对应分值',
  `year` tinyint(4) DEFAULT NULL COMMENT '年份',
  `flagkpi` int(255) DEFAULT NULL COMMENT '是否邀请打分 0未邀请 1邀请',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `createuser` varchar(255) DEFAULT NULL COMMENT '创建人',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `flag` int(255) DEFAULT NULL COMMENT '岗位段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for kpilog
-- ----------------------------
DROP TABLE IF EXISTS `kpilog`;
CREATE TABLE `kpilog` (
  `id` int(11) NOT NULL,
  `kpiid` int(11) DEFAULT NULL COMMENT '变更kpiid',
  `epmid` int(11) DEFAULT NULL COMMENT '绩效id',
  `title` varchar(400) DEFAULT NULL COMMENT '变更标题',
  `content` varchar(4000) DEFAULT NULL COMMENT '变更内容',
  `taux` int(255) DEFAULT NULL COMMENT '变更比值',
  `efunction` varchar(2000) DEFAULT NULL COMMENT '变更公式',
  `resource` varchar(2000) DEFAULT NULL COMMENT '变更数据源',
  `target` varchar(2000) DEFAULT NULL COMMENT '目标',
  `modifyusername` varchar(255) DEFAULT NULL COMMENT '变更人的用户名',
  `type` varchar(255) DEFAULT NULL COMMENT '变更类型',
  `createtime` datetime DEFAULT NULL COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for epm
-- ----------------------------
DROP TABLE IF EXISTS `epm`;
CREATE TABLE `epm` (
  `id` int(11) NOT NULL COMMENT '主键 绩效id',
  `sdate` datetime NOT NULL COMMENT '岗位开始时间',
  `edate` datetime NOT NULL COMMENT '岗位结束时间',
  `eusername` varchar(255) DEFAULT NULL COMMENT '岗位员工用户名',
  `ename` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `staffcode` varchar(255) DEFAULT NULL COMMENT '员工用户编码',
  `mstaffcode` varchar(255) DEFAULT NULL COMMENT '经理用户编码',
  `epositioncode` varchar(255) NOT NULL COMMENT '员工岗位编码',
  `edpostion` varchar(255) DEFAULT NULL COMMENT '员工岗位名称',
  `edepartmentname` varchar(255) DEFAULT NULL COMMENT '员工部门名称',
  `edepartcode` varchar(255) DEFAULT NULL COMMENT '员工部门编码',
  `museranme` varchar(255) DEFAULT NULL COMMENT '经理用户名',
  `mname` varchar(255) DEFAULT NULL COMMENT '经理姓名',
  `mpositioncode` varchar(255) DEFAULT NULL COMMENT '经理岗位编码',
  `mdposition` varchar(255) DEFAULT NULL COMMENT '经理岗位名称',
  `mdepartmentname` varchar(255) DEFAULT NULL COMMENT '经理部门',
  `mdepartcode` varchar(255) DEFAULT NULL COMMENT '经理部门编码',
  `weights` double(10,0) DEFAULT NULL COMMENT '经理绩效打分（总体打分+Kpi打分总和）',
  `niveau` varchar(255) DEFAULT NULL COMMENT '经理评分等级（达到期望、卓越杰出、有待提高、不适岗、亟需改进、超出预期）',
  `weights1` double(10,0) DEFAULT NULL COMMENT '经理KPI打分总和',
  `weights2` double(10,0) DEFAULT NULL COMMENT '经理个人自述打分',
  `status` varchar(255) DEFAULT NULL COMMENT '绩效状态（未提交、待经理指派评审人员、待经理审核、待评审人员评价、待员工确认、已完成确认、已完成反馈）',
  `kpistatus` varchar(255) DEFAULT NULL COMMENT 'KPI状态 （0 待员工填写 1待经理审核 2经理审核 3员工撤回 4经理退回）',
  `peersstatus` int(255) DEFAULT NULL COMMENT '邀请同僚状态（0 待员工邀请 1待经理审核 2审核提交）',
  `mainposition` varchar(255) DEFAULT NULL COMMENT '主岗标志位',
  `modifytime` datetime DEFAULT NULL COMMENT '绩效更改时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `eevaluate` varchar(4000) DEFAULT NULL COMMENT '个人自述岗位绩效目标',
  `evalueted` text COMMENT '个人自述岗位结果',
  `mpip` text COMMENT '经理期望',
  `mevalueted` text COMMENT '经理绩效评价',
  `pip` text COMMENT 'PIP改进计划（当分数低时员工编写）',
  `rentong` varchar(255) DEFAULT NULL COMMENT '员工是否认同经理打分标识位',
  `meid` int(255) DEFAULT NULL COMMENT '绩效段id(与mangertime表id相关联)',
  `Flag` int(255) DEFAULT '0' COMMENT '删除标志位 0正常 1删除',
  `Type` int(255) DEFAULT '0' COMMENT '绩效类型（0 普通绩效考核 1岗位变更考核【hr触发】）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for epmpeers
-- ----------------------------
DROP TABLE IF EXISTS `epmpeers`;
CREATE TABLE `epmpeers` (
  `id` int(11) NOT NULL COMMENT '同僚评价id',
  `epmid` int(11) DEFAULT NULL COMMENT '绩效id',
  `type` int(255) DEFAULT NULL COMMENT '邀请类型 0 邀请同僚评价 1邀请同僚打分',
  `weights` double DEFAULT NULL COMMENT '同僚评价打分',
  `evalueted` text COMMENT '同僚评价',
  `stauts` varchar(255) DEFAULT NULL COMMENT '同僚评价状态',
  `flag` varchar(255) DEFAULT NULL COMMENT '标志位',
  `niveau` varchar(255) DEFAULT NULL COMMENT '评分等级',
  `peersname` varchar(255) DEFAULT NULL COMMENT '同僚姓名',
  `peersusername` varchar(255) DEFAULT NULL COMMENT '同僚用户名',
  `createuserename` varchar(255) DEFAULT NULL COMMENT '创建者用户名',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  `positioncode` varchar(255) DEFAULT NULL COMMENT '被邀请人岗位',
  `dpostion` varchar(2000) DEFAULT NULL COMMENT '被邀请人岗位名称',
  `company` varchar(2000) DEFAULT NULL COMMENT '被邀请人公司',
  `departmentname` varchar(2000) DEFAULT NULL COMMENT '被邀请人部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for epmshare
-- ----------------------------
DROP TABLE IF EXISTS `epmshare`;
CREATE TABLE `epmshare` (
  `id` int(11) NOT NULL COMMENT '主键',
  `kpiid` int(11) DEFAULT NULL COMMENT 'kpiid',
  `username` varchar(255) DEFAULT NULL COMMENT 'kpi分享员工用户名',
  `name` varchar(255) DEFAULT NULL COMMENT 'kpi分享员工姓名',
  `positioncode` varchar(255) DEFAULT NULL COMMENT 'kpi分享员工岗位编码',
  `dpostion` varchar(2000) DEFAULT NULL COMMENT 'kpi分享员工岗位名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类型预留',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `flag` varchar(255) DEFAULT NULL COMMENT '标志位',
  `mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



