CREATE TABLE `destination` (
  `destination_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`destination_id`)
)

INSERT INTO destination VALUES(1, "Cluj");
INSERT INTO destination VALUES(2, "Orastie");
INSERT INTO destination VALUES(3, "Baia Mare");
INSERT INTO destination VALUES(4, "Constanta");
INSERT INTO destination VALUES(5, "Bucuresti");
