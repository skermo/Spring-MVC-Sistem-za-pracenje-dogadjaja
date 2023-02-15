CREATE DATABASE  IF NOT EXISTS `db_dogadjaji_172` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_dogadjaji_172`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: db_dogadjaji_172
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `dogadjaj`
--

DROP TABLE IF EXISTS `dogadjaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dogadjaj` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `naziv` varchar(255) NOT NULL,
  `opis` tinytext NOT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `kategorija_id` bigint NOT NULL,
  `lokacija_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8l36i3l9fr6nc6yixkkr17xj7` (`kategorija_id`),
  KEY `FK3dlbs4lql8l52gpjnmu4rnciu` (`lokacija_id`),
  CONSTRAINT `FK3dlbs4lql8l52gpjnmu4rnciu` FOREIGN KEY (`lokacija_id`) REFERENCES `lokacija` (`id`),
  CONSTRAINT `FK8l36i3l9fr6nc6yixkkr17xj7` FOREIGN KEY (`kategorija_id`) REFERENCES `kategorija` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogadjaj`
--

LOCK TABLES `dogadjaj` WRITE;
/*!40000 ALTER TABLE `dogadjaj` DISABLE KEYS */;
INSERT INTO `dogadjaj` VALUES (1,'2022-12-31','Doček Nove Godine','Doček Nove godine biće organizovan i ove godine u Zenici u okviru festivala “Zenica Adventure”. Posjetioce očekuje 15 dana zabave i koncerata kako domaćih, tako i regionalnih pjevača.','https://visoko.ba/wp-content/uploads/2017/10/2-13-696x400.jpg','docek-nove-godine',1,2),(2,'2022-12-29','Koncert Bajage','Jedan od najvećih i najpopularnijih pop-rock sastava nastupat će u Sarajevu sa simfonijskim orkestrom. ','https://avaz.ba/media/2022/09/23/1924905/thumbs/873x400.jpg','koncert-bajage',2,1);
/*!40000 ALTER TABLE `dogadjaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategorija` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ikonica` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'http://cdn.onlinewebfonts.com/svg/img_256194.png','zabavno'),(2,'https://cdn-icons-png.flaticon.com/512/3917/3917267.png','dugoocekivano'),(3,'https://static.vecteezy.com/system/resources/previews/005/747/906/original/info-icon-template-information-icon-colorful-free-vector.jpg','informativno');
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `komentar`
--

DROP TABLE IF EXISTS `komentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `komentar` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `tekst` tinytext,
  `dogadjaj_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ibyl2uh59y012i7qxgjyqq3w` (`dogadjaj_id`),
  CONSTRAINT `FK6ibyl2uh59y012i7qxgjyqq3w` FOREIGN KEY (`dogadjaj_id`) REFERENCES `dogadjaj` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `komentar`
--

LOCK TABLES `komentar` WRITE;
/*!40000 ALTER TABLE `komentar` DISABLE KEYS */;
INSERT INTO `komentar` VALUES (1,'2022-12-10','kermosemra@gmail.com','Jedva cekam!',1),(2,'2022-12-11','azra@gmail.com','Bit ce fenomenalno!',1),(3,'2022-12-21','azra@gmail.com','WOW',2);
/*!40000 ALTER TABLE `komentar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnici_role`
--

DROP TABLE IF EXISTS `korisnici_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnici_role` (
  `korisnik_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKqv08hllgdimvmicb6klhhokne` (`role_id`),
  KEY `FKjobpw468k9wn7a23d3dqsx2e6` (`korisnik_id`),
  CONSTRAINT `FKjobpw468k9wn7a23d3dqsx2e6` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`),
  CONSTRAINT `FKqv08hllgdimvmicb6klhhokne` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnici_role`
--

LOCK TABLES `korisnici_role` WRITE;
/*!40000 ALTER TABLE `korisnici_role` DISABLE KEYS */;
INSERT INTO `korisnici_role` VALUES (11,2),(1,1);
/*!40000 ALTER TABLE `korisnici_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'admin@gmail.com','admin','$2a$10$k9644mshajjDvMhU8p76.u4sgOFuINZDkZ/csNgzFY99W1diZjBuC','admin'),(11,'user@hotmail.com','user','$2a$10$ZEzWfCj1lo8iqvGNRKAudeOh1ERE0VKkvpyiMD/567RUXnx46qjg2','user');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lokacija`
--

DROP TABLE IF EXISTS `lokacija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lokacija` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `opis` tinytext,
  `slika` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokacija`
--

LOCK TABLES `lokacija` WRITE;
/*!40000 ALTER TABLE `lokacija` DISABLE KEYS */;
INSERT INTO `lokacija` VALUES (1,'Zenica','Zenica je grad umjerenih i ugodnih proporcija, ni previše velik da zaguši bliskost među ljudima, ni odveć malen da umanji mogućnost izbora.','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/21/e8/1d/e3/caption.jpg?w=700&h=500&s=1'),(2,'Sarajevo','Sarajevo (stari hrvatski naziv: Vrhbosna) glavni je i najveći grad Bosne i Hercegovine.','https://www.roadaffair.com/wp-content/uploads/2019/01/sebilj-fountain-sarajevo-bosnia-and-herzegovina-shutterstock_574540984-1024x683.jpg'),(3,'Banja Luka','Banja Luka jest grad u zapadnom dijelu Bosne i Hercegovine, smješten na rijeci Vrbas. Po veličini je drugi grad u Bosni i Hercegovini. Upravno je središte Republike Srpske, te privredni i kulturni centar ovog dijela Bosanske krajine.','https://upload.wikimedia.org/wikipedia/commons/b/b5/%D0%A2%D0%B2%D1%80%D1%92%D0%B0%D0%B2%D0%B0_%D0%9A%D0%B0%D1%81%D1%82%D0%B5%D0%BB_7.jpg');
/*!40000 ALTER TABLE `lokacija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_j6wp6407klpnjnq04ng0ceumq` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_GUEST');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
