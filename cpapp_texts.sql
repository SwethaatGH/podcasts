-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: cpapp
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `texts`
--

DROP TABLE IF EXISTS `texts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `texts` (
  `dept` varchar(20) NOT NULL,
  `d1` varchar(45) DEFAULT NULL,
  `d2` varchar(100) DEFAULT NULL,
  `d3` varchar(100) DEFAULT NULL,
  `topic` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `texts`
--

LOCK TABLES `texts` WRITE;
/*!40000 ALTER TABLE `texts` DISABLE KEYS */;
INSERT INTO `texts` VALUES ('cse','CSEA Guest Lectures','Uploaded by: CSEA',NULL,'playlist'),('ece','ECEA Guest Lectures','Uploaded by: ECEA',NULL,'playlist'),('it','ITA Guest Lectures','Uploaded by: ITA',NULL,'playlist'),('cse','Technical Talks','Technical Talks from Guests, 2021','Guests deliver technical talks to students of prefinal year.','tech'),('cse','Alumni Guest Lectures','Alumni Guest Lectures from CSEA 2022','6 day series - Alumni of CSE deliver alumni talks.','alum'),('cse','Orientation Talks','Juniors Orientation 2023 talks','Dr.Sudha Sadasivam delivers a welcome message to all the freshers.','hod'),('ece','Technical Talks','Technical Talks from Guests, 2021','Guests deliver technical talks to students of prefinal year.','tech'),('ece','Alumni Guest Lectures','Alumni Guest Lectures from ECEA 2022','6 day series - Alumni of ECE deliver alumni talks.','alum'),('ece','Orientation talks','Juniors Orientation 2023 talks','HOD delivers a welcome message to all the freshers.','hod'),('it','Technical Talks','Technical Talks from Guests, 2021','Guests deliver technical talks to students of prefinal year.','tech'),('it','Alumni Guest Lectures','Alumni Guest Lectures from ITAA 2022','6 day series - Alumni of IT deliver alumni talks.','alum'),('it','Orientation Talks','Juniors Orientation 2023 talks','HOD delivers a welcome message to all the freshers.','hod'),('cse','Microarchitecture Awareness','Technical Talks from Mr.Soundar, 2023','Mr.Soundar gives awareness about Microarchitecture','epi'),('ece','Practices to Lead','Technical Talks from Mrs.Prema, 202','Mrs.Prema gives tips to a healthy life','epi'),('it','Object Computing','Technical Talks from Dr.Nadarajan, 2023','Dr.Nadarajan gives awareness about Object Computing','epi');
/*!40000 ALTER TABLE `texts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 20:50:51
