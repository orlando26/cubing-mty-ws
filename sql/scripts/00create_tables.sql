DROP TABLE IF EXISTS `cm_times`;
DROP TABLE IF EXISTS `cm_user_roles`;
DROP TABLE IF EXISTS `cm_roles`;
DROP TABLE IF EXISTS `cm_user`;
DROP TABLE IF EXISTS `cm_state`;
DROP TABLE IF EXISTS `cm_tourney`;
DROP TABLE IF EXISTS `cm_solve_tourney`;
DROP TABLE IF EXISTS `cm_city`;

CREATE TABLE IF NOT EXISTS cm_state(
	Id int not null auto_increment,
	Name VARCHAR(50) NOT NULL,
	Abbrev VARCHAR(10) NOT NULL,

	primary key(Id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS cm_city(
	Id int not null auto_increment,
	Id_State int NOT NULL,
	Name VARCHAR(50) NOT NULL,
	FOREIGN KEY(Id_State) REFERENCES cm_state(Id),

	PRIMARY KEY(Id)
) ENGINE=InnoDB;

CREATE TABLE `cm_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Nickname` varchar(50) NOT NULL,
  `WCAID` varchar(150) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `State_Id` int NOT NULL,
  `City_Id` int NOT NULL,
  `Birthday` DATETIME NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Img` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `cm_user_idx_1` (`Email`),
  UNIQUE KEY `cm_user_idx_2` (`WCAID`),
  CONSTRAINT `cm_user_ibfk_1` FOREIGN KEY (`State_Id`) REFERENCES `cm_state` (`Id`),
  CONSTRAINT `cm_user_ibfk_2` FOREIGN KEY (`City_Id`) REFERENCES `cm_city` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cm_tourney` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Start_Date` DATETIME NOT NULL,
  `End_Date` DATETIME NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `cm_tourney_idx_1` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `cm_solves` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_User` int(11) NOT NULL,
  `Time` int(11) NOT NULL,
  `Scramble` varchar(100) NOT NULL,
  `Cube` varchar(20) NOT NULL,
  `DNF` char(1) NOT NULL DEFAULT 'N',
  `Plus2` char(1) NOT NULL DEFAULT 'N',
  `Date` DATETIME NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `cm_time_ibfk_1` (`Id_User`),
  CONSTRAINT `cm_time_ibfk_1` FOREIGN KEY (`Id_User`) REFERENCES `cm_user` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cm_solve_tourney` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Solve` int(11) NOT NULL,
  `Id_Tourney` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `cm_solve_tourney_ibfk_1` FOREIGN KEY (`Id_Solve`) REFERENCES `cm_solves` (`Id`),
  CONSTRAINT `cm_solve_tourney_ibfk_2` FOREIGN KEY (`Id_Tourney`) REFERENCES `cm_tourney` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `cm_roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Role` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cm_user_roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id_User` int(11) NOT NULL,
  `Id_Role` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `cm_user_roles_ibfk_1` (`Id_User`),
  KEY `cm_user_roles_ibfk_2` (`Id_Role`),
  CONSTRAINT `cm_user_roles_ibfk_1` FOREIGN KEY (`Id_User`) REFERENCES `cm_user` (`Id`),
  CONSTRAINT `cm_user_roles_ibfk_2` FOREIGN KEY (`Id_Role`) REFERENCES `cm_roles` (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

