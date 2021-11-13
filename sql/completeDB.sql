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
-- Temporary view structure for view `average_user_injury_severity_greater_than_five`
--

DROP TABLE IF EXISTS `average_user_injury_severity_greater_than_five`;
/*!50001 DROP VIEW IF EXISTS `average_user_injury_severity_greater_than_five`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `average_user_injury_severity_greater_than_five` AS SELECT 
 1 AS `user_id`,
 1 AS `ROUND( AVG( user_injury_severity) )`*/;
SET character_set_client = @saved_cs_client;

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
  KEY `benefit_name_index` (`benefit_name`),
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
-- Temporary view structure for view `benefits_of_exercise_with_chest_in_description`
--

DROP TABLE IF EXISTS `benefits_of_exercise_with_chest_in_description`;
/*!50001 DROP VIEW IF EXISTS `benefits_of_exercise_with_chest_in_description`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `benefits_of_exercise_with_chest_in_description` AS SELECT 
 1 AS `benefit_id`,
 1 AS `exercise_id`,
 1 AS `benefit_name`,
 1 AS `benefit_description`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `difficulty_greater_than_five`
--

DROP TABLE IF EXISTS `difficulty_greater_than_five`;
/*!50001 DROP VIEW IF EXISTS `difficulty_greater_than_five`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `difficulty_greater_than_five` AS SELECT 
 1 AS `exercise_id`,
 1 AS `exercise_name`,
 1 AS `exercise_description`,
 1 AS `exercise_difficulty`*/;
SET character_set_client = @saved_cs_client;

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
  KEY `exercise_difficulty_index` (`exercise_difficulty`),
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
-- Temporary view structure for view `exercise_difficulty_lessthan_avg`
--

DROP TABLE IF EXISTS `exercise_difficulty_lessthan_avg`;
/*!50001 DROP VIEW IF EXISTS `exercise_difficulty_lessthan_avg`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `exercise_difficulty_lessthan_avg` AS SELECT 
 1 AS `exercise_name`,
 1 AS `exercise_description`,
 1 AS `exercise_difficulty`*/;
SET character_set_client = @saved_cs_client;

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
  KEY `exercise_injury_name_index` (`exercise_injury_name`),
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
-- Temporary view structure for view `exercise_name_lowercase`
--

DROP TABLE IF EXISTS `exercise_name_lowercase`;
/*!50001 DROP VIEW IF EXISTS `exercise_name_lowercase`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `exercise_name_lowercase` AS SELECT 
 1 AS `LOWER(exercise_name)`,
 1 AS `exercise_description`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `injury_age_days`
--

DROP TABLE IF EXISTS `injury_age_days`;
/*!50001 DROP VIEW IF EXISTS `injury_age_days`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `injury_age_days` AS SELECT 
 1 AS `user_id`,
 1 AS `user_injury_name`,
 1 AS `DATEDIFF(DATE(NOW()), user_injury_date)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `injury_greater_than_five`
--

DROP TABLE IF EXISTS `injury_greater_than_five`;
/*!50001 DROP VIEW IF EXISTS `injury_greater_than_five`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `injury_greater_than_five` AS SELECT 
 1 AS `injury_id`,
 1 AS `user_id`,
 1 AS `user_injury_name`,
 1 AS `user_injury_description`,
 1 AS `user_injury_severity`,
 1 AS `user_injury_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `profile_names_with_injury_age`
--

DROP TABLE IF EXISTS `profile_names_with_injury_age`;
/*!50001 DROP VIEW IF EXISTS `profile_names_with_injury_age`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `profile_names_with_injury_age` AS SELECT 
 1 AS `profile_name`,
 1 AS `user_injury_name`,
 1 AS `DATEDIFF(DATE(NOW()), user_injury_date)`*/;
SET character_set_client = @saved_cs_client;

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
  KEY `user_injury_severity_index` (`user_injury_severity`),
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
  KEY `profile_name_index` (`profile_name`),
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

--
-- Temporary view structure for view `users_more_than_two_injuries`
--

