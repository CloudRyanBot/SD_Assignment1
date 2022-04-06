CREATE TABLE `vacpackage` (
  `vacpackid` int NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `total_slots` int DEFAULT NULL,
  `destination` int DEFAULT NULL,
  `extra_details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vacpackid`),
  KEY `FKey6r105ouf4dsqbi3baku4x9i` (`destination`),
  CONSTRAINT `FKey6r105ouf4dsqbi3baku4x9i` FOREIGN KEY (`destination`) REFERENCES `destination` (`destination_id`)
  )
  
  
  
 
 INSERT INTO vacpackage VALUES(1,'2022-06-20', '2000-06-13', 'Bucovinaa', 70,  42, 'Bucovina', "Extra details");
 INSERT INTO vacpackage VALUES(2,'2020-02-11', '2020-07-14', 'Bucharest package', 100,  100, 'Bucuresti', "Extra details");
 INSERT INTO vacpackage VALUES(3,'2021-10-12', '2010-01-01', 'Am incercat package', 200,  50, 'Orastie', "Extra details");
 INSERT INTO vacpackage VALUES(4,'2022-01-24', '2010-08-11', 'Am incercat package2', 300,  22, 'Orastie', "Extra details");
 INSERT INTO vacpackage VALUES(5,'2022-01-01', '2020-06-11', 'Am incercat package3', 250,  10, 'Macao', "Extra details");
 
