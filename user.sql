CREATE TABLE `user` (
  `userid` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
)


INSERT INTO user VALUES(1, 'troll@fnlk', '1234',0,'troll');
INSERT INTO user VALUES(2, 'admin@admin.admin', 'admin',1,'admin');
INSERT INTO user VALUES(3, 'use2@user.com', 'acum',0,'user2');
INSERT INTO user VALUES(4, 'potate@pot.com', 'nu',0,'nice');
INSERT INTO user VALUES(5, 'tray@fj.ro', 'hunter2',0,'Fighter');
