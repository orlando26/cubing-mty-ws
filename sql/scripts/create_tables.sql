DROP TABLE IF EXISTS `cm_times`;
DROP TABLE IF EXISTS `cm_user_roles`;
DROP TABLE IF EXISTS `cm_roles`;
DROP TABLE IF EXISTS `cm_user`;

CREATE TABLE `cm_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `WCAID` varchar(150) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Enabled` tinyint(1) NOT NULL DEFAULT '1',
  `Img` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `cm_user_idx_1` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cm_times` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cm_User_Id` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `scramble` varchar(100) NOT NULL,
  `DNF` char(1) NOT NULL DEFAULT 'N',
  `Penalties` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `cm_time_ibfk_1` (`Cm_User_Id`),
  CONSTRAINT `cm_time_ibfk_1` FOREIGN KEY (`Cm_User_Id`) REFERENCES `cm_user` (`Id`)
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

