-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: aging_population_fitness
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `benefit`
--

DROP TABLE IF EXISTS `benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefit` (
  `benefit_id` int unsigned NOT NULL AUTO_INCREMENT,
  `exercise_id` int unsigned NOT NULL,
  `benefit_name` varchar(50) NOT NULL,
  `benefit_description` varchar(1000) NOT NULL,
  PRIMARY KEY (`benefit_id`),
  KEY `exercise_id` (`exercise_id`),
  CONSTRAINT `benefit_ibfk_1` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`exercise_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit`
--

LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
INSERT INTO `benefit` VALUES (1,1,'chest strength','strengthens chest'),(2,2,'strengthen calf','helps with daily walking'),(3,3,'strengthen ankle','helps cardiovascular strength'),(4,4,'strengthen back','helps lift heavy objects off ground'),(5,5,'strengthen abdominals','helps with getting one\'s self off the ground');
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `exercise_id` int unsigned NOT NULL AUTO_INCREMENT,
  `exercise_name` varchar(50) NOT NULL,
  `exercise_description` varchar(1000) NOT NULL,
  `exercise_difficulty` smallint unsigned NOT NULL,
  PRIMARY KEY (`exercise_id`),
  CONSTRAINT `exercise_chk_1` CHECK (((`exercise_difficulty` > 0) and (`exercise_difficulty` < 11)))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (1,'chest press','one lies supine on a bench and with both hands pushes a barbell or fixed weight upward from chest level to arm\'s length and then lowers it back to chest level',2),(2,'leg press',' individual pushes a weight or resistance away from them using their legs',7),(3,'treadmill walk','Treadmills usually feature adjustable speeds and inclines to vary your workout, allowing you to simulate a hill with the push of a button',5),(4,'dumbbell row','compound exercise that mainly target your middle back, but also work the biceps, shoulders, and lats',3),(5,'weighted situps','Hold the weight against your chest and lie on your back. Bend your knees at a 90-degree angle, and keep your feet firmly planted on the floor. While holding the weight, slowly contract your core and raise your upper body toward your knees until your forearms touch your thighs. Your hip and feet should remain on the floor.',2);
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_injury`
--

DROP TABLE IF EXISTS `exercise_injury`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_injury` (
  `injury_id` int unsigned NOT NULL AUTO_INCREMENT,
  `exercise_id` int unsigned NOT NULL,
  `exercise_injury_name` varchar(50) NOT NULL,
  `exercise_injury_description` varchar(1000) NOT NULL,
  PRIMARY KEY (`injury_id`),
  KEY `exercise_id` (`exercise_id`),
  CONSTRAINT `exercise_injury_ibfk_1` FOREIGN KEY (`exercise_id`) REFERENCES `exercise` (`exercise_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_injury`
--

LOCK TABLES `exercise_injury` WRITE;
/*!40000 ALTER TABLE `exercise_injury` DISABLE KEYS */;
INSERT INTO `exercise_injury` VALUES (1,1,'strained pectoral','chest injury'),(2,2,'calf strain','strain on leg muscle'),(3,3,'sprained ankle','sprain of foot bone'),(4,4,'finger sprain','sprain on the finger'),(5,5,'lower back pain','trouble standing or bending the back with pain in the lower region of the back');
/*!40000 ALTER TABLE `exercise_injury` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Frank','ysdhf84hnh','frankPaulsen@gmail.com'),('Joe','4367753!@#','myemail@gmail.com'),('John','myPassword45','joeJohnson@gmail.com'),('smith','password123','smith7@gmail.com'),('susan','susan123','susan@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_injury`
--

DROP TABLE IF EXISTS `user_injury`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_injury` (
  `injury_id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned NOT NULL,
  `user_injury_name` varchar(50) NOT NULL,
  `user_injury_description` varchar(1000) NOT NULL,
  `user_injury_severity` smallint unsigned DEFAULT NULL,
  `user_injury_date` date DEFAULT NULL,
  PRIMARY KEY (`injury_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_injury_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_injury_chk_1` CHECK (((`user_injury_severity` > 0) and (`user_injury_severity` < 11)))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_injury`
--

LOCK TABLES `user_injury` WRITE;
/*!40000 ALTER TABLE `user_injury` DISABLE KEYS */;
INSERT INTO `user_injury` VALUES (1,1,'Sprained Ankle','Swollen sore ankle with a bruise',2,'2021-10-01'),(2,1,'strained calf','sharp pain in left calf muscle',6,'2021-10-02'),(3,3,'broken toe','right pinky toe is broken',4,'2021-10-03'),(4,4,'Slipped disk','L4 disk slipped in lower back',9,'2021-10-04'),(5,5,'Sprained Knee','left knee is sore and it hurts to bend it',3,'2021-10-05');
/*!40000 ALTER TABLE `user_injury` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `profile_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `username` (`username`),
  CONSTRAINT `user_profile_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (1,'susan','susanLiftsALot'),(2,'smith','SmithTheMachine'),(3,'Joe','WeakMan'),(4,'Frank','FrankieP'),(5,'John','JoeJohnnyBoy');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-11 11:34:26
