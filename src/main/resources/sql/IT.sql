CREATE DATABASE  IF NOT EXISTS `interviewtracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `interviewtracker`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: interviewtracker
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `applicant_details`
--

DROP TABLE IF EXISTS `applicant_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `applicant_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `DOB` varchar(45) DEFAULT NULL,
  `EMAIL_ID` varchar(45) DEFAULT NULL,
  `PHONE_NO` varchar(15) DEFAULT NULL,
  `SKILLS` varchar(500) DEFAULT NULL,
  `JOB_DETAIL_ID` int(11) DEFAULT NULL,
  `SPONSORSHIP_REQ` tinyint(4) DEFAULT NULL,
  `ACTIVE_FLG` tinyint(4) DEFAULT NULL,
  `IS_SELECTED` tinyint(4) DEFAULT NULL,
  `OVERALL_STATUS` varchar(105) DEFAULT NULL,
  `RESUME` blob,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `JOB_DTL_ID_idx` (`JOB_DETAIL_ID`),
  CONSTRAINT `JOB_DTL_ID` FOREIGN KEY (`JOB_DETAIL_ID`) REFERENCES `job_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `career_level`
--

DROP TABLE IF EXISTS `career_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `career_level` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(45) DEFAULT NULL,
  `GRADE` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `career_level`
--

LOCK TABLES `career_level` WRITE;
/*!40000 ALTER TABLE `career_level` DISABLE KEYS */;
INSERT INTO `career_level` VALUES (1,'CONSULTANT','C1'),(2,'CONSULTANT','C2'),(3,'CONSULTANT','C3'),(4,'ASSOCIATE CONSULTANT','AC1'),(5,'ASSOCIATE CONSULTANT','AC2'),(6,'ASSOCIATE CONSULTANT','AC3');
/*!40000 ALTER TABLE `career_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `int_type`
--

DROP TABLE IF EXISTS `int_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `int_type` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `int_type`
--

LOCK TABLES `int_type` WRITE;
/*!40000 ALTER TABLE `int_type` DISABLE KEYS */;
INSERT INTO `int_type` VALUES (1,'L1'),(2,'L2'),(3,'CLIENT'),(4,'HR');
/*!40000 ALTER TABLE `int_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview_details`
--

DROP TABLE IF EXISTS `interview_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interview_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_ID` int(11) DEFAULT NULL,
  `APPLICANT_ID` int(11) DEFAULT NULL,
  `INT_TYPE_ID` int(11) DEFAULT NULL,
  `INT_RESULT_ID` int(11) DEFAULT NULL,
  `INT_DATETIME` datetime DEFAULT NULL,
  `TIMEZONE` varchar(5) DEFAULT NULL,
  `EVALUATOR_NAME` varchar(65) DEFAULT NULL,
  `EVALUATOR_COMMENTS` varchar(500) DEFAULT NULL,
  `CREATED_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `JOB_ID_FK_idx` (`JOB_ID`),
  KEY `APPLICANT_ID_FK_idx` (`APPLICANT_ID`),
  KEY `INT_TYPE_ID_FK_idx` (`INT_TYPE_ID`),
  KEY `INT_RSLT_ID_idx` (`INT_RESULT_ID`),
  CONSTRAINT `APPLICANT_ID_FK` FOREIGN KEY (`APPLICANT_ID`) REFERENCES `applicant_details` (`id`),
  CONSTRAINT `INT_RSLT_ID` FOREIGN KEY (`INT_RESULT_ID`) REFERENCES `interview_rslt` (`id`),
  CONSTRAINT `INT_TYPE_ID_FK` FOREIGN KEY (`INT_TYPE_ID`) REFERENCES `int_type` (`id`),
  CONSTRAINT `JOB_ID_FK` FOREIGN KEY (`JOB_ID`) REFERENCES `job_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview_details`
--

LOCK TABLES `interview_details` WRITE;
/*!40000 ALTER TABLE `interview_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview_rslt`
--

DROP TABLE IF EXISTS `interview_rslt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interview_rslt` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `INT_RSLT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview_rslt`
--

LOCK TABLES `interview_rslt` WRITE;
/*!40000 ALTER TABLE `interview_rslt` DISABLE KEYS */;
INSERT INTO `interview_rslt` VALUES (1,'PASSED'),(2,'FAILED'),(3,'CANDIDATE NOT AVAILABLE'),(4,'RESCHEDULED'),(5,'SCHEDULED');
/*!40000 ALTER TABLE `interview_rslt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_details`
--

DROP TABLE IF EXISTS `job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `job_details` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_TYPE` varchar(100) DEFAULT NULL,
  `CAREER_LEVEL` int(11) DEFAULT NULL,
  `BEGIN_DATE` date DEFAULT NULL,
  `ACCOUNT_NAME` varchar(50) DEFAULT NULL,
  `LOCATION` varchar(50) DEFAULT NULL,
  `HIRING_MANAGER` varchar(50) DEFAULT NULL,
  `ACTIVE_FLG` varchar(10) DEFAULT NULL,
  `STATUS` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CAREER_LEVEL_FK_idx` (`CAREER_LEVEL`),
  CONSTRAINT `CAREER_LEVEL_FK` FOREIGN KEY (`CAREER_LEVEL`) REFERENCES `career_level` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_details`
--

LOCK TABLES `job_details` WRITE;
/*!40000 ALTER TABLE `job_details` DISABLE KEYS */;
INSERT INTO `job_details` VALUES (1,'Full Stack Developer',1,'2018-11-10','Homedepot','Marietta','Anoop John','1',NULL),(2,'UI Developer',2,'2018-11-07','Homedepot','Marietta','Anoop John','1',NULL),(3,'JAVA Developer',3,'2018-10-03','Fedex','Atlanta','Krish Sharma','1',NULL),(4,'Selenium Tester',1,'2018-01-01','Humana','Atlanta','Aakash','1',NULL);
/*!40000 ALTER TABLE `job_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-30 20:10:59
