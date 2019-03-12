-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrator` (
  `login_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `img` varchar(100) NOT NULL,
  `adm_id` varchar(20) NOT NULL,
  PRIMARY KEY (`login_name`),
  KEY `fk_id_idx` (`adm_id`),
  CONSTRAINT `fk_id` FOREIGN KEY (`adm_id`) REFERENCES `staff` (`stf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('admin','123456','/res/images/avatar/9.jpg','201901'),('admin2','123456','/res/images/avatar/1.jpg','201902');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(45) NOT NULL,
  `sort` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `press` varchar(45) NOT NULL,
  `img` varchar(45) NOT NULL,
  `synopsis` text,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'红楼梦','古典文学','曹雪芹','1楼12列03层A面','人民出版社','/res/images/book/红楼梦.jpg','《红楼梦》是一部百科全书式的长篇小说。以宝黛爱情悲剧为主线，以四大家族的荣辱兴衰为背景，描绘出18世纪中国封建社会的方方面面，以及封建专制下新兴资本主义民主思想的萌动。结构宏大、情节委婉、细节精致，人物形象栩栩如生，声口毕现，堪称中国古代小说中的经典。'),(2,'水浒传','古典文学','施耐庵','1楼07列05层B面','人民出版社','/res/images/book/水浒传.jpg','《水浒传》是一部长篇英雄传奇，是中国古代长篇小说的代表作之一，是以宋江起义故事为线索创作出来的。全书以宋江领导的农民起义为主要题材，艺术地再现了中国古代人民反抗压迫、英勇斗争的悲壮画卷。作品充分暴露了封建统治阶级的腐朽和残暴，揭露了当时尖锐对立的社会矛盾和“官逼民反”的残酷现实，成功地塑造了鲁智深、李逵、武松、林冲、阮小七等一批英雄人物。'),(3,'三国演义','古典文学','罗贯中','1楼08列05层A面','人民出版社','/res/images/book/三国演义.jpg','《三国演义》是中国古典四大名著之一，是中国第一部长篇章回体历史演义小说，描写了从东汉末年到西晋初年之间近百年的历史风云，以描写战争为主，诉说了东汉末年的群雄割据混战和魏、蜀、吴三国之间的政治和军事斗争，最终司马炎一统三国，建立晋朝的故事。反映了三国时代各类社会斗争与矛盾的转化，并概括了这一时代的历史巨变，塑造了一群叱咤风云的三国英雄人物。');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `spread` char(1) DEFAULT '0',
  `sort` int(11) DEFAULT NULL,
  `is_top` varchar(1) DEFAULT '0',
  `del_flag` char(1) DEFAULT '0',
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,75,'内容管理','fa-desktop',NULL,'0',1,'1','0',1),(2,75,'其他管理','fa-cog','','0',2,'1','0',1),(3,1,'我的面板','fa-television','','0',2,'0','0',2),(4,3,'个人信息','fa-vcard-o','/admin/personInfo.do','0',1,'0','0',3),(5,3,'修改密码','fa-gear','/admin/pwd.do','0',2,'0','0',3),(6,1,'信息设置','fa-cogs',NULL,'0',3,'0','0',2),(7,6,'学生管理','fa-user','/student/list.do','0',1,'0','0',3),(8,6,'书籍管理','fa-book','/book/list.do','0',2,'0','0',3),(9,6,'职工管理','fa-user-plus','/staff/list.do','0',3,'0','0',3),(10,1,'功能管理','fa-suitcase',NULL,'0',3,'0','0',2),(11,10,'菜品识别','fa-bitbucket','/ai/dish/list.do','0',1,'0','0',3);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `stf_id` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` char(2) NOT NULL,
  `department` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `job_date` date NOT NULL,
  `phone` char(11) NOT NULL,
  PRIMARY KEY (`stf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('201901','张三丰','男','武当学院','掌门人','2019-01-01','18812341234'),('201902','李四','男','第一临床医学院','管理员','2019-01-01','158xxxxxxxx');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `stu_id` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` char(2) NOT NULL,
  `university` varchar(45) NOT NULL,
  `college` varchar(45) NOT NULL,
  `major` varchar(45) NOT NULL,
  `stu_class` varchar(10) NOT NULL,
  `entry_date` date NOT NULL,
  `phone` char(11) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('2019100','小李','女','XX大学','AAA学院','计算机科学与技术','1班','2016-09-01','18812341234'),('2019101','小王','男','XX大学','AAA学院','计算机科学与技术','2班','2016-09-01','18812341234'),('2019102','小赵','男','XX大学','CCC学院','英语','3班','2016-09-01','18812341234'),('2019103','小钱','女','XX大学','CCC学院','西班牙语','2班','2017-09-01','18812341234'),('2019104','小孙','男','XX大学','CCC学院','市场营销','1班','2018-09-01','18812341234'),('2019105','小周','男','XX大学','BBB学院','临床医学','2班','2018-09-01','18812341234');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11 16:55:57
