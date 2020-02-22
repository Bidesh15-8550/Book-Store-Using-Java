-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2018 at 09:13 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminr`
--

CREATE TABLE IF NOT EXISTS `adminr` (
  `A_name` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminr`
--

INSERT INTO `adminr` (`A_name`, `Email`, `Password`) VALUES
('Riajul Islam', 'riajul@gmail.com', '019316');

-- --------------------------------------------------------

--
-- Table structure for table `buy_info`
--

CREATE TABLE IF NOT EXISTS `buy_info` (
  `Book_ID` varchar(350) NOT NULL,
  `Book_Type` varchar(350) NOT NULL,
  `Price` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buy_info`
--

INSERT INTO `buy_info` (`Book_ID`, `Book_Type`, `Price`) VALUES
('4B', 'BBA', '245'),
('5S', 'STORY', '560');

-- --------------------------------------------------------

--
-- Table structure for table `deliver_man`
--

CREATE TABLE IF NOT EXISTS `deliver_man` (
  `ID` varchar(300) NOT NULL,
  `Name` varchar(300) NOT NULL,
  `Password` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliver_man`
--

INSERT INTO `deliver_man` (`ID`, `Name`, `Password`) VALUES
('171-15', 'Musfiq', '9090');

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE IF NOT EXISTS `order_info` (
  `Book_ID` varchar(350) NOT NULL,
  `Book_Type` varchar(350) NOT NULL,
  `Price` varchar(350) NOT NULL,
  `Delivery_fee` varchar(350) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_info`
--

INSERT INTO `order_info` (`Book_ID`, `Book_Type`, `Price`, `Delivery_fee`) VALUES
('2B', 'BBA', '245', '40'),
('2N', 'NOVEL', '450', '40'),
('5B', 'BBA', '245', '40');

-- --------------------------------------------------------

--
-- Table structure for table `u`
--

CREATE TABLE IF NOT EXISTS `u` (
  `Name` varchar(300) NOT NULL,
  `Email` varchar(300) NOT NULL,
  `Phone` varchar(300) NOT NULL,
  `Password` varchar(300) NOT NULL,
  `Confirm` varchar(300) NOT NULL,
  `Address` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `u`
--

INSERT INTO `u` (`Name`, `Email`, `Phone`, `Password`, `Confirm`, `Address`) VALUES
('Raz', 'Raz@gmali.com', '01627077884', '0707', '0707', 'Dhanmondi'),
('Riajul', 'riajul69990@gmail.com', '01931690810', '0808', '0808', 'Rupnagar,Mirpur-2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminr`
--
ALTER TABLE `adminr`
  ADD PRIMARY KEY (`A_name`,`Email`,`Password`);

--
-- Indexes for table `buy_info`
--
ALTER TABLE `buy_info`
  ADD PRIMARY KEY (`Book_ID`);

--
-- Indexes for table `deliver_man`
--
ALTER TABLE `deliver_man`
  ADD PRIMARY KEY (`ID`,`Password`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`Book_ID`);

--
-- Indexes for table `u`
--
ALTER TABLE `u`
  ADD PRIMARY KEY (`Phone`,`Password`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
