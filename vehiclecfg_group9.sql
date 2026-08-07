-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: vehiclecfg_group9
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alternate_component_master`
--

DROP TABLE IF EXISTS `alternate_component_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alternate_component_master` (
  `alt_id` int NOT NULL AUTO_INCREMENT,
  `delta_price` double DEFAULT NULL,
  `alt_comp_id` int DEFAULT NULL,
  `comp_id` int NOT NULL,
  `model_id` int NOT NULL,
  PRIMARY KEY (`alt_id`),
  KEY `FKnnmfalcksg51qu0o4quupn69h` (`alt_comp_id`),
  KEY `FKpgv8oj5ulg440a3vrcefmyp24` (`comp_id`),
  KEY `FKqcb29n3rowc4mio33w5t3770b` (`model_id`),
  CONSTRAINT `FKnnmfalcksg51qu0o4quupn69h` FOREIGN KEY (`alt_comp_id`) REFERENCES `component_master` (`comp_id`),
  CONSTRAINT `FKpgv8oj5ulg440a3vrcefmyp24` FOREIGN KEY (`comp_id`) REFERENCES `component_master` (`comp_id`),
  CONSTRAINT `FKqcb29n3rowc4mio33w5t3770b` FOREIGN KEY (`model_id`) REFERENCES `model_master` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=613 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternate_component_master`
--

