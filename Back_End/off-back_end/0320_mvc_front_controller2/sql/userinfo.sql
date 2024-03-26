drop table if exists userinfo;
create table userinfo
(userid varchar(20) primary key,
password varchar(20) not null,
name varchar(30) not null,
email varchar(50));

insert into userinfo 
	values
    ('ssafy','1234','김싸피','ssafy@samsung.com'),
	('java','1234','자바짱','java@samsung.com');