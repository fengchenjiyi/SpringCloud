/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL COMMENT '城市ID''',
  `city_name` varchar(16) DEFAULT NULL COMMENT '城市名称',
  `city_code` varchar(32) DEFAULT NULL COMMENT '城市拼音',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `weather_data` text COMMENT '天气数据',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`city_id`,`city_name`,`city_code`,`province`,`weather_data`) values (101280101,'广州','guangzhou','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 32℃\",\"fx\":\"东北风\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[3-4级]]>\",\"type\":\"中雨\"},\"city\":\"广州\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东北风\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"中到大雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东风\",\"type\":\"大雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东南风\",\"type\":\"暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"南风\",\"type\":\"暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"30\"},\"status\":1000,\"desc\":\"OK\"}'),(101280102,'番禺','panyu','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 32℃\",\"fx\":\"东北风\",\"low\":\"低温 26℃\",\"fl\":\"<![CDATA[3-4级]]>\",\"type\":\"中雨\"},\"city\":\"番禺\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东北风\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"暴雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"大到暴雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东南风\",\"type\":\"暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"南风\",\"type\":\"暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"31\"},\"status\":1000,\"desc\":\"OK\"}'),(101280105,'花都','huadu','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 32℃\",\"fx\":\"东北风\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[3-4级]]>\",\"type\":\"中雨\"},\"city\":\"花都\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东北风\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"暴雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"大到暴雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东南风\",\"type\":\"暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"南风\",\"type\":\"暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"30\"},\"status\":1000,\"desc\":\"OK\"}'),(101280201,'韶关','shaoguan','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 32℃\",\"fx\":\"无持续风向\",\"low\":\"低温 24℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"阵雨\"},\"city\":\"韶关\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 23℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阴\"},{\"date\":\"4日星期三\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"大雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"31\"},\"status\":1000,\"desc\":\"OK\"}'),(101280501,'汕头','shantou','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 33℃\",\"fx\":\"东风\",\"low\":\"低温 27℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"多云\"},\"city\":\"汕头\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 33℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 27℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"东南风\",\"type\":\"雷阵雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"南风\",\"type\":\"大雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"南风\",\"type\":\"中雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"32\"},\"status\":1000,\"desc\":\"OK\"}'),(101280601,'深圳','shenzhen','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 29℃\",\"fx\":\"无持续风向\",\"low\":\"低温 26℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"阵雨\"},\"city\":\"深圳\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东南风\",\"type\":\"雷阵雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[6-7级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东南风\",\"type\":\"大到暴雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[5-6级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"南风\",\"type\":\"大暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"南风\",\"type\":\"暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"30\"},\"status\":1000,\"desc\":\"OK\"}'),(101280701,'珠海','zhuhai','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 30℃\",\"fx\":\"东风\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[3-4级]]>\",\"type\":\"阵雨\"},\"city\":\"珠海\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东北风\",\"type\":\"阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东北风\",\"type\":\"大雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"北风\",\"type\":\"中雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"南风\",\"type\":\"中雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"南风\",\"type\":\"大雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"30\"},\"status\":1000,\"desc\":\"OK\"}'),(101280800,'佛山','foshan','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 31℃\",\"fx\":\"无持续风向\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"大雨\"},\"city\":\"佛山\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东南风\",\"type\":\"大到暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"30\"},\"status\":1000,\"desc\":\"OK\"}'),(101281501,'潮州','chaozhou','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 33℃\",\"fx\":\"无持续风向\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"中雨\"},\"city\":\"潮州\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 33℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"东风\",\"type\":\"大雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 28℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"33\"},\"status\":1000,\"desc\":\"OK\"}'),(101281601,'东莞','dongguan','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 30℃\",\"fx\":\"无持续风向\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"阵雨\"},\"city\":\"东莞\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"无持续风向\",\"type\":\"中到大雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[5-6级]]>\",\"low\":\"低温 24℃\",\"fengxiang\":\"南风\",\"type\":\"暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[5-6级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"南风\",\"type\":\"大到暴雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"31\"},\"status\":1000,\"desc\":\"OK\"}'),(101281903,'普宁','puning','广东','{\"data\":{\"yesterday\":{\"date\":\"2日星期一\",\"high\":\"高温 32℃\",\"fx\":\"无持续风向\",\"low\":\"低温 25℃\",\"fl\":\"<![CDATA[<3级]]>\",\"type\":\"阵雨\"},\"city\":\"普宁\",\"forecast\":[{\"date\":\"3日星期二\",\"high\":\"高温 32℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"4日星期三\",\"high\":\"高温 31℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"雷阵雨\"},{\"date\":\"5日星期四\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"东南风\",\"type\":\"阵雨\"},{\"date\":\"6日星期五\",\"high\":\"高温 29℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 25℃\",\"fengxiang\":\"无持续风向\",\"type\":\"大到暴雨\"},{\"date\":\"7日星期六\",\"high\":\"高温 30℃\",\"fengli\":\"<![CDATA[<3级]]>\",\"low\":\"低温 26℃\",\"fengxiang\":\"无持续风向\",\"type\":\"阵雨\"}],\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"wendu\":\"32\"},\"status\":1000,\"desc\":\"OK\"}');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
