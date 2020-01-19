-- docker run mysql db container: sudo docker run -v cubingmtydb:/var/lib/mysql --name cubingmtymysql -d -p 3306:3306 --network cubingmtynet -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=cubingmty mysql:5.7.29 --


CREATE TABLE `cm_times` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Cm_User_Id` int(11) NOT NULL,
  `time` int Not  NULL,
  `scramble` varchar(100) NOT NULL,
  `DNF` char DEFAULT 'N' NOT NULL,
  `Penalties` integer DEFAULT 0 NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `cm_time_ibfk_1` FOREIGN KEY (`Cm_User_Id`) REFERENCES `cm_user` (`Id`)
) 

CREATE TABLE `cm_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `WCAID` varchar(150) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Enabled` TINYINT(1) DEFAULT 1 NOT NULL,
  UNIQUE KEY `cm_user_idx_1` (`Email`),
  PRIMARY KEY (`Id`)
) 

CREATE TABLE `cm_roles` (
	`Email` varchar(50) NOT NULL,
	`Role` varchar(50) NOT NULL,
	UNIQUE KEY `cm_roles_idx_1` (`email`,`role`),
	CONSTRAINT `cm_roles_ibfk_1`
	FOREIGN KEY (`Email`) REFERENCES `cm_user` (`Email`)
) 
