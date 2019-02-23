-- 롤
insert into role (id,  name) values (1, 'USER');
insert into role (id,  name) values (2, 'ADMIN');

-- 회원
INSERT INTO member (id, email, gender, nickname, password, regdate) VALUES (1, 'dpudpu@gmail.com', '남자', '배대준','$2a$10$Brjc.QgXNCcpqB2/Y3WTpeQh/mtwZAyYQPoBtXT7DSXtqCvHw6iMy',now());
INSERT INTO member (id, email, gender, nickname, password, regdate) VALUES (2, 'asdf@gmail.com', '남자', '배대','1234',now());


insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);


-- shop
INSERT INTO shop(name, type, lat, lng, address) VALUES ('블루누들', '식당',18.787500, 98.990214,'99 Ratchapakhinai Rd, Tambon Si Phum, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Umakutegoukyura-men', '식당',18.787475, 98.990053,'25-26 กาดกลางเวียง Ratchapakhinai Rd, Phra Sing, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Khao Soi Khun Yai','식당', 18.795368, 98.983214,'ซอย ศรีภูมิ 8 Sri Poom Rd, Tambon Si Phum, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('ไอติม 100 รส Ice Cream Love You','카페', 18.789075, 98.965135,'25 Suthep Road , Srivichai Soi Suthep, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('까이양 청더이','식당',18.799173 , 98.966103,'2/8 Suk Kasame Rd, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Solhy Burgers And Sliders','식당', 18.798720,98.966899 ,'Nimmanahaeminda Road, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Smiley Kitchen','식당', 18.799134,98.967509 ,'Su Thep, Mueang Chiang Mai District, 치앙마이 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Sia Fish Noodles','식당',18.796935 ,98.968786 ,'17 Nimmana Haeminda Rd Lane 11, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('TongTemToh','식당', 18.796566, 98.967707,'11 Nimmanahaeminda Road, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('RAWtruckr Nimman','식당', 18.796679,98.966906 ,'3 Nimmana Haeminda Rd Lane 13, Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('The Salad Concept','식당', 18.796728,98.966244 ,'49/9-10 ถนน นิมมานเหมินทร์ Tambon Su Thep, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50200 태국');

INSERT INTO shop(name, type, lat, lng, address) VALUES ('King''s Pizza & Cafe', '식당',18.790345, 98.956087,'Su Thep, Mueang Chiang Mai District, 치앙마이 50200 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('チェンマイホルモン', '식당', 18.805076, 98.981425,'55 Sodsueksa Rd, ช้างเผือก Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50300 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Perception Blind Massage', '마사지', 18.788365, 98.997260,'278 Thapae Rd, Tambon Chang Moi, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50300 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Moment'' Notice | Jazz Club', '펍', 18.781285, 99.001671,'193 11 Sridonchai Rd, Tambon Chang Khlan, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50100 태국');




-- INSERT INTO shop(name, address, type) VALUES ('한식집', 'address', '식당');
-- INSERT INTO shop(name, address, type) VALUES ('양식집', 'address', '식당');
-- INSERT INTO shop(name, address, type) VALUES ('피자집', 'address', '식당');
-- INSERT INTO shop(name, address, type) VALUES ('마사지1', 'address', '마사지');
-- INSERT INTO shop(name, address, type) VALUES ('마사지2', 'address', '마사지');
-- INSERT INTO shop(name, address, type) VALUES ('마사지3', 'address', '마사지');
-- INSERT INTO shop(name, address, type) VALUES ('카페2', 'address', '카페');
-- INSERT INTO shop(name, address, type, open, close ) VALUES ('카페3', 'address', '카페',0,20);

-- Filter
INSERT INTO filter(type, name) VALUES('식당','일식');
INSERT INTO filter(type, name) VALUES('식당','한식');
INSERT INTO filter(type, name) VALUES('식당','양식');
INSERT INTO filter(type, name) VALUES('모두','가성비');
INSERT INTO filter(type, name) VALUES('모두','비쌈');
INSERT INTO filter(type, name) VALUES('모두','저렴');

-- shop_filter
INSERT INTO shop_filter(shop_id, filter_id) VALUES (1, 1);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (1, 2);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (1, 3);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (1, 4);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (2, 1);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (2, 2);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (3, 1);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (3, 3);
INSERT INTO shop_filter(shop_id, filter_id) VALUES (4, 4);

-- review
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 1);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 1);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 3);