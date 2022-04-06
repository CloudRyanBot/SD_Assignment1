CREATE TABLE `destination` (
  `destination_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`destination_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO destination VALUES(1, "Cluj");
INSERT INTO destination VALUES(2, "Orastie");
INSERT INTO destination VALUES(3, "Baia Mare");
INSERT INTO destination VALUES(4, "Constanta");
INSERT INTO destination VALUES(5, "Bucuresti");
