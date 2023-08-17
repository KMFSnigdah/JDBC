-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 17, 2023 at 12:35 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mma`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `event_category` varchar(50) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `stadium_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `event_name`, `event_category`, `event_date`, `stadium_name`, `location`) VALUES
(1, 'UFC 254', 'lightweight', '2023-10-06', 'T-Mobile Arena', 'Abu Dhabi'),
(2, 'UFC 258', 'heavyweight', '2023-09-15', 'Garden Arena', 'Las Vegas'),
(3, 'UFC 280', 'middleweight', '2023-12-10', 'Events Centre', 'Nevada');

-- --------------------------------------------------------

--
-- Table structure for table `fighters`
--

CREATE TABLE `fighters` (
  `id` int(11) NOT NULL,
  `player_name` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `weight_category` varchar(50) DEFAULT NULL,
  `win_number` int(11) DEFAULT NULL,
  `lose_number` int(11) DEFAULT NULL,
  `draw_number` int(11) DEFAULT NULL,
  `upcoming_fight_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fighters`
--

INSERT INTO `fighters` (`id`, `player_name`, `rank`, `weight_category`, `win_number`, `lose_number`, `draw_number`, `upcoming_fight_date`) VALUES
(1, 'Francis Ngannou', 1, 'heavyweight', 16, 3, 0, '2023-10-15'),
(2, 'Stipe Miocic', 2, 'heavyweight', 20, 4, 0, '2023-11-20'),
(3, 'Khabib Nurmagomedov', 1, 'lightweight', 27, 0, 0, '2023-10-06'),
(4, 'Israel Adesanya', 1, 'middleweight', 23, 1, 0, '2023-11-12'),
(5, 'Dustin Poirier', 2, 'lightweight', 21, 2, 1, '2023-10-05'),
(6, 'Jon Jones', 3, 'heavyweight', 26, 1, 0, '2023-12-15'),
(7, 'Conor McGregor', 3, 'lightweight', 17, 5, 2, '2023-11-18'),
(8, 'Robert Whittaker', 2, 'middleweight', 25, 6, 0, '2023-12-05'),
(9, 'Ciryl Gane', 4, 'heavyweight', 9, 0, 0, '2023-10-30'),
(10, 'Justin Gaethje', 4, 'lightweight', 20, 3, 1, '2023-10-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fighters`
--
ALTER TABLE `fighters`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `fighters`
--
ALTER TABLE `fighters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
