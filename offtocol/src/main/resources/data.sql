

INSERT INTO house (house_name, nation_name, location) VALUES ('HairSalon A', 'JPN', 'Saitama');
INSERT INTO house (house_name, nation_name, location) VALUES ('HairSalon B', 'JPN', 'Tokyo');
INSERT INTO house (house_name, nation_name, location) VALUES ('HairSalon C', 'JPN', 'Osaka');


INSERT INTO goods (name, price, description, house_id) VALUES ('Cut', '100', 'Cut description', 1);
INSERT INTO goods (name, price, description, house_id) VALUES ('Perm', '120', 'Perm description', 1);
INSERT INTO goods (name, price, description, house_id) VALUES ('Color', '180', 'Color description', 1);
INSERT INTO goods (name, price, description, house_id) VALUES ('Treatment', '50', 'Treatment description', 1);
INSERT INTO goods (name, price, description, house_id) VALUES ('Head Spa', '80', 'Head Spa description', 1);
INSERT INTO goods (name, price, description, house_id) VALUES ('Set', '50', 'Set description', 1);

INSERT INTO goods (name, price, description, house_id) VALUES ('Cut', '80', 'Cut description', 2);
INSERT INTO goods (name, price, description, house_id) VALUES ('Perm', '100', 'Perm description', 2);
INSERT INTO goods (name, price, description, house_id) VALUES ('Color', '150', 'Color description', 2);
INSERT INTO goods (name, price, description, house_id) VALUES ('Treatment', '60', 'Treatment description', 2);
INSERT INTO goods (name, price, description, house_id) VALUES ('Head Spa', '100', 'Head Spa description', 2);
INSERT INTO goods (name, price, description, house_id) VALUES ('Set', '40', 'Set description', 2);

INSERT INTO goods (name, price, description, house_id) VALUES ('Cut', '120', 'Cut description', 3);
INSERT INTO goods (name, price, description, house_id) VALUES ('Perm', '120', 'Perm description', 3);
INSERT INTO goods (name, price, description, house_id) VALUES ('Color', '140', 'Color description', 3);
INSERT INTO goods (name, price, description, house_id) VALUES ('Treatment', '70', 'Treatment description', 3);
INSERT INTO goods (name, price, description, house_id) VALUES ('Head Spa', '90', 'Head Spa description', 3);
INSERT INTO goods (name, price, description, house_id) VALUES ('Set', '50', 'Set description', 3);


INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_A1', 1);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_A2', 1);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_A3', 1);

INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_B1', 2);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_B2', 2);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_B3', 2);

INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_C1', 3);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_C2', 3);
INSERT INTO meeting_room (room_name, house_id) VALUES ('Stylist_C3', 3);


INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 3);

INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 4);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 5);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 6);

INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 7);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 8);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 9);

INSERT INTO user (username, username2, password, role_name) VALUES ('a@a.com', 'Sara', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'USER');
INSERT INTO user (username, username2, password, role_name) VALUES ('b@a.com', 'HairSalon A', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'OWNER');
INSERT INTO user (username, username2, password, role_name) VALUES ('c@a.com', 'HairSalon B', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'OWNER');
INSERT INTO user (username, username2, password, role_name) VALUES ('d@a.com', 'HairSalon C', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'OWNER');
INSERT INTO user (username, username2, password, role_name) VALUES ('e@a.com', 'Offtocol', '$2a$10$oxSJl.keBwxmsMLkcT9lPeAIxfNTPNQxpeywMrF7A3kVszwUTqfTK', 'ADMIN');
