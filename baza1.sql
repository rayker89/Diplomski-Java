-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 194.106.163.103    Database: asterisk
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.10-MariaDB

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
-- Table structure for table `CALL_MONITOR`
--

DROP TABLE IF EXISTS `CALL_MONITOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CALL_MONITOR` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PHONE_ALIAS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CALL_MONITOR`
--

LOCK TABLES `CALL_MONITOR` WRITE;
/*!40000 ALTER TABLE `CALL_MONITOR` DISABLE KEYS */;
/*!40000 ALTER TABLE `CALL_MONITOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CALL_MONITORING_LOG`
--

DROP TABLE IF EXISTS `CALL_MONITORING_LOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CALL_MONITORING_LOG` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `START_TIME` date DEFAULT NULL,
  `END_TIME` date DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `TECHNICAL_PARAM` varchar(100) DEFAULT NULL,
  `RESOLVED` int(11) DEFAULT NULL,
  `ACTION` varchar(200) DEFAULT NULL,
  `OUTCOME` varchar(100) DEFAULT NULL,
  `OUTGOING_CALL_ID` bigint(20) DEFAULT NULL,
  `CALL_MONITOR_ID` bigint(20) DEFAULT NULL,
  `CALL_MONITORING_TEMPLATE_ID` bigint(20) DEFAULT NULL,
  `SERVICE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CALL_MONITORING_LOG_FK_4` (`OUTGOING_CALL_ID`),
  KEY `CALL_MONITORING_LOG_FK_5` (`CALL_MONITOR_ID`),
  KEY `CALL_MONITORING_LOG_FK_6` (`CALL_MONITORING_TEMPLATE_ID`),
  KEY `CALL_MONITORING_LOG_FK` (`SERVICE_ID`),
  CONSTRAINT `CALL_MONITORING_LOG_FK` FOREIGN KEY (`SERVICE_ID`) REFERENCES `SERVICE` (`ID`),
  CONSTRAINT `CALL_MONITORING_LOG_FK_4` FOREIGN KEY (`OUTGOING_CALL_ID`) REFERENCES `OUTGOING_CALL` (`ID`),
  CONSTRAINT `CALL_MONITORING_LOG_FK_5` FOREIGN KEY (`CALL_MONITOR_ID`) REFERENCES `CALL_MONITOR` (`ID`),
  CONSTRAINT `CALL_MONITORING_LOG_FK_6` FOREIGN KEY (`CALL_MONITORING_TEMPLATE_ID`) REFERENCES `CALL_MONITORING_TEMPLATE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CALL_MONITORING_LOG`
--

LOCK TABLES `CALL_MONITORING_LOG` WRITE;
/*!40000 ALTER TABLE `CALL_MONITORING_LOG` DISABLE KEYS */;
/*!40000 ALTER TABLE `CALL_MONITORING_LOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CALL_MONITORING_TEMPLATE`
--

DROP TABLE IF EXISTS `CALL_MONITORING_TEMPLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CALL_MONITORING_TEMPLATE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `ACTIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CALL_MONITORING_TEMPLATE`
--

