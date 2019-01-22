-- 롤
insert into role (id,  name) values (1, 'USER');
insert into role (id,  name) values (2, 'ADMIN');

-- 회원
INSERT INTO member (id, email, gender, nickname, password) VALUES (1, 'dpudpu11@gmail.com', '남자', '배대준','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (2, 'asdf@gmail.com', '남자', '배대','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (3, 'dpu@gmail.com', '남자', '3','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (4, 'd@gmail.com', '남자', '대준','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (5, 'dp@gmail.com', '남자', '5','1234');


insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);
insert into member_role(member_id, role_id) values( 3, 1);


-- shop
INSERT INTO shop(name, address, type) VALUES ('일식집', 'address', '식당');
INSERT INTO shop(name, address, type) VALUES ('한식집', 'address', '식당');
INSERT INTO shop(name, address, type) VALUES ('양식집', 'address', '식당');
INSERT INTO shop(name, address, type) VALUES ('피자집', 'address', '식당');
INSERT INTO shop(name, address, type) VALUES ('마사지1', 'address', '마사지');
INSERT INTO shop(name, address, type) VALUES ('마사지2', 'address', '마사지');
INSERT INTO shop(name, address, type) VALUES ('마사지3', 'address', '마사지');
INSERT INTO shop(name, address, type) VALUES ('카페1', 'address', '카페');
INSERT INTO shop(name, address, type) VALUES ('카페2', 'address', '카페');
INSERT INTO shop(name, address, type, open, close ) VALUES ('카페3', 'address', '카페',0,20);

-- Filter
INSERT INTO filter(name) VALUES('일식');
INSERT INTO filter(name) VALUES('한식');
INSERT INTO filter(name) VALUES('양식');
INSERT INTO filter(name) VALUES('가성비');
INSERT INTO filter(name) VALUES('비쌈');
INSERT INTO filter(name) VALUES('저렴');

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