LOCK TABLES `alternate_component_master` WRITE;
/*!40000 ALTER TABLE `alternate_component_master` DISABLE KEYS */;
INSERT INTO `alternate_component_master` VALUES (1,0,1,1,1),(2,380000,3,2,1),(3,0,19,19,1),(4,0,28,28,1),(5,0,30,30,1),(6,0,31,31,1),(7,0,32,32,1),(8,0,33,33,1),(9,0,34,34,1),(10,0,37,37,1),(11,0,44,44,1),(12,0,47,47,1),(13,0,48,48,1),(14,0,50,50,1),(15,0,51,51,1),(16,0,53,53,1),(17,0,55,55,1),(18,0,58,58,1),(19,0,62,62,1),(20,0,63,63,1),(21,0,64,64,1),(22,-8000,67,65,1),(23,5000,68,65,1),(24,13950,66,65,1),(25,27599,71,70,1),(26,39999,81,79,1),(27,22949,77,79,1),(28,47000,86,85,1),(29,0,87,87,1),(30,44225,98,97,1),(31,24999,101,104,1),(32,24999,102,104,1),(33,24999,105,104,1),(34,0,109,104,1),(35,-150000,13,11,2),(36,148000,23,22,2),(37,0,29,29,2),(38,0,35,35,2),(39,0,38,38,2),(40,0,46,46,2),(41,0,47,47,2),(42,0,48,48,2),(43,0,53,53,2),(44,0,54,54,2),(45,0,55,55,2),(46,0,58,58,2),(47,0,62,62,2),(48,-8000,67,65,2),(49,5500,68,65,2),(50,32099,72,70,2),(51,-6000,77,79,2),(52,18625,80,79,2),(53,98999,84,85,2),(54,0,87,87,2),(55,42225,98,97,2),(56,22000,102,104,2),(57,25000,108,104,2),(58,0,109,104,2),(59,-95000,11,13,3),(60,120000,22,23,3),(61,0,27,27,3),(62,0,28,28,3),(63,0,24,34,3),(64,0,27,37,3),(65,0,44,44,3),(66,0,47,47,3),(67,0,48,48,3),(68,0,50,50,3),(69,0,51,51,3),(70,0,53,53,3),(71,0,54,54,3),(72,0,55,55,3),(73,0,59,59,3),(74,0,62,62,3),(75,0,63,63,3),(76,0,64,64,3),(77,32000,66,65,3),(78,17500,68,65,3),(79,0,73,73,3),(80,15000,80,79,3),(81,25000,81,79,3),(82,8000,77,79,3),(83,0,83,83,3),(84,75000,86,85,3),(85,0,87,87,3),(86,41175,96,95,3),(87,23000,102,104,3),(88,23000,103,104,3),(89,0,106,104,3),(90,0,109,104,3),(91,130000,6,4,4),(92,0,20,20,4),(93,0,27,27,4),(94,0,34,34,4),(95,0,39,39,4),(96,0,44,44,4),(97,0,47,47,4),(98,0,50,50,4),(99,0,49,49,4),(100,0,53,53,4),(101,0,54,54,4),(102,0,58,58,4),(103,0,62,62,4),(104,24799,68,67,4),(105,0,73,73,4),(106,-22350,77,81,4),(107,9000,78,81,4),(108,0,83,83,4),(109,0,87,87,4),(110,39899,94,93,4),(111,19999,102,103,4),(112,19999,105,103,4),(113,0,109,103,4),(114,0,8,8,5),(115,0,20,20,5),(116,0,27,27,5),(117,0,34,34,5),(118,0,39,39,5),(119,0,44,44,5),(120,0,47,47,5),(121,0,50,50,5),(122,0,49,49,5),(123,0,53,53,5),(124,0,54,54,5),(125,0,55,55,5),(126,45000,57,56,5),(127,52000,58,56,5),(128,0,62,62,5),(129,22525,68,67,5),(130,50499,69,67,5),(131,0,71,71,5),(132,-11000,77,81,5),(133,-8799,78,81,5),(134,0,83,83,5),(135,0,87,87,5),(136,42450,91,90,5),(137,38299,92,90,5),(138,21700,102,103,5),(139,21700,105,103,5),(140,0,109,103,5),(141,112000,8,4,6),(142,0,20,20,6),(143,0,27,27,6),(144,0,34,34,6),(145,0,39,39,6),(146,0,44,44,6),(147,0,47,47,6),(148,0,50,50,6),(149,41999,51,49,6),(150,0,53,53,6),(151,0,54,54,6),(152,0,55,55,6),(153,0,58,58,6),(154,0,62,62,6),(155,0,63,63,6),(156,18000,68,65,6),(157,42500,69,65,6),(158,35999,73,71,6),(159,21250,81,78,6),(160,12448,79,78,6),(161,0,83,83,6),(162,0,84,84,6),(163,0,87,87,6),(164,-36550,93,94,6),(165,25699,102,103,6),(166,25699,105,103,6),(167,0,106,103,6),(168,0,109,103,6),(169,0,6,6,7),(170,0,22,22,7),(171,0,27,27,7),(172,0,34,34,7),(173,0,39,39,7),(174,0,45,45,7),(175,0,47,47,7),(176,0,50,50,7),(177,0,51,51,7),(178,0,53,53,7),(179,0,54,54,7),(180,0,55,55,7),(181,0,58,58,7),(182,0,62,62,7),(183,0,63,63,7),(184,0,64,64,7),(185,15730,68,65,7),(186,36480,69,65,7),(187,49845,74,73,7),(188,25770,80,77,7),(189,28310,81,77,7),(190,20585,78,77,7),(191,0,83,83,7),(192,65000,86,84,7),(193,0,87,87,7),(194,37439,93,94,7),(195,25699,102,103,7),(196,25699,105,103,7),(197,0,106,103,7),(198,0,109,103,7),(199,0,14,14,8),(200,137500,23,22,8),(201,0,27,27,8),(202,0,34,34,8),(203,0,39,39,8),(204,0,46,46,8),(205,0,47,47,8),(206,0,50,50,8),(207,0,51,51,8),(208,0,53,53,8),(209,0,54,54,8),(210,0,55,55,8),(211,0,59,59,8),(212,0,62,62,8),(213,0,63,63,8),(214,16400,65,67,8),(215,20700,68,67,8),(216,58399,75,73,8),(217,-12560,79,77,8),(218,22845,80,77,8),(219,-8050,78,77,8),(220,0,83,83,8),(221,48750,86,85,8),(222,0,87,87,8),(223,41280,98,96,8),(224,29800,107,102,8),(225,29800,108,102,8),(226,0,109,102,8),(227,0,5,5,9),(228,0,21,21,9),(229,0,27,27,9),(230,0,34,34,9),(231,0,40,40,9),(232,0,43,43,9),(233,0,47,47,9),(234,0,50,50,9),(235,39799,51,49,9),(236,0,53,53,9),(237,0,54,54,9),(238,0,55,55,9),(239,0,58,58,9),(240,0,62,62,9),(241,25000,69,67,9),(242,19999,68,67,9),(243,27850,72,70,9),(244,-12400,77,78,9),(245,24600,79,78,9),(246,42300,91,90,9),(247,23000,103,104,9),(248,23000,105,104,9),(249,0,109,104,9),(250,0,7,7,10),(251,0,23,23,10),(252,0,27,27,10),(253,0,34,34,10),(254,0,40,40,10),(255,0,45,45,10),(256,0,47,47,10),(257,0,50,50,10),(258,0,49,49,10),(259,0,54,54,10),(260,0,55,55,10),(261,47500,58,57,10),(262,82000,59,57,10),(263,0,62,62,10),(264,28000,65,67,10),(265,38500,66,67,10),(266,13000,68,67,10),(267,0,71,71,10),(268,-16400,77,78,10),(269,19300,79,78,10),(270,26000,81,78,10),(271,0,83,83,10),(272,-42100,90,91,10),(273,25000,105,104,10),(274,25000,105,109,10),(275,0,5,5,11),(276,0,20,20,11),(277,0,27,27,11),(278,0,34,34,11),(279,0,40,40,11),(280,0,45,45,11),(281,0,47,47,11),(282,0,50,50,11),(283,0,51,51,11),(284,0,54,54,11),(285,0,55,55,11),(286,0,58,58,11),(287,0,67,67,11),(288,26225,72,70,11),(289,0,78,78,11),(290,0,87,87,11),(291,36999,91,90,11),(292,22000,103,109,11),(293,22000,105,109,11),(294,0,5,5,12),(295,0,20,20,12),(296,0,27,27,12),(297,0,34,34,12),(298,0,40,40,12),(299,0,45,45,12),(300,0,47,47,12),(301,0,50,50,12),(302,0,49,49,12),(303,0,54,54,12),(304,0,55,55,12),(305,0,57,57,12),(306,0,62,62,12),(307,24800,65,67,12),(308,0,78,78,12),(309,0,83,83,12),(310,0,85,85,12),(311,37380,89,88,12),(312,27000,105,109,12),(313,23000,103,109,12),(314,23000,104,109,12),(315,0,10,10,13),(316,0,23,23,13),(317,0,27,27,13),(318,0,34,34,13),(319,0,41,41,13),(320,0,46,46,13),(321,0,47,47,13),(322,0,52,52,13),(323,0,53,53,13),(324,0,54,54,13),(325,0,55,55,13),(326,0,58,58,13),(327,0,62,62,13),(328,23950,66,65,13),(329,17320,68,65,13),(330,31590,73,72,13),(331,-12700,79,80,13),(332,27800,81,80,13),(333,21300,78,80,13),(334,0,85,85,13),(335,0,87,87,13),(336,36610,95,94,13),(337,15000,105,109,13),(338,0,104,109,13),(339,0,5,5,14),(340,0,23,23,14),(341,0,27,27,14),(342,0,34,34,14),(343,0,41,41,14),(344,0,43,43,14),(345,0,47,47,14),(346,0,52,52,14),(347,0,53,53,14),(348,0,54,54,14),(349,0,55,55,14),(350,0,58,58,14),(351,0,62,62,14),(352,23500,65,67,14),(353,27500,68,67,14),(354,32800,66,67,14),(355,30000,73,72,14),(356,-12400,77,80,14),(357,-10900,78,80,14),(358,10230,79,80,14),(359,0,83,83,14),(360,0,85,85,14),(361,0,87,87,14),(362,46985,91,90,14),(363,50700,94,90,14),(364,27000,102,109,14),(365,27000,103,109,14),(366,0,106,109,14),(367,225000,16,15,15),(368,60000,23,22,15),(369,0,29,29,15),(370,0,35,35,15),(371,0,42,42,15),(372,0,44,44,15),(373,0,47,47,15),(374,0,48,48,15),(375,0,50,50,15),(376,0,51,51,15),(377,0,53,53,15),(378,0,54,54,15),(379,0,55,55,15),(380,180000,60,59,15),(381,0,62,62,15),(382,0,63,63,15),(383,0,64,64,15),(384,42600,65,67,15),(385,48999,66,67,15),(386,52555,69,67,15),(387,0,73,73,15),(388,26590,79,77,15),(389,27900,80,77,15),(390,29200,81,77,15),(391,0,83,83,15),(392,0,84,84,15),(393,0,87,87,15),(394,47999,97,95,15),(395,37799,102,104,15),(396,0,109,104,15),(397,0,9,9,16),(398,0,24,24,16),(399,0,27,27,16),(400,0,34,34,16),(401,0,37,37,16),(402,0,44,44,16),(403,0,47,47,16),(404,0,48,48,16),(405,0,52,52,16),(406,0,53,53,16),(407,0,54,54,16),(408,0,55,55,16),(409,0,59,59,16),(410,0,62,62,16),(411,0,63,63,16),(412,0,64,64,16),(413,52500,66,65,16),(414,31999,73,72,16),(415,38000,74,72,16),(416,0,82,82,16),(417,0,83,83,16),(418,0,85,85,16),(419,0,87,87,16),(420,63200,97,95,16),(421,45000,102,104,16),(422,0,106,104,16),(423,0,109,104,16),(424,0,13,13,17),(425,0,26,26,17),(426,0,28,28,17),(427,0,37,37,17),(428,0,44,44,17),(429,0,47,47,17),(430,0,48,48,17),(431,0,52,52,17),(432,0,53,53,17),(433,0,54,54,17),(434,0,55,55,17),(435,0,59,59,17),(436,0,62,62,17),(437,0,63,63,17),(438,0,64,64,17),(439,45800,66,65,17),(440,55800,68,65,17),(441,50200,75,74,17),(442,0,82,82,17),(443,0,83,83,17),(444,0,85,85,17),(445,0,87,87,17),(446,0,86,86,17),(447,45000,102,104,17),(448,0,106,104,17),(449,0,109,104,17),(450,0,17,17,18),(451,0,26,26,18),(452,0,28,28,18),(453,0,36,36,18),(454,0,37,37,18),(455,0,44,44,18),(456,0,47,47,18),(457,0,48,48,18),(458,0,52,52,18),(459,0,53,53,18),(460,0,54,54,18),(461,0,55,55,18),(462,0,61,61,18),(463,0,62,62,18),(464,0,63,63,18),(465,0,64,64,18),(466,65000,69,68,18),(467,52500,75,74,18),(468,0,82,82,18),(469,0,83,83,18),(470,0,85,85,18),(471,0,87,87,18),(472,69000,99,98,18),(473,55000,102,106,18),(474,0,109,106,18),(475,0,18,18,19),(476,0,26,26,19),(477,0,29,29,19),(478,0,36,36,19),(479,0,37,37,19),(480,0,44,44,19),(481,0,47,47,19),(482,0,48,48,19),(483,0,52,52,19),(484,0,53,53,19),(485,0,54,54,19),(486,0,55,55,19),(487,0,61,61,19),(488,0,62,62,19),(489,0,63,63,19),(490,0,64,64,19),(491,52500,68,66,19),(492,69999,69,66,19),(493,0,74,74,19),(494,0,82,82,19),(495,0,83,83,19),(496,0,87,87,19),(497,0,98,98,19),(498,0,99,99,19),(499,60000,102,104,19),(500,60000,108,104,19),(501,0,106,104,19),(502,0,109,104,19),(503,0,17,17,20),(504,0,26,26,20),(505,0,29,29,20),(506,0,36,36,20),(507,0,35,35,20),(508,0,37,37,20),(509,0,44,44,20),(510,0,47,47,20),(511,0,48,48,20),(512,0,52,52,20),(513,0,53,53,20),(514,0,54,54,20),(515,0,55,55,20),(516,0,60,60,20),(517,0,62,62,20),(518,0,63,63,20),(519,0,64,64,20),(520,48000,66,68,20),(521,55000,69,68,20),(522,40000,75,74,20),(523,0,82,82,20),(524,0,83,83,20),(525,0,85,85,20),(526,0,87,87,20),(527,0,100,100,20),(528,51000,103,109,20),(529,0,104,109,20),(530,51000,106,109,20),(531,0,102,109,20),(532,0,18,18,21),(533,0,25,25,21),(534,0,28,28,21),(535,0,35,35,21),(536,0,38,38,21),(537,0,44,44,21),(538,0,47,47,21),(539,0,48,48,21),(540,0,52,52,21),(541,0,53,53,21),(542,0,54,54,21),(543,0,55,55,21),(544,0,58,58,21),(545,0,62,62,21),(546,0,63,63,21),(547,0,64,64,21),(548,38000,69,65,21),(549,0,76,76,21),(550,0,81,81,21),(551,0,83,83,21),(552,0,87,87,21),(553,49000,96,95,21),(554,32999,103,102,21),(555,0,104,102,21),(556,0,106,102,21),(557,0,109,102,21),(558,0,14,14,22),(559,0,24,24,22),(560,0,27,27,22),(561,0,34,34,22),(562,0,37,37,22),(563,0,44,44,22),(564,0,47,47,22),(565,0,48,48,22),(566,0,52,52,22),(567,0,53,53,22),(568,0,54,54,22),(569,0,55,55,22),(570,0,58,58,22),(571,0,62,62,22),(572,0,63,63,22),(573,0,64,64,22),(574,39999,66,68,22),(575,49999,69,68,22),(576,0,70,70,22),(577,0,81,81,22),(578,0,83,83,22),(579,0,87,87,22),(580,44100,98,96,22),(581,35999,103,102,22),(582,0,104,102,22),(583,0,106,102,22),(584,0,109,102,22),(585,0,17,17,23),(586,0,25,25,23),(587,0,29,29,23),(588,0,35,35,23),(589,0,38,38,23),(590,0,44,44,23),(591,0,47,47,23),(592,0,48,48,23),(593,0,52,52,23),(594,0,53,53,23),(595,0,54,54,23),(596,0,55,55,23),(597,55000,60,59,23),(598,0,62,62,23),(599,0,63,63,23),(600,0,64,64,23),(601,42000,66,68,23),(602,54000,69,68,23),(603,75000,76,75,23),(604,0,81,81,23),(605,0,83,83,23),(606,65750,86,85,23),(607,0,87,87,23),(608,0,100,100,23),(609,35000,103,102,23),(610,0,104,102,23),(611,0,106,102,23),(612,0,109,102,23);
/*!40000 ALTER TABLE `alternate_component_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `component_master`
--

DROP TABLE IF EXISTS `component_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `component_master` (
  `comp_id` int NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(255) NOT NULL,
  PRIMARY KEY (`comp_id`),
  UNIQUE KEY `UKeva2rs1loskklo40bsl29imme` (`comp_name`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `component_master`
--

LOCK TABLES `component_master` WRITE;
/*!40000 ALTER TABLE `component_master` DISABLE KEYS */;
INSERT INTO `component_master` VALUES (8,'1.2L iCNG Engine'),(4,'1.2L Revotron Petrol Engine'),(5,'1.2L Z-Series Petrol Engine'),(9,'1.3L Turbocharged Petrol Engine'),(7,'1.5L K15C Smart Hybrid Petrol Engine'),(6,'1.5L Revotorq Diesel Engine'),(10,'1.6L CRDi Diesel Engine'),(61,'10 Airbags'),(74,'10.25-inch MBUX Touchscreen Infotainment System'),(73,'10.25-inch Touchscreen Infotainment System'),(75,'12.3-inch Touchscreen Infotainment System'),(89,'14-inch Alloy Wheels'),(88,'14-inch Steel Wheels'),(76,'14.9-inch BMW Curved Touchscreen Display'),(92,'15-inch Dual-Tone Alloy Wheels'),(91,'15-inch Precision Cut Alloy Wheels'),(90,'15-inch Steel Wheels'),(94,'16-inch Alloy Wheels'),(93,'16-inch Steel Wheels'),(95,'17-inch Alloy Wheels'),(96,'18-inch Alloy Wheels'),(97,'18-inch Diamond Cut Alloy Wheels'),(98,'19-inch Alloy Wheels'),(14,'2.0L Kryotec Turbo Diesel Engine'),(12,'2.0L MPi Petrol Engine'),(13,'2.0L mStallion Turbo Petrol Engine'),(11,'2.2L mHawk Diesel Engine'),(15,'2.7L Dual VVT-i Petrol Engine'),(16,'2.8L GD Diesel Engine'),(99,'20-inch AMG Alloy Wheels'),(100,'21-inch Alloy Wheels'),(54,'3-Point Seat Belts at All Seating Positions'),(17,'3.0L Inline-6 Turbo Diesel Engine'),(63,'360  Surround View Camera'),(57,'4 Airbags'),(42,'4-Link Rear Suspension'),(18,'4.0L V8 Twin-Turbo Petrol Engine with Mild Hybrid'),(29,'4XPLOR Four-Wheel Drive System (4WD)'),(21,'5-Speed AMT Transmission'),(20,'5-Speed Manual Transmission'),(2,'59 kWh Lithium-ion Battery Pack'),(58,'6 Airbags (Driver, Passenger,  Side and Curtain)'),(23,'6-Speed Automatic Transmission'),(22,'6-Speed Manual Transmission'),(59,'7 Airbags'),(71,'7-inch Touchscreen Infotainment System'),(24,'7-Speed Dual-Clutch Automatic Transmission (7G-DCT)'),(3,'79 kWh Lithium-ion Battery Pack'),(72,'8-inch Touchscreen Infotainment System'),(25,'8-Speed Steptronic Sport Automatic Transmission'),(60,'9 Airbags'),(26,'9-Speed Automatic Transmission (9G-TRONIC)'),(33,'AC Charging Support'),(36,'AIRMATIC Air Suspension'),(83,'Ambient Interior Lighting'),(53,'Anti-lock Braking System (ABS)'),(78,'Arkamys Premium Audio System'),(66,'ARTICO Leather Upholstery'),(30,'Battery Management System (BMS)'),(102,'Black Body Color'),(103,'Blue Body Color'),(80,'Bose Premium Audio System'),(82,'Burmester Premium Surround Sound System'),(41,'Coupled Torsion Beam Axle Rear Suspension'),(32,'DC Fast Charging Support'),(35,'Double Wishbone Front Suspension'),(56,'Dual Front Airbags'),(44,'Electric Power Steering'),(84,'Electric Sunroof'),(67,'Fabric Seat Upholstery'),(52,'Four Wheels Disc Brakes'),(50,'Front Disc Brakes'),(55,'Front Seat Belts with Pretensioners and Load Limiters'),(47,'Front Stabilizer Bar'),(27,'Front-Wheel Drive (FWD)'),(108,'Green Body Color'),(106,'Grey Body Color'),(81,'Harman Kardon 16-Speaker Audio System'),(46,'Hydraulic Power Steering'),(77,'JBL Premium Audio System'),(69,'Leather Vernasca Upholstery'),(65,'Leatherette Seat Upholstery'),(87,'LED Daytime Running Lamps (DRLs)'),(34,'MacPherson Strut Front Suspension'),(37,'Multi-Link Rear Suspension'),(68,'NAPPA Leather Upholstery'),(85,'No Sunroof'),(101,'Orange Body Color'),(86,'Panoramic Glass Roof'),(38,'Penta-Link Rear Suspension with Watt\'s Linkage'),(1,'Permanent Magnet Synchronous Electric Motor'),(64,'Power Adjustable Driver Seat'),(51,'Rear Disc Brakes'),(49,'Rear Drum Brakes'),(48,'Rear Stabilizer Bar'),(28,'Rear-Wheel Drive'),(105,'Red Body Color'),(31,'Regenerative Braking System'),(104,'Silver Body Color'),(19,'Single-Speed Automatic Transmission'),(79,'Sony Premium Audio System'),(43,'Telescopic Steering Adjustment'),(45,'Tilt Steering Adjustment'),(40,'Torsion Beam Rear Suspension'),(70,'Touchscreen Infotainment System'),(39,'Twist Beam Rear Suspension'),(62,'Tyre Pressure Monitoring System (TPMS)'),(109,'white Body Color'),(107,'Yellow Body Color');
/*!40000 ALTER TABLE `component_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `inv_id` bigint NOT NULL AUTO_INCREMENT,
  `inv_date` datetime(6) DEFAULT NULL,
  `net_amt` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `total_amt` double DEFAULT NULL,
  `model_id` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`inv_id`),
  KEY `FKarg94e2qrxsjeet2tdq8h3nbb` (`model_id`),
  KEY `FK1wpyuwr7s4xc9wbjywkbril9c` (`id`),
  CONSTRAINT `FK1wpyuwr7s4xc9wbjywkbril9c` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKarg94e2qrxsjeet2tdq8h3nbb` FOREIGN KEY (`model_id`) REFERENCES `model_master` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'2026-08-02 18:06:41.457000',5566321.6,596391.6,4969930,6,1),(2,'2026-08-02 22:56:50.886000',70071560.16,7507667.16,62563893,16,1),(3,'2026-08-03 15:59:44.703000',114407996.64,12257999.639999999,102149997,19,1),(4,'2026-08-03 16:11:31.815000',8291713.92,888397.9199999999,7403316,1,3);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_detail`
--

DROP TABLE IF EXISTS `invoice_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_detail` (
  `invdtl_id` int NOT NULL AUTO_INCREMENT,
  `delta_price` double DEFAULT NULL,
  `alt_comp_id` int NOT NULL,
  `comp_id` int NOT NULL,
  `inv_id` bigint NOT NULL,
  `model_id` int NOT NULL,
  PRIMARY KEY (`invdtl_id`),
  KEY `FK5vlnmeqvs94aljq9o3yj8a8jo` (`alt_comp_id`),
  KEY `FK9yfk9n3n5le7e7nnq939ybv4r` (`comp_id`),
  KEY `FKckt5u57libgdv8ot4vq1o46sr` (`inv_id`),
  KEY `FK8hkdrod8r0uqyviryvlgslhb8` (`model_id`),
  CONSTRAINT `FK5vlnmeqvs94aljq9o3yj8a8jo` FOREIGN KEY (`alt_comp_id`) REFERENCES `component_master` (`comp_id`),
  CONSTRAINT `FK8hkdrod8r0uqyviryvlgslhb8` FOREIGN KEY (`model_id`) REFERENCES `model_master` (`model_id`),
  CONSTRAINT `FK9yfk9n3n5le7e7nnq939ybv4r` FOREIGN KEY (`comp_id`) REFERENCES `component_master` (`comp_id`),
  CONSTRAINT `FKckt5u57libgdv8ot4vq1o46sr` FOREIGN KEY (`inv_id`) REFERENCES `invoice` (`inv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_detail`
--

LOCK TABLES `invoice_detail` WRITE;
/*!40000 ALTER TABLE `invoice_detail` DISABLE KEYS */;
INSERT INTO `invoice_detail` VALUES (1,63200,97,95,2,16),(2,0,85,85,2,16),(3,52500,66,65,2,16),(4,0,87,87,2,16),(5,31999,73,72,2,16),(6,0,64,64,2,16),(7,0,82,82,2,16),(8,45000,102,109,2,16),(9,45000,102,104,2,16),(10,0,83,83,2,16);
/*!40000 ALTER TABLE `invoice_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mfg_master`
--

DROP TABLE IF EXISTS `mfg_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mfg_master` (
  `mfg_id` int NOT NULL AUTO_INCREMENT,
  `mfg_name` varchar(255) DEFAULT NULL,
  `seg_id` int DEFAULT NULL,
  PRIMARY KEY (`mfg_id`),
  KEY `FKok5qd64lq1asv75hpfgpwhdyq` (`seg_id`),
  CONSTRAINT `FKok5qd64lq1asv75hpfgpwhdyq` FOREIGN KEY (`seg_id`) REFERENCES `segment_master` (`seg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mfg_master`
--

LOCK TABLES `mfg_master` WRITE;
/*!40000 ALTER TABLE `mfg_master` DISABLE KEYS */;
INSERT INTO `mfg_master` VALUES (1,'Mahindra',4),(2,'TATA',1),(3,'TATA',2),(4,'TATA',4),(5,'Maruti Suzuki',1),(6,'Maruti Suzuki',3),(7,'Maruti Suzuki',4),(8,'Hyundai',1),(9,'Hyundai',3),(10,'Toyota',4),(11,'Mercedes-Benz',2),(12,'Mercedes-Benz',3),(13,'Mercedes-Benz',4),(14,'Mercedes-Benz',5),(15,'BMW',2),(16,'BMW',3),(17,'BMW',4);
/*!40000 ALTER TABLE `mfg_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model_master`
--

DROP TABLE IF EXISTS `model_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model_master` (
  `model_id` int NOT NULL AUTO_INCREMENT,
  `base_price` decimal(12,2) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `model_name` varchar(255) DEFAULT NULL,
  `mfg_id` int DEFAULT NULL,
  `seg_id` int DEFAULT NULL,
  PRIMARY KEY (`model_id`),
  KEY `FKacbx0rmpiqwgiisi06lsfcw6f` (`mfg_id`),
  KEY `FKtpmev85psi1n73w058nmykixb` (`seg_id`),
  CONSTRAINT `FKacbx0rmpiqwgiisi06lsfcw6f` FOREIGN KEY (`mfg_id`) REFERENCES `mfg_master` (`mfg_id`),
  CONSTRAINT `FKtpmev85psi1n73w058nmykixb` FOREIGN KEY (`seg_id`) REFERENCES `segment_master` (`seg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model_master`
--

LOCK TABLES `model_master` WRITE;
/*!40000 ALTER TABLE `model_master` DISABLE KEYS */;
INSERT INTO `model_master` VALUES (1,1890000.00,'images/BE6.png','BE 6',1,4),(2,2237500.00,'images/SCORPIO.png','Scorpio-N',1,4),(3,2492000.00,'images/XUV7XO.png','XUV7XO',1,4),(4,689000.00,'images/ALTROZ.png','Altroz',2,1),(5,560000.00,'images/TIAGO.png','Tiago',2,1),(6,709990.00,'images/PUNCH.png','Punch',3,2),(7,800000.00,'images/NEXON.png','Nexon',3,2),(8,1734990.00,'images/TATAH.png','Harrier',4,4),(9,684000.00,'images/DZIRE.png','Dzire',6,3),(10,1299100.00,'images/ERTIGA.png','Ertiga',7,4),(11,662900.00,'images/SWIFT.png','Swift',5,1),(12,640900.00,'images/WAGONR.png','WagonR',5,1),(13,1720000.00,'images/Elantra.png','Elantra',9,3),(14,735000.00,'images/I20.png','i20',8,1),(15,3955000.00,'images/FORTUNER.png','Fortuner',10,4),(16,8700000.00,'images/ACLASS.png','A-Class',11,2),(17,6120000.00,'images/CCLASS.png','C-Class',12,3),(18,22000000.00,'images/SCLASS.png','S-Class',14,5),(19,33800000.00,'images/MAYBACH.png','Maybach S-Class',14,5),(20,13750000.00,'images/GLS.png','GLS',13,4),(21,7710000.00,'images/3SERIES.png','3 Series',16,3),(22,5290000.00,'images/X1.png','BMW X1',15,2),(23,13070000.00,'images/X7.png','BMW X7',17,4);
/*!40000 ALTER TABLE `model_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segment_master`
--

DROP TABLE IF EXISTS `segment_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `segment_master` (
  `seg_id` int NOT NULL AUTO_INCREMENT,
  `min_qty` int DEFAULT NULL,
  `seg_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segment_master`
--

LOCK TABLES `segment_master` WRITE;
/*!40000 ALTER TABLE `segment_master` DISABLE KEYS */;
INSERT INTO `segment_master` VALUES (1,8,'Small Car'),(2,6,'Compact Car'),(3,5,'Sedan'),(4,3,'SUVs'),(5,2,'Luxury Car');
/*!40000 ALTER TABLE `segment_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `add1` varchar(255) DEFAULT NULL,
  `add2` varchar(255) DEFAULT NULL,
  `auth_tel` varchar(255) DEFAULT NULL,
  `auth_name` varchar(255) DEFAULT NULL,
  `cell` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_email` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `company_st_no` varchar(255) DEFAULT NULL,
  `company_vat_no` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `holding_type` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pin` varchar(255) DEFAULT NULL,
  `registration_no` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `tax_pan` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Plot No. 25, Hinjewadi Phase 1','Near Rajiv Gandhi Infotech Park','020-45678901','Deepak Patil','9876543210','Pune','deepakjadhav1618@gmail.com','DPK Automotive Pvt. Ltd.','ST987654321','VAT987654321','Managing Director','02045678902','Private Limited','$2a$10$gPjf.YyQlJt2lAGRQ0l7XuAfZKQdPw06.h0ICJAlAPD4OPq92alOS','02045678900','411057','REG20260001','Maharashtra','ABCDE1234F','PratikOllela'),(2,NULL,NULL,NULL,NULL,NULL,NULL,'deepakjadhav1256@gmail.com','Deepak Jadhav',NULL,NULL,NULL,NULL,NULL,'$2a$10$bOZSUsvZiNZzQGuhKjULv.oPgbrb4pRmVm0TS2DsgfaAV.1zVkuMS',NULL,NULL,NULL,NULL,NULL,'deepakjadhav1256@gmail.com'),(3,'501, Orion Business Park','LBS Marg, Bhandup West','+91 22 4567 8910','Virat Kohli','+91 98765 43210','Mumbai','poyekar456@gmail.com','One8Drive','ST2026789456','VATMH2745632189','Managing Director','+91 22 4567 8901','Proprietorship','$2a$10$c.ZLkC8fUimBAt3JYJWevOgmvz6YFj6mPqyBZqm5ea/S1VjBrZTXu','+91 22 4567 8901','400678','NWFS20260091','Maharashtra','AABCN4589K','ViratKohli');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_detail`
--

DROP TABLE IF EXISTS `vehicle_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_detail` (
  `confi_id` int NOT NULL AUTO_INCREMENT,
  `comp_type` enum('C','E','I','S') NOT NULL,
  `is_configurable` tinyint(1) NOT NULL,
  `comp_id` int NOT NULL,
  `model_id` int NOT NULL,
  PRIMARY KEY (`confi_id`),
  KEY `FKhih0q8yg3skwicdw9e0kigiti` (`comp_id`),
  KEY `FKob8nyvm56uj4gbkm8kjdwmole` (`model_id`),
  CONSTRAINT `FKhih0q8yg3skwicdw9e0kigiti` FOREIGN KEY (`comp_id`) REFERENCES `component_master` (`comp_id`),
  CONSTRAINT `FKob8nyvm56uj4gbkm8kjdwmole` FOREIGN KEY (`model_id`) REFERENCES `model_master` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_detail`
--

LOCK TABLES `vehicle_detail` WRITE;
/*!40000 ALTER TABLE `vehicle_detail` DISABLE KEYS */;
INSERT INTO `vehicle_detail` VALUES (1,'C',0,1,1),(2,'C',1,2,1),(3,'C',0,19,1),(4,'C',0,28,1),(5,'C',0,30,1),(6,'C',0,31,1),(7,'C',0,32,1),(8,'C',0,33,1),(9,'C',0,34,1),(10,'C',0,37,1),(11,'C',0,44,1),(12,'C',0,47,1),(13,'C',0,48,1),(14,'C',0,50,1),(15,'C',0,51,1),(16,'S',0,53,1),(17,'S',0,55,1),(18,'S',0,58,1),(19,'S',0,62,1),(20,'S',0,63,1),(21,'I',0,64,1),(22,'I',1,65,1),(23,'I',1,70,1),(24,'I',1,79,1),(25,'E',1,85,1),(26,'E',0,87,1),(27,'E',1,97,1),(28,'E',1,104,1),(29,'C',1,11,2),(30,'C',1,22,2),(31,'C',0,29,2),(32,'C',0,35,2),(33,'C',0,38,2),(34,'C',0,46,2),(35,'C',0,47,2),(36,'C',0,48,2),(37,'S',0,53,2),(38,'S',0,54,2),(39,'S',0,55,2),(40,'S',0,58,2),(41,'S',0,62,2),(42,'I',1,65,2),(43,'I',1,70,2),(44,'I',1,79,2),(45,'E',1,85,2),(46,'E',0,87,2),(47,'E',1,97,2),(48,'E',1,104,2),(49,'C',1,13,3),(50,'C',1,23,3),(51,'C',0,27,3),(52,'C',0,28,3),(53,'C',0,34,3),(54,'C',0,37,3),(55,'C',0,44,3),(56,'C',0,47,3),(57,'C',0,48,3),(58,'C',0,50,3),(59,'C',0,51,3),(60,'S',0,53,3),(61,'S',0,54,3),(62,'S',0,55,3),(63,'S',0,59,3),(64,'S',0,62,3),(65,'S',0,63,3),(66,'I',0,64,3),(67,'I',1,65,3),(68,'I',0,73,3),(69,'I',1,79,3),(70,'I',0,83,3),(71,'E',1,85,3),(72,'E',0,87,3),(73,'E',1,95,3),(74,'E',1,104,3),(75,'C',1,4,4),(76,'C',0,20,4),(77,'C',0,27,4),(78,'C',0,34,4),(79,'C',0,39,4),(80,'C',0,44,4),(81,'C',0,47,4),(82,'C',0,50,4),(83,'C',0,49,4),(84,'S',0,53,4),(85,'S',0,54,4),(86,'S',0,58,4),(87,'S',0,62,4),(88,'I',1,67,4),(89,'I',0,73,4),(90,'I',1,81,4),(91,'I',0,83,4),(92,'E',0,87,4),(93,'E',1,93,4),(94,'E',1,103,4),(95,'C',0,8,5),(96,'C',0,20,5),(97,'C',0,27,5),(98,'C',0,34,5),(99,'C',0,39,5),(100,'C',0,44,5),(101,'C',0,47,5),(102,'C',0,50,5),(103,'C',0,49,5),(104,'S',0,53,5),(105,'S',0,54,5),(106,'S',0,55,5),(107,'S',1,56,5),(108,'S',0,62,5),(109,'I',1,67,5),(110,'I',0,71,5),(111,'I',1,81,5),(112,'I',0,83,5),(113,'E',0,87,5),(114,'E',1,90,5),(115,'E',1,103,5),(116,'C',1,4,6),(117,'C',0,20,6),(118,'C',0,27,6),(119,'C',0,34,6),(120,'C',0,39,6),(121,'C',0,44,6),(122,'C',0,47,6),(123,'C',0,50,6),(124,'C',1,49,6),(125,'S',0,53,6),(126,'S',0,54,6),(127,'S',0,55,6),(128,'S',0,58,6),(129,'S',0,62,6),(130,'S',0,63,6),(131,'I',1,65,6),(132,'I',1,71,6),(133,'I',1,78,6),(134,'I',0,83,6),(135,'E',0,84,6),(136,'E',0,87,6),(137,'E',1,94,6),(138,'E',1,103,6),(139,'C',0,6,7),(140,'C',0,22,7),(141,'C',0,27,7),(142,'C',0,34,7),(143,'C',0,39,7),(144,'C',0,45,7),(145,'C',0,47,7),(146,'C',0,50,7),(147,'C',0,51,7),(148,'S',0,53,7),(149,'S',0,54,7),(150,'S',0,55,7),(151,'S',0,58,7),(152,'S',0,62,7),(153,'S',0,63,7),(154,'I',0,64,7),(155,'I',1,65,7),(156,'I',1,73,7),(157,'I',1,77,7),(158,'I',0,83,7),(159,'E',1,84,7),(160,'E',0,87,7),(161,'E',1,94,7),(162,'E',1,103,7),(163,'C',0,14,8),(164,'C',1,22,8),(165,'C',0,27,8),(166,'C',0,34,8),(167,'C',0,39,8),(168,'C',0,46,8),(169,'C',0,47,8),(170,'C',0,50,8),(171,'C',0,51,8),(172,'S',0,53,8),(173,'S',0,54,8),(174,'S',0,55,8),(175,'S',0,59,8),(176,'S',0,62,8),(177,'S',0,63,8),(178,'I',1,67,8),(179,'I',1,73,8),(180,'I',1,77,8),(181,'I',0,83,8),(182,'E',1,85,8),(183,'E',0,87,8),(184,'E',1,96,8),(185,'E',1,102,8),(186,'C',0,5,9),(187,'C',0,21,9),(188,'C',0,27,9),(189,'C',0,34,9),(190,'C',0,40,9),(191,'C',0,43,9),(192,'C',0,47,9),(193,'C',0,50,9),(194,'C',1,49,9),(195,'S',0,53,9),(196,'S',0,54,9),(197,'S',0,55,9),(198,'S',0,58,9),(199,'S',0,62,9),(200,'I',1,67,9),(201,'I',1,70,9),(202,'I',1,78,9),(203,'E',1,90,9),(204,'E',1,104,9),(205,'C',0,7,10),(206,'C',0,23,10),(207,'C',0,27,10),(208,'C',0,34,10),(209,'C',0,40,10),(210,'C',0,45,10),(211,'C',0,47,10),(212,'C',0,50,10),(213,'C',0,49,10),(214,'S',0,54,10),(215,'S',0,55,10),(216,'S',1,57,10),(217,'S',0,62,10),(218,'I',1,67,10),(219,'I',0,71,10),(220,'I',1,78,10),(221,'I',0,83,10),(222,'E',1,91,10),(223,'E',1,104,10),(224,'C',0,5,11),(225,'C',0,20,11),(226,'C',0,27,11),(227,'C',0,34,11),(228,'C',0,40,11),(229,'C',0,45,11),(230,'C',0,47,11),(231,'C',0,50,11),(232,'C',0,51,11),(233,'S',0,54,11),(234,'S',0,55,11),(235,'S',0,58,11),(236,'I',0,67,11),(237,'I',1,70,11),(238,'I',0,78,11),(239,'E',0,87,11),(240,'E',1,90,11),(241,'E',1,109,11),(242,'C',0,5,12),(243,'C',0,20,12),(244,'C',0,27,12),(245,'C',0,34,12),(246,'C',0,40,12),(247,'C',0,45,12),(248,'C',0,47,12),(249,'C',0,50,12),(250,'C',0,49,12),(251,'S',0,54,12),(252,'S',0,55,12),(253,'S',0,57,12),(254,'S',0,62,12),(255,'I',1,67,12),(256,'I',0,78,12),(257,'I',0,83,12),(258,'E',0,85,12),(259,'E',1,88,12),(260,'E',1,109,12),(261,'C',0,10,13),(262,'C',0,23,13),(263,'C',0,27,13),(264,'C',0,34,13),(265,'C',0,41,13),(266,'C',0,46,13),(267,'C',0,47,13),(268,'C',0,52,13),(269,'S',0,53,13),(270,'S',0,54,13),(271,'S',0,55,13),(272,'S',0,58,13),(273,'S',0,62,13),(274,'I',1,65,13),(275,'I',1,72,13),(276,'I',1,80,13),(277,'E',0,85,13),(278,'E',0,87,13),(279,'E',1,94,13),(280,'E',1,109,13),(281,'C',0,5,14),(282,'C',0,23,14),(283,'C',0,27,14),(284,'C',0,34,14),(285,'C',0,41,14),(286,'C',0,43,14),(287,'C',0,47,14),(288,'C',0,52,14),(289,'S',0,53,14),(290,'S',0,54,14),(291,'S',0,55,14),(292,'S',0,58,14),(293,'S',0,62,14),(294,'I',1,67,14),(295,'I',1,72,14),(296,'I',1,80,14),(297,'I',0,83,14),(298,'E',0,85,14),(299,'E',0,87,14),(300,'E',1,90,14),(301,'E',1,109,14),(302,'C',1,15,15),(303,'C',1,22,15),(304,'C',0,29,15),(305,'C',0,35,15),(306,'C',0,42,15),(307,'C',0,44,15),(308,'C',0,47,15),(309,'C',0,48,15),(310,'C',0,50,15),(311,'C',0,51,15),(312,'S',0,53,15),(313,'S',0,54,15),(314,'S',0,55,15),(315,'S',1,59,15),(316,'S',0,62,15),(317,'S',0,63,15),(318,'I',0,64,15),(319,'I',1,67,15),(320,'I',0,73,15),(321,'I',1,77,15),(322,'I',0,83,15),(323,'E',0,84,15),(324,'E',0,87,15),(325,'E',1,95,15),(326,'E',1,104,15),(327,'C',0,9,16),(328,'C',0,24,16),(329,'C',0,27,16),(330,'C',0,34,16),(331,'C',0,37,16),(332,'C',0,44,16),(333,'C',0,47,16),(334,'C',0,48,16),(335,'C',0,52,16),(336,'S',0,53,16),(337,'S',0,54,16),(338,'S',0,55,16),(339,'S',0,59,16),(340,'S',0,62,16),(341,'S',0,63,16),(342,'I',0,64,16),(343,'I',1,65,16),(344,'I',1,72,16),(345,'I',0,82,16),(346,'I',0,83,16),(347,'E',0,85,16),(348,'E',0,87,16),(349,'E',1,95,16),(350,'E',1,104,16),(351,'C',0,13,17),(352,'C',0,26,17),(353,'C',0,28,17),(354,'C',0,37,17),(355,'C',0,44,17),(356,'C',0,47,17),(357,'C',0,48,17),(358,'C',0,52,17),(359,'S',0,53,17),(360,'S',0,54,17),(361,'S',0,55,17),(362,'S',0,59,17),(363,'S',0,62,17),(364,'S',0,63,17),(365,'I',0,64,17),(366,'I',1,65,17),(367,'I',1,74,17),(368,'I',0,82,17),(369,'I',0,83,17),(370,'E',0,85,17),(371,'E',0,87,17),(372,'E',0,86,17),(373,'E',1,104,17),(374,'C',0,17,18),(375,'C',0,26,18),(376,'C',0,28,18),(377,'C',0,36,18),(378,'C',0,37,18),(379,'C',0,44,18),(380,'C',0,47,18),(381,'C',0,48,18),(382,'C',0,52,18),(383,'S',0,53,18),(384,'S',0,54,18),(385,'S',0,55,18),(386,'S',0,61,18),(387,'S',0,62,18),(388,'S',0,63,18),(389,'I',0,64,18),(390,'I',1,68,18),(391,'I',1,74,18),(392,'I',0,82,18),(393,'I',0,83,18),(394,'E',0,85,18),(395,'E',0,87,18),(396,'E',1,98,18),(397,'E',1,106,18),(398,'C',0,18,19),(399,'C',0,26,19),(400,'C',0,29,19),(401,'C',0,36,19),(402,'C',0,37,19),(403,'C',0,44,19),(404,'C',0,47,19),(405,'C',0,48,19),(406,'C',0,52,19),(407,'S',0,53,19),(408,'S',0,54,19),(409,'S',0,55,19),(410,'S',0,61,19),(411,'S',0,62,19),(412,'S',0,63,19),(413,'I',0,64,19),(414,'I',1,66,19),(415,'I',0,74,19),(416,'I',0,82,19),(417,'I',0,83,19),(418,'E',0,87,19),(419,'E',0,98,19),(420,'E',0,99,19),(421,'E',1,104,19),(422,'C',0,17,20),(423,'C',0,26,20),(424,'C',0,29,20),(425,'C',0,36,20),(426,'C',0,35,20),(427,'C',0,37,20),(428,'C',0,44,20),(429,'C',0,47,20),(430,'C',0,48,20),(431,'C',0,52,20),(432,'S',0,53,20),(433,'S',0,54,20),(434,'S',0,55,20),(435,'S',0,60,20),(436,'S',0,62,20),(437,'S',0,63,20),(438,'I',0,64,20),(439,'I',1,68,20),(440,'I',1,74,20),(441,'I',0,82,20),(442,'I',0,83,20),(443,'E',0,85,20),(444,'E',0,87,20),(445,'E',0,100,20),(446,'E',1,109,20),(447,'C',0,18,21),(448,'C',0,25,21),(449,'C',0,28,21),(450,'C',0,35,21),(451,'C',0,38,21),(452,'C',0,44,21),(453,'C',0,47,21),(454,'C',0,48,21),(455,'C',0,52,21),(456,'S',0,53,21),(457,'S',0,54,21),(458,'S',0,55,21),(459,'S',0,58,21),(460,'S',0,62,21),(461,'S',0,63,21),(462,'I',0,64,21),(463,'I',1,65,21),(464,'I',0,76,21),(465,'I',0,81,21),(466,'I',0,83,21),(467,'E',0,87,21),(468,'E',1,95,21),(469,'E',1,102,21),(470,'C',0,14,22),(471,'C',0,24,22),(472,'C',0,27,22),(473,'C',0,34,22),(474,'C',0,37,22),(475,'C',0,44,22),(476,'C',0,47,22),(477,'C',0,48,22),(478,'C',0,52,22),(479,'S',0,53,22),(480,'S',0,54,22),(481,'S',0,55,22),(482,'S',0,58,22),(483,'S',0,62,22),(484,'S',0,63,22),(485,'I',0,64,22),(486,'I',1,68,22),(487,'I',0,70,22),(488,'I',0,81,22),(489,'I',0,83,22),(490,'E',0,87,22),(491,'E',1,96,22),(492,'E',1,102,22),(493,'C',0,17,23),(494,'C',0,25,23),(495,'C',0,29,23),(496,'C',0,35,23),(497,'C',0,38,23),(498,'C',0,44,23),(499,'C',0,47,23),(500,'C',0,48,23),(501,'C',0,52,23),(502,'S',0,53,23),(503,'S',0,54,23),(504,'S',0,55,23),(505,'S',1,59,23),(506,'S',0,62,23),(507,'S',0,63,23),(508,'I',0,64,23),(509,'I',1,68,23),(510,'I',1,75,23),(511,'I',0,81,23),(512,'I',0,83,23),(513,'E',1,85,23),(514,'E',0,87,23),(515,'E',0,100,23),(516,'E',1,102,23);
/*!40000 ALTER TABLE `vehicle_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-04  9:11:02
