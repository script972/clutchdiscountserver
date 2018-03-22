-- the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date, rang) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Fan', 'Jin', 'user@example.com', '+1234567890', true, '2017-10-01 21:58:58',12);
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date, rang) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Jing', 'Xiao', 'admin@example.com', '+0987654321', true, '2017-10-01 18:57:58', 34);

INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id)   VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

INSERT INTO clutchdatabase.position(lat, lng) VALUES ('46.973133', '31.993569');
INSERT INTO clutchdatabase.position(lat, lng) VALUES ('46.966402', '32.002077');
INSERT INTO clutchdatabase.position(lat, lng) VALUES (49.435335, 31.309050);
INSERT INTO clutchdatabase.position(lat, lng) VALUES (53.715932, 27.839150)
INSERT INTO clutchdatabase.position(lat, lng) VALUES (47.181151, 28.893135)
INSERT INTO clutchdatabase.position(lat, lng) VALUES (46.960240, 32.002600);
INSERT INTO clutchdatabase.position(lat, lng) VALUES (53.893214, 27.548278)
INSERT INTO clutchdatabase.position(lat, lng) VALUES (47.014670, 28.856699)
INSERT INTO clutchdatabase.position(lat, lng) VALUES (46.475966, 30.706975)



INSERT INTO country(title, position_id) VALUES ('Украина', 3)
INSERT INTO country(title, position_id) VALUES ('Беларусь', 4)
INSERT INTO country(title, position_id) VALUES ('Молдова', 5)


INSERT INTO clutchdatabase.city(city,  country_id, position_id) VALUES ('Николаев', 1, 6);
INSERT INTO clutchdatabase.city(city,  country_id, position_id) VALUES ('Минск', 2, 7);
INSERT INTO clutchdatabase.city(city,  country_id, position_id) VALUES ('Кишенев', 3, 8);
INSERT INTO clutchdatabase.city(city,  country_id, position_id) VALUES ('Одесса', 1, 9);




INSERT INTO clutchdatabase.company(title, position_id, city_id) VALUES ('ДП Адидас Украина', 1, 1);
INSERT INTO clutchdatabase.company(title, position_id, city_id) VALUES ('RodiMood', 2, 1);

INSERT INTO card_group(title, company_id) VALUES ('Adidas', 1);
INSERT INTO card_group(title) VALUES ('Madoc');
INSERT INTO card_group(title) VALUES ('Colins');
INSERT INTO card_group(title) VALUES ('Oodji');
INSERT INTO card_group(title) VALUES ('EgoIst');
INSERT INTO card_group (title, company_id) VALUES ('RodiMood', 6);

INSERT INTO card_item(number_card, title, auther_id, card_group, currency, discount) VALUES ('0000721395', 'EgoIst', 1, 5, 'грн', 100);
INSERT INTO card_item(number_card, title, auther_id, card_group, currency, discount) VALUES ('367611', 'Adidas all in', 2, 1, '%', 3);
INSERT INTO card_item (number_card, title, auther_id, card_group, currency, discount) VALUES ('2000000003320', 'RodiMood', 1, 6, '%', 12);










