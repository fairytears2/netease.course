﻿# Host: 127.0.0.1  (Version: 5.7.22-log)
# Date: 2018-09-14 13:59:40
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "blog"
#

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blogId` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客Id',
  `blogTitle` varchar(10) DEFAULT NULL COMMENT '博客标题',
  `blogContent` varchar(100) DEFAULT NULL COMMENT '博客内容',
  `nowDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`blogId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "blog"
#

INSERT INTO `blog` VALUES (1,'admin','admin','2018-08-22 17:58:59.832'),(2,'LLLLL','DSADAS','2018-08-22 22:30:24.178');

#
# Structure for table "content"
#

DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` bigint(20) DEFAULT NULL COMMENT '当前价格',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `icon` blob COMMENT '图片',
  `abstract` varchar(200) DEFAULT NULL COMMENT '摘要',
  `text` blob COMMENT '正文',
  `num` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

#
# Data for table "content"
#

INSERT INTO `content` VALUES (14,2800,'洗衣液',X'68747470733A2F2F6764322E616C6963646E2E636F6D2F696D6765787472612F69342F323730303739363937362F5442323171327A70566F6F424B4E6A535A506858586332435858615F2121323730303739363937362E6A70675F343030783430302E6A7067','依金香',X'354B47E5AEB6E5BAADE5AE9EE683A0E8A385E68AA4E8A1A3E68AA4E889B2E896B0E8A1A3E88D8933E58C85E982AEE68AA4E8A1A3E68AA4E889B2E5AE9EE683A0E8A385','100'),(15,3000,'清开灵颗粒',X'68747470733A2F2F696D672E616C6963646E2E636F6D2F696D6765787472612F69342F323932383237383130322F544232467938724A71535742754E6A53737262585861306D5658615F2121323932383237383130322D322D6974656D5F7069632E706E675F343330783433307139302E6A7067','白云山清开灵颗粒10g*10袋治疗上呼吸道感染 病毒性感冒药 咽喉炎',X'E59381E7898CE5908DE7A7B0EFBC9AE799BDE4BA91E5B1B10D0AE4BAA7E59381E58F82E695B0EFBC9A0D0AE4BAA7E59381E5908DE7A7B0EFBC9AE799BDE4BA91E5B1B120E6B885E5BC80E781B5E9A297E7B292203130672A312E2E2EE4BAA7E59381E58982E59E8B3A20E9A297E7B292E4BDBFE794A8E58982E9878F3A20E4B880E6ACA1312D32E8A28BEFBC8CE4B880E697A5322D33E6ACA1E59381E7898C3A20E799BDE4BA91E5B1B1E5A597E9A490E7B1BBE59E8B3A20E6A087E58786E8A38531E79B922031E79B92E69CACE593812BE889BEE982A6E58CBBE794A8E6A389E7ADBE3530E694AF20E69CACE5938131E79B922BE9B1BCE8B783E4BD93E6B8A9E8AEA15954333036E69C89E69588E69C9F3A203234E4B8AAE69C88E794A8E6B3953A20E58FA3E69C8DE88DAFE59381E58886E7B1BB3A20E99D9EE5A484E696B9E88DAFE88DAFE59381E5908DE7A7B03A20E6B885E5BC80E781B5E9A297E7B292E88DAFE59381E59586E59381E5908D3A20E6B885E5BC80E781B5E9A297E7B292E88DAFE59381E9809AE794A8E5908D3A20E6B885E5BC80E781B5E9A297E7B292E689B9E58786E69687E58FB73A20E59BBDE88DAFE58786E5AD975A3130393530303838E7949FE4BAA7E4BC81E4B89A3A20E5B9BFE5B79EE799BDE4BA91E5B1B1E6988EE585B4E588B6E88DAFE69C89E99990E585ACE58FB8E8A784E6A0BC3A203130672A3130E5B08FE8A28B2FE58C85E7B1BBE588AB3A20E4B8ADE88DAF','100'),(16,16800,'笔记本电池',X'68747470733A2F2F696D672E616C6963646E2E636F6D2F696D6765787472612F69332F323431373438313330362F54423265427333766D306D7075466A535A506958586273735658615F2121323431373438313330362E6A70675F343330783433307139302E6A7067','CMP 宏基4750g 4752g 4741g 5750g 4743g 4738g E1-471G AS10D31笔记本电池',X'E59381E7898CE5908DE7A7B0EFBC9A434D50EFBC88E695B0E7A081EFBC890D0AE4BAA7E59381E58F82E695B0EFBC9A0D0AE59381E7898C3A20434D50EFBC88E695B0E7A081EFBC89E59E8BE58FB73A20343734314236433332E7949FE4BAA7E4BC81E4B89A3A20E6B7B1E59CB3E5B882E6989FE58D8EE68EA7E882A1E882A1E4BBBDE585ACE58FB8E794B5E6B1A0E5AEB9E9878F3A20363730306D4168E594AEE5908EE69C8DE58AA13A20E5BA97E993BAE4B889E58C85E698AFE590A6E58E9FE8A3853A20E59381E7898CE585BCE5AEB9E794B5E6B1A0E98082E794A8E59381E7898C3A20416365722FE5AE8FE7A281','100'),(17,7140,'羊绒T恤',X'68747470733A2F2F6764322E616C6963646E2E636F6D2F696D6765787472612F69332F323130333538373331362F5442323663446667566D5742754E6A5373706458586275675858615F2121323130333538373331362E6A70675F343030783430302E6A70675F2E77656270','春季2018新款时尚圆领舒适百搭基础款短袖上衣女',X'D0E4B3A43A20B6CCD0E4BBF5BAC53A203634313633203634313634203634313635203634313631B7FED7B0B0E6D0CD3A20BFEDCBC9D2C2B3A43A20B3A3B9E6BFEEC1ECD0CD3A20D4B2C1ECD0E4D0CD3A20B3A3B9E6C6B7C5C63A206A7570652076656E647565B3C9B7D6BAACC1BF3A20333025BCB0D2D4CFC2C3E6C1CF3A20D1F2C8DECDBCB0B83A20B4BFC9ABCACAD3C3C4EAC1E43A2031382D3234D6DCCBEAB7E7B8F13A20CCF0C3C0CCF0C3C03A20C8F0C0F6C4EAB7DDBCBEBDDA3A2032303138C4EAB4BABCBED6F7D2AAD1D5C9AB3A20BADABBD2C9AB20D0A1B6B9C9AB20D0A1BCA6BBC620C5AFE9D9C9AB20DDBAB2E8C9ABB3DFC2EB3A2053204D204C','100');

