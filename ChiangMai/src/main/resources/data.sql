-- 롤
insert into role (id,  name) values (1, 'USER');
insert into role (id,  name) values (2, 'ADMIN');

-- 회원
INSERT INTO member (id, email, gender, nickname, password) VALUES (1, 'dpudpu11@gmail.com', '남자', '배대준','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (2, 'asdf@gmail.com', '남자', '배대','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (3, 'dpu@gmail.com', '남자', '3','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (4, 'd@gmail.com', '남자', '대준','1234');
INSERT INTO member (id, email, gender, nickname, password) VALUES (5, 'dp@gmail.com', '남자', '5','1234');


--
insert into member_role(member_id, role_id) values( 1, 1);
insert into member_role(member_id, role_id) values( 1, 2);
insert into member_role(member_id, role_id) values( 2, 1);
insert into member_role(member_id, role_id) values( 3, 1);