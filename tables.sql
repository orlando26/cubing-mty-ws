CREATE TABLE `cm_times` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cm_User_Id` int(11) NOT NULL,
  `time` int Not  NULL,
  `scramble` varchar(100) NOT NULL,
  `DNF` char DEFAULT 'N' NOT NULL,
  `Penalities` integer DEFAULT 0 NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `cm_time_ibfk_1` FOREIGN KEY (`Cm_User_Id`) REFERENCES `cm_user` (`Id`)
) 

CREATE TABLE `cm_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `WCAID` varchar(150) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL
  PRIMARY KEY (`Id`)
) 