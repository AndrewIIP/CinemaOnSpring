USE `cinema`;

DROP TABLE IF EXISTS `users`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_uindex` (`email`),
  UNIQUE KEY `users_username_uindex` (`username`)
);

DROP TABLE IF EXISTS `days`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `short_name` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `movies`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `pic_url` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sessions`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` time NOT NULL,
  `time_hours_mins` varchar(1024) NOT NULL,
  `day_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_day_id_idx` (`day_id`),
  KEY `fk_movie_id_idx` (`movie_id`),
  CONSTRAINT `fk_day_id` FOREIGN KEY (`day_id`) REFERENCES `days` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `tickets`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tickets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `session_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `place_session_unique` (`place`,`session_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_session_id_idx` (`session_id`),
  CONSTRAINT `fk_session_id` FOREIGN KEY (`session_id`) REFERENCES `sessions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `roles`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_unique` (`role`)
);

DROP TABLE IF EXISTS `users_roles`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `users_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id`int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_roles_unique` (`user_id`, `role_id`)
);