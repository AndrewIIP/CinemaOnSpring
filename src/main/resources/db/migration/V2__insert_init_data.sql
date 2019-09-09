USE `cinema`;

INSERT INTO `roles` (`role`) VALUES ('USER');
INSERT INTO `roles` (`role`) VALUES ('ADMIN');
INSERT INTO `roles` (`role`) VALUES ('MANAGER');

INSERT INTO `users` (`id`, `username`, `email`, `password`, `active`)
  VALUES (1, 'Andrew', 'andrewonepoli@gmail.com', '$2a$10$dyTErSrRcDYw/yhp6XzRA.3ZKdaUS8oLme31Okv7o1d82h5S6Gj8i', 1);
--   PASSWORD IS 'qwerty'
INSERT INTO `users` (`id`, `username`, `email`, `password`, `active`)
  VALUES (2, 'Jack', 'jack@gmail.com', '$2a$10$95mqUAAFpzIOAOewIQ42guDT5WZiU0iXPdErAULC71vwiXbN4Rj2y', 1);
--   PASSWORD IS '1234'

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1,1);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 1);

INSERT INTO `days` (`name`, `short_name`) VALUES ('Monday', 'MON');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Tuesday', 'TUE');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Wednesday', 'WED');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Thursday', 'THU');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Friday', 'FRI');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Saturday', 'SAT');
INSERT INTO `days` (`name`, `short_name`) VALUES ('Sunday', 'SUN');

INSERT INTO `movies` (`name`, `pic_url`) VALUES ('La-La Land', 'lalaland.png');
INSERT INTO `movies` (`name`, `pic_url`) VALUES ('Leon', 'leon.png');
INSERT INTO `movies` (`name`, `pic_url`) VALUES ('First Man', 'first_man.jpg');

INSERT INTO `sessions` (`time`, `time_hours_mins`, `day_id`, `movie_id`) VALUES ('12:00:00', '180', 3, 2);
INSERT INTO `sessions` (`time`, `time_hours_mins`, `day_id`, `movie_id`) VALUES ('18:00:00', '160', 1, 1);
INSERT INTO `sessions` (`time`, `time_hours_mins`, `day_id`, `movie_id`) VALUES ('20:00:00', '120', 1, 2);

INSERT INTO `tickets` (`place`, `user_id`, `session_id`) VALUES (12, 1, 1);
INSERT INTO `tickets` (`place`, `user_id`, `session_id`) VALUES (15, 1, 2);
INSERT INTO `tickets` (`place`, `user_id`, `session_id`) VALUES (10, 2, 2);






