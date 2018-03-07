-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `itemid` int(11) NOT NULL,
  `itemname` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`itemid`),
  KEY `category_idx` (`category`),
  CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `inventorymain` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'vishal ruled','Book 100ps','24',20),(2,'vishal unruled','Book 100ps','24',15),(3,'navneet ruled','Book 100ps','24',25),(4,'navneet','Book 100ps','25',20),(5,'papergrid long','Book 100ps','25',40),(6,'Navneet Ruled long','Book 100ps','25',30),(7,'Naveent Short unruled','Book 100ps','25',20),(8,'Naveent Short 4line','Book 100ps','25',25),(9,'Navneet Ruled','Books 200ps','25',40),(10,'navneet unruled','Books 200ps','25',30),(11,'papergrid unruled','Books 200ps','25',50),(12,'navneet Long ruled','Books 200ps','23',40),(13,'ceilo tape small','other stationary','25',20),(14,'ceilo tape Large','other stationary','10',30),(15,'file binders large','other stationary','10',40),(16,'Stick Binders','other stationary','25',20),(17,'1st yeat set','Eng Book Set','50',2000),(18,'2nd year cse set','Eng Book Set','20',2200),(19,'3rd year cse sets','Eng Book Set','10',1500),(20,'2nd year eee sets','Eng Book Set','25',2300),(21,'3rd year eee sets','Eng Book Set','25',3000),(22,'renolds gel','Pens Set','20',25),(23,'renolds ball','Pens Set','25',20),(24,'Add Gel','Pens Set','15',20),(25,'clicking ball','Pens Set','20',10),(26,'techno tip','Pens Set','20',10),(30,'SCR','other stationary','20',25);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventorymain`
--

DROP TABLE IF EXISTS `inventorymain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventorymain` (
  `type` varchar(20) NOT NULL,
  `most` int(11) NOT NULL,
  `minvalue` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventorymain`
--

LOCK TABLES `inventorymain` WRITE;
/*!40000 ALTER TABLE `inventorymain` DISABLE KEYS */;
INSERT INTO `inventorymain` VALUES ('Book 100ps',200,0),('Books 200ps',100,0),('Eng Book Set',200,0),('other stationary',100,0),('Pens Set',100,0);
/*!40000 ALTER TABLE `inventorymain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `recipt` decimal(11,0) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `total` int(10) DEFAULT NULL,
  `dop` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (9849044886,'mohan',60,'2018-02-28');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactionmain`
--

DROP TABLE IF EXISTS `transactionmain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactionmain` (
  `recepit` decimal(11,0) DEFAULT NULL,
  `itemid` int(20) DEFAULT NULL,
  `units` int(10) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `dop` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactionmain`
--

LOCK TABLES `transactionmain` WRITE;
/*!40000 ALTER TABLE `transactionmain` DISABLE KEYS */;
INSERT INTO `transactionmain` VALUES (9849044886,1,1,20,'2018-02-28'),(9849044886,2,1,15,'2018-02-28'),(9849044886,3,1,25,'2018-02-28');
/*!40000 ALTER TABLE `transactionmain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bookstore'
--

--
-- Dumping routines for database 'bookstore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-07  7:36:25
