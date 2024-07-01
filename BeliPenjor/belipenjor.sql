/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - belipenjor
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`belipenjor` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `belipenjor`;

/*Table structure for table `pembeli` */

DROP TABLE IF EXISTS `pembeli`;

CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pembeli` varchar(255) DEFAULT NULL,
  `harga_penjor` double(10,2) DEFAULT NULL,
  `jumlah_pembelian` int(11) DEFAULT NULL,
  `tanggal_beli` varchar(20) DEFAULT NULL,
  `tanggal_kirim` varchar(20) DEFAULT NULL,
  `telp` varchar(15) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pembeli`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pembeli` */

insert  into `pembeli`(`id_pembeli`,`nama_pembeli`,`harga_penjor`,`jumlah_pembelian`,`tanggal_beli`,`tanggal_kirim`,`telp`,`alamat`) values 
(1,'Ari',275000.00,2,'2024-06-27','2024-06-29','3612','Selat Sangeh'),
(2,'Ditha',250000.00,1,'2024-06-28','2024-06-29','3613','Bangli'),
(3,'briand',250000.00,2,'2024-06-29','8076','2024-06-21','Gn Agung');

/*Table structure for table `penjor` */

DROP TABLE IF EXISTS `penjor`;

CREATE TABLE `penjor` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(255) DEFAULT NULL,
  `harga_beli_barang` double(10,2) DEFAULT NULL,
  `harga_jual_barang` double(10,2) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `penjor` */

insert  into `penjor`(`id_barang`,`nama_barang`,`harga_beli_barang`,`harga_jual_barang`,`stok`) values 
(1,'PenjorA',150000.00,250000.00,1000),
(2,'PenjorB',500000.00,750000.00,25),
(3,'PenjorC',750000.00,1000000.00,10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
