-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2017 at 03:24 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `estimatesql`
--

-- --------------------------------------------------------

--
-- Table structure for table `companytbl`
--

CREATE TABLE `companytbl` (
  `CompanyID` int(11) NOT NULL,
  `CompanyName` varchar(255) NOT NULL,
  `CompanyAddr` varchar(255) NOT NULL,
  `CompanyTel` bigint(20) NOT NULL,
  `CompanyEmail` varchar(255) NOT NULL,
  `CompanyIcon` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `costbook`
--

CREATE TABLE `costbook` (
  `ItemID` int(11) NOT NULL,
  `ItemName` varchar(255) NOT NULL,
  `ItemDesc` varchar(255) NOT NULL,
  `ItemUnit` varchar(255) NOT NULL,
  `ItemUnitCst` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `estimatetbl`
--

CREATE TABLE `estimatetbl` (
  `EstimateID` int(11) NOT NULL,
  `ProjID` int(11) NOT NULL,
  `PhaseID` int(11) NOT NULL,
  `PhaseName` varchar(255) NOT NULL,
  `ItemID` int(11) NOT NULL,
  `ItemName` varchar(255) NOT NULL,
  `ItemUnit` varchar(255) NOT NULL,
  `ItemUnitCst` double NOT NULL,
  `ItemQty` int(11) NOT NULL,
  `ItemTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phasetbl`
--

CREATE TABLE `phasetbl` (
  `ProjID` int(11) NOT NULL,
  `PhaseID` int(11) NOT NULL,
  `PhaseName` varchar(255) NOT NULL,
  `MaterialCost` double NOT NULL,
  `LaborCost` double NOT NULL,
  `PhaseTotal` double NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `projectinfo`
--

CREATE TABLE `projectinfo` (
  `ProjID` int(11) NOT NULL,
  `ProjName` varchar(255) NOT NULL,
  `ProjAddr` varchar(255) NOT NULL,
  `ProjDesc` varchar(255) NOT NULL,
  `ProjCustFN` varchar(255) NOT NULL,
  `ProjCustMI` varchar(255) NOT NULL,
  `ProjCustLN` varchar(255) NOT NULL,
  `ProjEmail` varchar(255) NOT NULL,
  `ProjIcon` longblob NOT NULL,
  `ProjectCost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

CREATE TABLE `useraccount` (
  `UserID` int(11) NOT NULL,
  `UserFN` varchar(255) NOT NULL,
  `UserMI` varchar(255) NOT NULL,
  `UserLN` varchar(255) NOT NULL,
  `UserAddr` varchar(255) NOT NULL,
  `UserEmail` varchar(255) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `UserPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `workersattendance`
--

CREATE TABLE `workersattendance` (
  `AttendID` int(11) NOT NULL,
  `AttendDate` date NOT NULL,
  `Week` int(11) NOT NULL,
  `WorkAM` tinyint(1) NOT NULL,
  `WorkPM` tinyint(1) NOT NULL,
  `TotalSalr` double(10,0) NOT NULL,
  `WorkersID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `workersinfo`
--

CREATE TABLE `workersinfo` (
  `WorkersID` int(255) NOT NULL,
  `WorkersFN` varchar(255) NOT NULL,
  `WorkersMI` varchar(2) NOT NULL,
  `WorkersLN` varchar(255) NOT NULL,
  `WorkersAddr` varchar(255) NOT NULL,
  `WorkersRole` varchar(255) NOT NULL,
  `WorkersSalr` double NOT NULL,
  `WorkersProject` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `companytbl`
--
ALTER TABLE `companytbl`
  ADD PRIMARY KEY (`CompanyID`);

--
-- Indexes for table `costbook`
--
ALTER TABLE `costbook`
  ADD PRIMARY KEY (`ItemID`);

--
-- Indexes for table `estimatetbl`
--
ALTER TABLE `estimatetbl`
  ADD PRIMARY KEY (`EstimateID`),
  ADD UNIQUE KEY `ItemID` (`ItemID`),
  ADD UNIQUE KEY `ProjID` (`ProjID`),
  ADD UNIQUE KEY `PhaseID` (`PhaseID`);

--
-- Indexes for table `phasetbl`
--
ALTER TABLE `phasetbl`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ProjID` (`ProjID`),
  ADD UNIQUE KEY `PhaseID` (`PhaseID`);

--
-- Indexes for table `projectinfo`
--
ALTER TABLE `projectinfo`
  ADD PRIMARY KEY (`ProjID`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `workersattendance`
--
ALTER TABLE `workersattendance`
  ADD PRIMARY KEY (`AttendID`),
  ADD UNIQUE KEY `WorkerID` (`WorkersID`);

--
-- Indexes for table `workersinfo`
--
ALTER TABLE `workersinfo`
  ADD PRIMARY KEY (`WorkersID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `companytbl`
--
ALTER TABLE `companytbl`
  MODIFY `CompanyID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `costbook`
--
ALTER TABLE `costbook`
  MODIFY `ItemID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estimatetbl`
--
ALTER TABLE `estimatetbl`
  MODIFY `EstimateID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `phasetbl`
--
ALTER TABLE `phasetbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `projectinfo`
--
ALTER TABLE `projectinfo`
  MODIFY `ProjID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `useraccount`
--
ALTER TABLE `useraccount`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workersattendance`
--
ALTER TABLE `workersattendance`
  MODIFY `AttendID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workersinfo`
--
ALTER TABLE `workersinfo`
  MODIFY `WorkersID` int(255) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `estimatetbl`
--
ALTER TABLE `estimatetbl`
  ADD CONSTRAINT `estimatetbl_ibfk_1` FOREIGN KEY (`ItemID`) REFERENCES `costbook` (`ItemID`);

--
-- Constraints for table `phasetbl`
--
ALTER TABLE `phasetbl`
  ADD CONSTRAINT `phasetbl_ibfk_1` FOREIGN KEY (`ProjID`) REFERENCES `projectinfo` (`ProjID`),
  ADD CONSTRAINT `phasetbl_ibfk_2` FOREIGN KEY (`PhaseID`) REFERENCES `estimatetbl` (`PhaseID`);

--
-- Constraints for table `workersattendance`
--
ALTER TABLE `workersattendance`
  ADD CONSTRAINT `workersattendance_ibfk_1` FOREIGN KEY (`WorkersID`) REFERENCES `workersinfo` (`WorkersID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