#
# Structure for table "person"
#

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码md5加密',
  `nickName` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `userType` tinyint(3) DEFAULT NULL COMMENT '类型，买家0，卖家1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "person"
#

INSERT INTO `person` VALUES (0,'buyer','reyub','buyer',0),(1,'seller','relles','seller',1),(2,'liyuming','123456','liyuming',0),(3,'liyushun','123456','liyushun',1);

#
# Structure for table "trx"
#

DROP TABLE IF EXISTS `trx`;
CREATE TABLE `trx` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contentId` int(11) DEFAULT NULL COMMENT '内容ID',
  `personId` int(11) DEFAULT NULL COMMENT '用户ID',
  `price` int(11) DEFAULT NULL COMMENT '购买价格',
  `time` bigint(20) DEFAULT NULL COMMENT '购买时间',
  `num` varchar(255) DEFAULT NULL,
  `isbuy` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "trx"
#

INSERT INTO `trx` VALUES (1,NULL,2,NULL,NULL,NULL,NULL),(2,NULL,2,NULL,NULL,NULL,NULL),(3,NULL,2,NULL,NULL,NULL,NULL),(4,NULL,2,NULL,NULL,NULL,NULL),(5,17,2,NULL,NULL,NULL,NULL),(6,17,2,NULL,NULL,NULL,NULL),(7,17,2,NULL,NULL,NULL,NULL);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(100) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'test1','test1'),(2,'test2','test2'),(3,'liyuming','123456');
