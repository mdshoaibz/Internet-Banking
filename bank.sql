/*
SQLyog Community v13.1.2 (32 bit)
MySQL - 5.5.41 : Database - bank
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bank`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `EMAIL` varchar(20) DEFAULT NULL,
  `PWD` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`EMAIL`,`PWD`) values 
('imran121@gmail.com','1234');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(20) DEFAULT NULL,
  `CEMAIL` varchar(20) DEFAULT NULL,
  `CPWD` varchar(20) DEFAULT NULL,
  `CMNO` bigint(20) DEFAULT NULL,
  `BAL` int(11) DEFAULT '0',
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`CID`,`CNAME`,`CEMAIL`,`CPWD`,`CMNO`,`BAL`) values 
(1,'imran','imran@gmail.com','1234',99008765,3100),
(2,'rayyan','rayyan@gmail.com','1234',990065435,1900),
(3,'ehtasaam','eht@gmail.com','9090',98765432,1000),
(4,'rayyan','rayyan@gmail.com','1234',9813973134,2000);

/*Table structure for table `customer1` */

DROP TABLE IF EXISTS `customer1`;

CREATE TABLE `customer1` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(20) DEFAULT NULL,
  `CEMAIL` varchar(20) DEFAULT NULL,
  `CPWD` varchar(20) DEFAULT NULL,
  `CMNO` bigint(20) DEFAULT NULL,
  `BAL` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `customer1` */

insert  into `customer1`(`CID`,`CNAME`,`CEMAIL`,`CPWD`,`CMNO`,`BAL`) values 
(1,'imran','imran123@gmail.com','1234',990087654,20076),
(2,'b','b','b121',990087654,20000),
(3,'aaa','a','a121',990087654,20000),
(4,'a','a','1',121,2000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
