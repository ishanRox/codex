-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.52-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema onlinestore
--

CREATE DATABASE IF NOT EXISTS onlinestore;
USE onlinestore;

--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `disc` text NOT NULL,
  `img_url` text NOT NULL,
  `seller_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_1` (`seller_id`),
  CONSTRAINT `FK_product_1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`brand`,`model`,`price`,`qty`,`disc`,`img_url`,`seller_id`) VALUES 
 (1,'Samsung','Samsung Galaxy j7',50000,2,'1.5GHz octa-core processor , Camera 13Mpx','res/samsung_galaxy_j7.png',1),
 (2,'Motorola','Moto One vision',50000,2,'Camera 48MPx+5MPx Dual camera','res/motorola_moto_z2.png',1),
 (3,'Apple','iphone 7 RED',100000,4,'12Mpx Camera with optical image stabilization','res/iphone_8_white.png',2),
 (4,'Oppo','oppo A83',20000,10,'13MPx Rear Camera','res/oppo_f5.png',3),
 (5,'Samsung','Galaxy A7',25000,15,'24MPx+8MPx+5MPx Rear camera','res/samsung_galaxy_a7.jpg',1),
 (6,'HTC','HTC 10',30000,2,'ram 4gb','res/htc_10.jpg',1),
 (7,'HTC','HTC Desire',31000,1,'bla','res/htc_desire.jpg',3),
 (8,'Apple','iphone X',150000,1,'12MPx','res/iphone_x.jpg',3),
 (9,'Apple','iphone SE',80000,2,'bla','res/iphone_se.jpg',2),
 (10,'Nova','Nova Blue',50000,1,'bla','res/nova_blue.png',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `seller`
--

DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `mobile` int(10) unsigned NOT NULL,
  `gender` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seller`
--

/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` (`id`,`name`,`mobile`,`gender`,`city`) VALUES 
 (1,'Smart Mobile ',776187065,'male','Nugegoda'),
 (2,'Dialcom',982134567,'female','Colombo'),
 (3,'Telescience Cellular',1234567789,'male','Negombo');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
