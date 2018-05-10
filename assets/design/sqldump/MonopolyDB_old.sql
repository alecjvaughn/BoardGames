-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: localhost    Database: ABC_Monopoly_Game_Storage
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Current Database: `ABC_Monopoly_Game_Storage`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ABC_Monopoly_Game_Storage` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ABC_Monopoly_Game_Storage`;

--
-- Table structure for table `deed`
--

DROP TABLE IF EXISTS `deed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deed` (
  `deed_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(30) NOT NULL,
  `utility_name` varchar(30) NOT NULL,
  `railroad_name` varchar(30) NOT NULL,
  PRIMARY KEY (`deed_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deed`
--

LOCK TABLES `deed` WRITE;
/*!40000 ALTER TABLE `deed` DISABLE KEYS */;
/*!40000 ALTER TABLE `deed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_states`
--

DROP TABLE IF EXISTS `game_states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_states` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `round_num` int(3) NOT NULL,
  `whose_turn` int(11) NOT NULL,
  `winner` int(11) DEFAULT NULL,
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_states`
--

LOCK TABLES `game_states` WRITE;
/*!40000 ALTER TABLE `game_states` DISABLE KEYS */;
/*!40000 ALTER TABLE `game_states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_deeds`
--

DROP TABLE IF EXISTS `player_deeds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player_deeds` (
  `owner` int(11) NOT NULL,
  `deed` int(11) NOT NULL,
  PRIMARY KEY (`owner`,`deed`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_deeds`
--

LOCK TABLES `player_deeds` WRITE;
/*!40000 ALTER TABLE `player_deeds` DISABLE KEYS */;
/*!40000 ALTER TABLE `player_deeds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `pos` int(2) NOT NULL,
  `money` int(6) NOT NULL,
  `next_player` int(6) NOT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property` (
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `railroad`
--

DROP TABLE IF EXISTS `railroad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `railroad` (
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `railroad`
--

LOCK TABLES `railroad` WRITE;
/*!40000 ALTER TABLE `railroad` DISABLE KEYS */;
/*!40000 ALTER TABLE `railroad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utility`
--

DROP TABLE IF EXISTS `utility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utility` (
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utility`
--

LOCK TABLES `utility` WRITE;
/*!40000 ALTER TABLE `utility` DISABLE KEYS */;
/*!40000 ALTER TABLE `utility` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 20:44:58
