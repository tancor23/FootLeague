-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for footleague
DROP DATABASE IF EXISTS `footleague`;
CREATE DATABASE IF NOT EXISTS `footleague` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `footleague`;

-- Dumping structure for table footleague.matches
DROP TABLE IF EXISTS `matches`;
CREATE TABLE IF NOT EXISTS `matches` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT,
  `home_team` int(11) NOT NULL,
  `guest_team` int(11) NOT NULL,
  `count_goals_home_team` int(11) NOT NULL DEFAULT '0',
  `count_goals_guest_team` int(11) NOT NULL DEFAULT '0',
  `points_home_team` tinyint(4) NOT NULL,
  `points_guest_team` tinyint(4) NOT NULL,
  PRIMARY KEY (`match_id`),
  KEY `FK_matches_teams` (`home_team`),
  KEY `FK_matches_teams_2` (`guest_team`),
  CONSTRAINT `FK_matches_teams` FOREIGN KEY (`home_team`) REFERENCES `teams` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_matches_teams_2` FOREIGN KEY (`guest_team`) REFERENCES `teams` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table footleague.matches: ~1 rows (approximately)
DELETE FROM `matches`;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` (`match_id`, `home_team`, `guest_team`, `count_goals_home_team`, `count_goals_guest_team`, `points_home_team`, `points_guest_team`) VALUES
	(1, 1, 2, 1, 0, 3, 0),
	(2, 2, 1, 0, 0, 1, 1);
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;

-- Dumping structure for table footleague.players
DROP TABLE IF EXISTS `players`;
CREATE TABLE IF NOT EXISTS `players` (
  `player_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `second_name` varchar(50) NOT NULL,
  `count_of_games` int(11) DEFAULT '0',
  `count_of_goals` int(11) DEFAULT '0',
  `count_of_yellow_cards` int(11) DEFAULT '0',
  `count_of_red_cards` int(11) DEFAULT '0',
  `position_id` tinyint(4) DEFAULT NULL,
  `number_in_team` tinyint(4) DEFAULT NULL,
  `in_team` int(11) DEFAULT NULL,
  PRIMARY KEY (`player_id`),
  KEY `FK_players_positions` (`position_id`),
  KEY `FK_players_teams` (`in_team`),
  CONSTRAINT `FK_players_positions` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_players_teams` FOREIGN KEY (`in_team`) REFERENCES `teams` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table footleague.players: ~5 rows (approximately)
DELETE FROM `players`;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` (`player_id`, `first_name`, `second_name`, `count_of_games`, `count_of_goals`, `count_of_yellow_cards`, `count_of_red_cards`, `position_id`, `number_in_team`, `in_team`) VALUES
	(1, 'Sergei', 'Vydra', 10, 1, 0, 0, 2, 23, 1),
	(2, 'David', 'de Gea', 10, 0, 0, 0, 1, 1, 2),
	(3, 'Chris', 'Smalling', 10, 0, 2, 0, 2, 12, 2),
	(4, 'Nemania', 'Matic', 10, 1, 1, 0, 3, 4, 2),
	(5, 'Phill', 'Jones', 10, 0, 0, 1, 2, 31, NULL);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;

-- Dumping structure for table footleague.positions
DROP TABLE IF EXISTS `positions`;
CREATE TABLE IF NOT EXISTS `positions` (
  `position_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `position_type` char(50) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table footleague.positions: ~4 rows (approximately)
DELETE FROM `positions`;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` (`position_id`, `position_type`) VALUES
	(1, 'goalkeeper'),
	(2, 'defender'),
	(3, 'midfielder'),
	(4, 'forward');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;

-- Dumping structure for table footleague.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `role_type` varchar(50) DEFAULT '0',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table footleague.roles: ~2 rows (approximately)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`role_id`, `role_type`) VALUES
	(1, 'user'),
	(2, 'administrator');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table footleague.teams
DROP TABLE IF EXISTS `teams`;
CREATE TABLE IF NOT EXISTS `teams` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(50) DEFAULT NULL,
  `count_wom` int(11) DEFAULT '0',
  `count_lost` int(11) DEFAULT '0',
  `count_draw` int(11) DEFAULT '0',
  `count_goals` int(11) DEFAULT '0',
  `count_missed_goals` int(11) DEFAULT '0',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table footleague.teams: ~2 rows (approximately)
DELETE FROM `teams`;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` (`team_id`, `team_name`, `count_wom`, `count_lost`, `count_draw`, `count_goals`, `count_missed_goals`) VALUES
	(1, 'device', 7, 2, 1, 20, 10),
	(2, 'manchester united', 8, 1, 1, 15, 5);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;

-- Dumping structure for table footleague.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  `role_id` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `FK_users_players` (`player_id`),
  KEY `FK_users_roles` (`role_id`),
  CONSTRAINT `FK_users_players` FOREIGN KEY (`player_id`) REFERENCES `players` (`player_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Table is users. This table has next columns: user_id, name, ';

-- Dumping data for table footleague.users: ~4 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `login`, `password`, `email`, `player_id`, `role_id`) VALUES
	(1, 'vydra', 'password_vydra', 'vydra@mail.ru', 1, 2),
	(2, 'admin', 'qwerty', 'admin@mail.ru', NULL, 2),
	(3, 'rest', 'rest123', '123@mail.ru', NULL, 1),
	(4, 'neimar', '12345678', 'neimar@mail.ru', NULL, 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
