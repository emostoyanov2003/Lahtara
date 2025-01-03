-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2025 at 04:51 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lahtara`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `name` varchar(255) NOT NULL,
  `tellephone` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cardnumber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`name`, `tellephone`, `email`, `cardnumber`) VALUES
('11 1', '11111111111111', '1', '1'),
('asd asd', 'asd', 'asd', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `fakturi`
--

CREATE TABLE `fakturi` (
  `id` int(11) NOT NULL,
  `client` varchar(255) DEFAULT NULL,
  `dostavchik` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `plashtane` varchar(50) DEFAULT NULL,
  `suma` decimal(10,2) DEFAULT NULL,
  `otstypka` decimal(10,2) DEFAULT NULL,
  `dds` decimal(10,2) DEFAULT NULL,
  `ddsprocent` decimal(10,2) DEFAULT NULL,
  `obshto` decimal(10,2) DEFAULT NULL,
  `products` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(128) NOT NULL,
  `date` date NOT NULL,
  `client` varchar(256) NOT NULL,
  `cenabezDDS` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `dds` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `plateno` tinyint(1) DEFAULT NULL,
  `resto` decimal(10,2) DEFAULT NULL,
  `products` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `date`, `client`, `cenabezDDS`, `discount`, `dds`, `total`, `plateno`, `resto`, `products`) VALUES
(1, '2025-01-03', '', '0.00', '0.00', '0.00', '0.00', 0, '0.00', ''),
(2, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(3, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(4, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(5, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(6, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(7, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(8, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(9, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(10, '2025-01-03', 'asd asd', '3.00', '0.00', '0.00', '3.00', 0, '0.00', '1 (330 мл.) x1\n1 (330 мл.) x1\n1 (330 мл.) x1\n'),
(11, '2025-01-03', 'Няма', '44.00', '0.00', '0.00', '44.00', 0, '0.00', 'asd (330 мл.) x1\nasd (330 мл.) x1\nasd (330 мл.) x1\nasd (330 мл.) x1\n');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `proizvoditel` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `QTY` int(11) DEFAULT NULL,
  `dostavnacena` decimal(10,2) DEFAULT NULL,
  `cenabezDDS` decimal(10,2) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `butilka` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`proizvoditel`, `ime`, `QTY`, `dostavnacena`, `cenabezDDS`, `code`, `butilka`) VALUES
('1', '1 (330 мл.)', 1, '1.00', '1.00', '1', '330 мл.'),
('sje', 'asd (330 мл.)', 21, '11.00', '11.00', '111', '330 мл.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `fakturi`
--
ALTER TABLE `fakturi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fakturi`
--
ALTER TABLE `fakturi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(128) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
