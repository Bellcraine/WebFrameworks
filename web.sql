-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 08. Jan 2018 um 14:26
-- Server-Version: 10.1.19-MariaDB
-- PHP-Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `web`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `course`
--

CREATE TABLE `course` (
  `course_pk` int(11) NOT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `duration` int(10) NOT NULL,
  `semester` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `course`
--

INSERT INTO `course` (`course_pk`, `title`, `description`, `duration`, `semester`) VALUES
(7, 'Web Frameworks', 'Java Frameworks Hibernate and Primefaces', 8, 'WS17'),
(8, 'Frontend Basics', 'JavaScript beginners course including jQuery (and hopefully Angular to get to know at least one really useful Framework)', 12, 'SS17'),
(11, 'Backend Basics', 'all about php', 12, 'SS17'),
(12, 'Agiles Projektmanagement', '', 12, 'SS17');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE `person` (
  `person_pk` int(11) NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role` enum('lecturer','student') CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`person_pk`, `username`, `password`, `name`, `lastname`, `role`) VALUES
(6, 'harry', '1234', 'Bernhard', 'Hoisl', 'lecturer'),
(7, 'urbauer', '1234', 'Philip', 'Urbauer', 'lecturer'),
(8, 'ecki', '1234', 'Florian', 'Eckkrammer', 'lecturer'),
(9, 'judith', '1234', 'Judith', 'Massar', 'student'),
(10, 'tom', '12345', 'Thomas', 'Brandstätter', 'student'),
(11, 'bob', '1234', 'Bob', 'Bobski', 'student');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person_course_membership`
--

CREATE TABLE `person_course_membership` (
  `person_fk` int(11) NOT NULL,
  `course_fk` int(11) NOT NULL,
  `grade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `person_course_membership`
--

INSERT INTO `person_course_membership` (`person_fk`, `course_fk`, `grade`) VALUES
(6, 11, NULL),
(7, 7, NULL),
(8, 8, NULL),
(8, 12, NULL),
(9, 8, NULL),
(9, 11, NULL),
(9, 12, 2),
(10, 7, 1),
(10, 8, 2),
(10, 12, 1),
(11, 8, 3),
(11, 11, NULL);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_pk`);

--
-- Indizes für die Tabelle `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_pk`);

--
-- Indizes für die Tabelle `person_course_membership`
--
ALTER TABLE `person_course_membership`
  ADD PRIMARY KEY (`person_fk`,`course_fk`),
  ADD KEY `person_fk` (`person_fk`),
  ADD KEY `course_fk` (`course_fk`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `course`
--
ALTER TABLE `course`
  MODIFY `course_pk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT für Tabelle `person`
--
ALTER TABLE `person`
  MODIFY `person_pk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `person_course_membership`
--
ALTER TABLE `person_course_membership`
  ADD CONSTRAINT `person_course_membership_ibfk_1` FOREIGN KEY (`person_fk`) REFERENCES `person` (`person_pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `person_course_membership_ibfk_2` FOREIGN KEY (`course_fk`) REFERENCES `course` (`course_pk`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
