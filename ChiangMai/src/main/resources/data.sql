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

----------
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Perception Blind Massage', '마사지', 18.785365, 98.997460,'278 Thapae Rd, Tambon Chang Moi, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50300 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Moment'' Notice | Jazz Club', '펍', 18.787285, 99.001271,'193 11 Sridonchai Rd, Tambon Chang Khlan, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50100 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Perception Blind Massage', '식당', 18.789365, 98.997230,'278 Thapae Rd, Tambon Chang Moi, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50300 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('Moment'' Notice | Jazz Club', '식당', 18.785285, 99.001621,'193 11 Sridonchai Rd, Tambon Chang Khlan, Amphoe Mueang Chiang Mai, Chang Wat Chiang Mai 50100 태국');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','펍',18.785420, 98.982651,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.781270, 98.975783,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.783420, 98.982851,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','마사지',18.782270, 98.975883,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.786270, 98.975283,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','펍',18.784270, 98.975383,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.782370, 98.975283,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.786470, 98.975583,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.783270, 98.975583,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','펍',18.790928, 98.983854,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.790928, 98.982554,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.760928, 98.983854,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.793928, 98.982554,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','펍',18.790998, 98.983454,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.790528, 98.983354,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.792818, 98.985260,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','식당',18.792218, 98.986260,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','펍',18.792818, 98.986260,'111');
INSERT INTO shop(name, type, lat, lng, address) VALUES ('aa','카페',18.792718, 98.988560,'111');


-- Tag
INSERT INTO tag(type, name) VALUES('식당','일식');
INSERT INTO tag(type, name) VALUES('식당','한식');
INSERT INTO tag(type, name) VALUES('식당','양식');
INSERT INTO tag(type, name) VALUES('모두','가성비');
INSERT INTO tag(type, name) VALUES('모두','비쌈');
INSERT INTO tag(type, name) VALUES('모두','저렴');

-- shop_tag
INSERT INTO shop_tag(shop_id, tag_id) VALUES (1, 1);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (1, 2);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (1, 3);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (1, 4);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (2, 1);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (2, 2);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (3, 1);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (3, 3);
INSERT INTO shop_tag(shop_id, tag_id) VALUES (4, 4);

-- review
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 1);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 2);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 1);
INSERT INTO review(content, rating, shop_id) VALUES ('맛있다.', 5, 3);