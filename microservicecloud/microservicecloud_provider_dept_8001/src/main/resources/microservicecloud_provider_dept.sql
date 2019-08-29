
CREATE DATABASE `spring_cloud_01`;

USE `spring_cloud_01`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` VARCHAR(60) DEFAULT NULL COMMENT '部门名称',
  `db_source` VARCHAR(60) DEFAULT NULL COMMENT '来自数据库名',
  PRIMARY KEY (`deptno`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

INSERT  INTO `dept`(`dname`,`db_source`) 
        VALUES ('开发部',DATABASE()),('人事部',DATABASE()),('财务部',DATABASE()),
               ('市场部',DATABASE()),('运维部',DATABASE());