DROP TABLE IF EXISTS `users_more_than_two_injuries`;
/*!50001 DROP VIEW IF EXISTS `users_more_than_two_injuries`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `users_more_than_two_injuries` AS SELECT 
 1 AS `user_id`,
 1 AS `profile_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `average_user_injury_severity_greater_than_five`
--

/*!50001 DROP VIEW IF EXISTS `average_user_injury_severity_greater_than_five`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `average_user_injury_severity_greater_than_five` AS select `user_injury`.`user_id` AS `user_id`,round(avg(`user_injury`.`user_injury_severity`),0) AS `ROUND( AVG( user_injury_severity) )` from `user_injury` group by `user_injury`.`user_id` having (round(avg(`user_injury`.`user_injury_severity`),0) > 3) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `benefits_of_exercise_with_chest_in_description`
--

/*!50001 DROP VIEW IF EXISTS `benefits_of_exercise_with_chest_in_description`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `benefits_of_exercise_with_chest_in_description` AS select `B`.`benefit_id` AS `benefit_id`,`B`.`exercise_id` AS `exercise_id`,`B`.`benefit_name` AS `benefit_name`,`B`.`benefit_description` AS `benefit_description` from `benefit` `B` where exists(select 1 from `exercise` where ((`exercise`.`exercise_id` = `B`.`exercise_id`) and (`exercise`.`exercise_description` like '%chest%'))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `difficulty_greater_than_five`
--

/*!50001 DROP VIEW IF EXISTS `difficulty_greater_than_five`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `difficulty_greater_than_five` AS select `exercise`.`exercise_id` AS `exercise_id`,`exercise`.`exercise_name` AS `exercise_name`,`exercise`.`exercise_description` AS `exercise_description`,`exercise`.`exercise_difficulty` AS `exercise_difficulty` from `exercise` where (`exercise`.`exercise_difficulty` >= 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `exercise_difficulty_lessthan_avg`
--

/*!50001 DROP VIEW IF EXISTS `exercise_difficulty_lessthan_avg`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `exercise_difficulty_lessthan_avg` AS select `exercise`.`exercise_name` AS `exercise_name`,`exercise`.`exercise_description` AS `exercise_description`,`exercise`.`exercise_difficulty` AS `exercise_difficulty` from `exercise` where (`exercise`.`exercise_difficulty` < (select avg(`exercise`.`exercise_difficulty`) from `exercise`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `exercise_name_lowercase`
--

/*!50001 DROP VIEW IF EXISTS `exercise_name_lowercase`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `exercise_name_lowercase` AS select lower(`exercise`.`exercise_name`) AS `LOWER(exercise_name)`,`exercise`.`exercise_description` AS `exercise_description` from `exercise` order by `exercise`.`exercise_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `injury_age_days`
--

/*!50001 DROP VIEW IF EXISTS `injury_age_days`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `injury_age_days` AS select `user_injury`.`user_id` AS `user_id`,`user_injury`.`user_injury_name` AS `user_injury_name`,(to_days(cast(now() as date)) - to_days(`user_injury`.`user_injury_date`)) AS `DATEDIFF(DATE(NOW()), user_injury_date)` from `user_injury` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `injury_greater_than_five`
--

/*!50001 DROP VIEW IF EXISTS `injury_greater_than_five`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `injury_greater_than_five` AS select `user_injury`.`injury_id` AS `injury_id`,`user_injury`.`user_id` AS `user_id`,`user_injury`.`user_injury_name` AS `user_injury_name`,`user_injury`.`user_injury_description` AS `user_injury_description`,`user_injury`.`user_injury_severity` AS `user_injury_severity`,`user_injury`.`user_injury_date` AS `user_injury_date` from `user_injury` where (`user_injury`.`user_injury_severity` >= 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `profile_names_with_injury_age`
--

/*!50001 DROP VIEW IF EXISTS `profile_names_with_injury_age`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `profile_names_with_injury_age` AS select `user_profile`.`profile_name` AS `profile_name`,`user_injury`.`user_injury_name` AS `user_injury_name`,(to_days(cast(now() as date)) - to_days(`user_injury`.`user_injury_date`)) AS `DATEDIFF(DATE(NOW()), user_injury_date)` from (`user_injury` join `user_profile` on((`user_injury`.`user_id` = `user_profile`.`user_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `users_more_than_two_injuries`
--

/*!50001 DROP VIEW IF EXISTS `users_more_than_two_injuries`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `users_more_than_two_injuries` AS select `A`.`user_id` AS `user_id`,`A`.`profile_name` AS `profile_name` from `user_profile` `A` where (2 <= (select count(0) from `user_injury` where (`user_injury`.`user_id` = `A`.`user_id`) group by `user_injury`.`user_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-13 15:51:31