LOCK TABLES `CALL_MONITORING_TEMPLATE` WRITE;
/*!40000 ALTER TABLE `CALL_MONITORING_TEMPLATE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CALL_MONITORING_TEMPLATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OPERATOR`
--

DROP TABLE IF EXISTS `OPERATOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OPERATOR` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(120) DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`USERNAME`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`EMAIL`),
  UNIQUE KEY `UKde1gelldri5lld7b9egq31c0g` (`USERNAME`),
  UNIQUE KEY `UKg9wt1yp20wo32vpf20w8gefhj` (`EMAIL`),
  UNIQUE KEY `UK4e1x94ls2qe75uw1hwg7mvopr` (`USERNAME`),
  UNIQUE KEY `UKd3k7nroaly3sxyyxujl67i16f` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OPERATOR`
--

LOCK TABLES `OPERATOR` WRITE;
/*!40000 ALTER TABLE `OPERATOR` DISABLE KEYS */;
INSERT INTO `OPERATOR` VALUES (1,'rajkerpn@yahoo.com','$2a$10$QmnBgEtRP3EXDlp86xKQB.ABLV.WtB6n2cxu01Jezi3tWZRPMrwh2','rayker'),(2,'emina@gmail.com','$2a$10$Z25ATsRDltFb4RO/aLPgZufxFyf61FTJBnM/FcEmeSsxXSWrfGN2S','emina'),(4,'srecko@gmail.com','$2a$10$YY.H/XwSXQYH.aVAFtKUae7i0kcIKfvXvAZ6MFcFMSZrohaS2S4si','srecko'),(5,'bojan@gmail.com','$2a$10$wQoe.EALQgE2nwEcq8fMPOxmL4qjvutMyjmw5GcpeYNq9huIGnoJK','bojan'),(6,'user@gmail.com','$2a$10$uMXOFTDhdDfNrsngm0osp./Il2oKD1r0IYu0Ty2xovd0rtGYcizfG','korisnik1');
/*!40000 ALTER TABLE `OPERATOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OPERATOR_ROLES`
--

DROP TABLE IF EXISTS `OPERATOR_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OPERATOR_ROLES` (
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FKddm4od95y3x290w87mc83mp58` (`ROLE_ID`),
  CONSTRAINT `FKbk2uqeopdkyn85o61jgixjk6o` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`),
  CONSTRAINT `FKddm4od95y3x290w87mc83mp58` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`),
  CONSTRAINT `FKfi3234k5ov2m05afk7imsweon` FOREIGN KEY (`USER_ID`) REFERENCES `OPERATOR` (`ID`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`USER_ID`) REFERENCES `OPERATOR` (`ID`),
  CONSTRAINT `FKl8cmiy930iygxvu1uhlgih0ql` FOREIGN KEY (`USER_ID`) REFERENCES `OPERATOR` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OPERATOR_ROLES`
--

LOCK TABLES `OPERATOR_ROLES` WRITE;
/*!40000 ALTER TABLE `OPERATOR_ROLES` DISABLE KEYS */;
INSERT INTO `OPERATOR_ROLES` VALUES (1,1),(2,1),(4,3),(5,1),(6,1);
/*!40000 ALTER TABLE `OPERATOR_ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OUTGOING_CALL`
--

DROP TABLE IF EXISTS `OUTGOING_CALL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OUTGOING_CALL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTACT_NAME` varchar(100) DEFAULT NULL,
  `CONTACT_PHONE` varchar(100) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `CREATION_DATE` date DEFAULT NULL,
  `OUTGOING_CALL_TEMPLATE_ID` bigint(20) DEFAULT NULL,
  `NOTE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK79tlpxjtlsnmn4meknjqmbh6f` (`OUTGOING_CALL_TEMPLATE_ID`),
  CONSTRAINT `FK79tlpxjtlsnmn4meknjqmbh6f` FOREIGN KEY (`OUTGOING_CALL_TEMPLATE_ID`) REFERENCES `OUTGOING_CALL_TEMPLATE` (`ID`),
  CONSTRAINT `OUTGOING_CALL_FK` FOREIGN KEY (`OUTGOING_CALL_TEMPLATE_ID`) REFERENCES `OUTGOING_CALL_TEMPLATE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OUTGOING_CALL`
--

LOCK TABLES `OUTGOING_CALL` WRITE;
/*!40000 ALTER TABLE `OUTGOING_CALL` DISABLE KEYS */;
INSERT INTO `OUTGOING_CALL` VALUES (12,'mihajlo','0607666010','Lista 1','2021-05-22',2,'Napomena za listu 1'),(13,'aleksa','0614522010','Lista 1','2021-05-22',2,'Napomena za listu 1'),(18,'natalija','0607666010','Neplatise do 1.6','2021-05-22',3,'Neplatise do 1.6'),(19,'borko','0614522010','Neplatise do 1.6','2021-05-22',3,'Neplatise do 1.6'),(20,'jovan','0607666010','Ponuda za Wifi','2021-05-22',2,'Ponuda za Wifi'),(21,'marko','0614522010','Ponuda za Wifi','2021-05-22',2,'Ponuda za Wifi'),(26,'nenad','0607666010','Neplatise do 1.6','2021-05-25',3,'Dopuna neplatisa do 10.6.'),(27,'emina','0614522010','Neplatise do 1.6','2021-05-25',3,'Dopuna neplatisa do 10.6.'),(28,'nenad','0607666010','Ponuda optika od 1000/100.','2021-05-25',3,'Ponuda optika od 1000/100.'),(29,'emina','0614522010','Ponuda optika od 1000/100.','2021-05-25',3,'Ponuda optika od 1000/100.');
/*!40000 ALTER TABLE `OUTGOING_CALL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OUTGOING_CALL_TEMPLATE`
--

DROP TABLE IF EXISTS `OUTGOING_CALL_TEMPLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OUTGOING_CALL_TEMPLATE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `PREDEFINED_RESULTS` varchar(300) DEFAULT NULL,
  `ACTIVE` int(11) DEFAULT 1,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OUTGOING_CALL_TEMPLATE`
--

LOCK TABLES `OUTGOING_CALL_TEMPLATE` WRITE;
/*!40000 ALTER TABLE `OUTGOING_CALL_TEMPLATE` DISABLE KEYS */;
INSERT INTO `OUTGOING_CALL_TEMPLATE` VALUES (2,'drugi templejt','#drugi odgovor#treci odgovor#',1),(3,'treci templejt','#prvi odgovor#drugi odgovor#treci#',1),(4,'cetvrti templejt','#Kuca#Posao#Reka#Beograd#Zvezda#Sesti#',1),(56,'najnoviji templejt','#prvi#drugi#treci#cetvrti#',1),(57,'Templejt broj 57','#Prvi#Drugi#Treci#Cetvrti#Peti#Sesti#',0),(66,'sablon 31.5.2021','#prvi#drugi#treci#cetvrti#',0),(74,'novi templejt','#drugi#treci#cetvrti#',0),(79,'test','#first#second#',0),(80,'123','#123#123#',0);
/*!40000 ALTER TABLE `OUTGOING_CALL_TEMPLATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLES`
--

LOCK TABLES `ROLES` WRITE;
/*!40000 ALTER TABLE `ROLES` DISABLE KEYS */;
INSERT INTO `ROLES` VALUES (1,'ROLE_USER'),(2,'ROLE_MODERATOR'),(3,'ROLE_ADMIN'),(4,'ROLE_AGENT');
/*!40000 ALTER TABLE `ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICE`
--

DROP TABLE IF EXISTS `SERVICE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SERVICE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICE`
--

LOCK TABLES `SERVICE` WRITE;
/*!40000 ALTER TABLE `SERVICE` DISABLE KEYS */;
/*!40000 ALTER TABLE `SERVICE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'asterisk'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-25 13:41:51
