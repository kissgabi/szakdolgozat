-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 03, 2020 at 08:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kkv_sample`
--

-- --------------------------------------------------------

--
-- Table structure for table `kkv_company_datas`
--

CREATE TABLE `kkv_company_datas` (
  `name` varchar(60) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `zipcode` int(11) NOT NULL,
  `address1` varchar(60) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `address2` varchar(60) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `fax` varchar(20) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `superuser` int(11) DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- Dumping data for table `kkv_company_datas`
--

INSERT INTO `kkv_company_datas` (`name`, `zipcode`, `address1`, `address2`, `phone`, `fax`, `mobile`, `email`, `superuser`) VALUES
('B6 példa KKV', 1111, 'Budapest 11', 'Bercsényi utca 6.', '0036123456789', '0036123456789', '0036304654562', 'b6@b6.hu', 2);

-- --------------------------------------------------------

--
-- Table structure for table `kkv_message_records`
--

CREATE TABLE `kkv_message_records` (
  `record_key` int(11) NOT NULL,
  `recorded` datetime DEFAULT CURRENT_TIMESTAMP,
  `reporter` int(11) NOT NULL,
  `receiver` int(11) DEFAULT NULL,
  `message` text COLLATE utf8mb4_hungarian_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- Dumping data for table `kkv_message_records`
--

INSERT INTO `kkv_message_records` (`record_key`, `recorded`, `reporter`, `receiver`, `message`) VALUES
(1, '2020-01-11 13:40:13', 2, 2, 'Az adatbázis elkészült'),
(2, '2020-01-11 13:42:41', 2, 2, 'Felhasználói szintek bejegyzésre kerültek'),
(3, '2020-01-11 13:45:27', 2, 2, 'Alkalmazottak listája elkészült'),
(4, '2020-01-11 13:58:02', 3, 5, 'Alfonznak\nD'),
(5, '2020-01-11 14:00:07', 3, 1, 'Dóri első körüzije'),
(6, '2020-01-11 18:55:46', 3, 4, 'Szia Dávid'),
(7, '2020-01-12 13:27:02', 2, 1, 'Szerver felülvizsgálat 2020.január 20-án 5:00-12:00. Az adatbázis nem lesz elérhető ebben az időszakban'),
(8, '2020-01-16 10:22:27', 2, 5, 'Holnap megbeszélés 8-kor'),
(9, '2020-01-17 09:05:22', 2, 1, 'Ma január 17-e van'),
(10, '2020-03-03 19:46:59', 2, 1, 'Ez egy fontos üzenet!\naábccsdeéfggyiíjkllymnnyoóöőpqrsszttyuúüűvwxyzzs'),
(11, '2020-03-03 19:52:09', 3, 5, 'Szia Alfonz'),
(12, '2020-03-03 19:53:14', 3, 1, 'Ezt mindenkinek küldöm\nDóri');

-- --------------------------------------------------------

--
-- Table structure for table `kkv_user_datas`
--

CREATE TABLE `kkv_user_datas` (
  `user_key` int(11) NOT NULL,
  `user_name` varchar(40) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `user_birthday` date NOT NULL,
  `user_password` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `usergroup` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- Dumping data for table `kkv_user_datas`
--

INSERT INTO `kkv_user_datas` (`user_key`, `user_name`, `user_birthday`, `user_password`, `usergroup`) VALUES
(1, 'BroadCastUser', '2001-01-01', '3bbcaa1206773e8b10db1aebf3020d7c', 1),
(2, 'Super User', '1960-01-01', '93937f6605472e5866f02918946a891a', 2),
(3, 'Dana Dóra', '1975-01-01', 'c511a91027bcf42073d0766881d1b331', 3),
(4, 'Dózsa Dávid', '1985-01-01', 'd13917ae08845637b280eff8b45f04ff', 3),
(5, 'Albert Alfonz', '1960-01-01', '3c5851861bd461b5e4226dae38d7d498', 4);

-- --------------------------------------------------------

--
-- Table structure for table `kkv_user_groups`
--

CREATE TABLE `kkv_user_groups` (
  `usergroup_key` int(11) NOT NULL,
  `usergroup_name` varchar(40) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `usergroup_password` varchar(255) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- Dumping data for table `kkv_user_groups`
--

INSERT INTO `kkv_user_groups` (`usergroup_key`, `usergroup_name`, `usergroup_password`) VALUES
(1, 'testuser', 'testuser'),
(2, 'superuser', 'superusermysql'),
(3, 'employee', 'employeemysql'),
(4, 'director', 'directormysql');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kkv_message_records`
--
ALTER TABLE `kkv_message_records`
  ADD PRIMARY KEY (`record_key`),
  ADD KEY `reporter` (`reporter`);

--
-- Indexes for table `kkv_user_datas`
--
ALTER TABLE `kkv_user_datas`
  ADD PRIMARY KEY (`user_key`,`user_name`),
  ADD KEY `usergroup` (`usergroup`);

--
-- Indexes for table `kkv_user_groups`
--
ALTER TABLE `kkv_user_groups`
  ADD PRIMARY KEY (`usergroup_key`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kkv_message_records`
--
ALTER TABLE `kkv_message_records`
  MODIFY `record_key` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `kkv_user_datas`
--
ALTER TABLE `kkv_user_datas`
  MODIFY `user_key` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kkv_user_groups`
--
ALTER TABLE `kkv_user_groups`
  MODIFY `usergroup_key` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kkv_message_records`
--
ALTER TABLE `kkv_message_records`
  ADD CONSTRAINT `kkv_message_records_ibfk_1` FOREIGN KEY (`reporter`) REFERENCES `kkv_user_datas` (`user_key`);

--
-- Constraints for table `kkv_user_datas`
--
ALTER TABLE `kkv_user_datas`
  ADD CONSTRAINT `kkv_user_datas_ibfk_1` FOREIGN KEY (`usergroup`) REFERENCES `kkv_user_groups` (`usergroup_key`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
