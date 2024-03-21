select @@autocommit;
use dbHW;

select * from countrylanguage;
select * from country;
select * from city;

# 1
Insert into countryLanguage
values ('AAA', '외계어', 'F', 10);

# 2 
-- Insert into countryLanguage
-- values ('ABW','Dutch', 'F', 10);
-- Error Code: 1062. Duplicate entry 'ABW-Dutch' for key 'countrylanguage.PRIMARY'	0.000 sec
Insert into countryLanguage
values ('ABW', 'Korean', 'F', 10);

# 3
-- Insert into country (Code, Region, Code2)
-- values ('TCode', 'TRegion', 'TC');
-- Error Code: 1406. Data too long for column 'Code' at row 1	0.000 sec
-- Error Code: 1364. Field 'Name' doesn't have a default value	0.000 sec
Insert into country (Code, Name, Region, Code2)
values ('TCO', 'Korea', 'TRegion', 'TC');

# 4
Update city
set population = population * 1.1
where id = 2331;
select * from city
where id = 2331;

# 5
delete from country
where code = 'USA';
select * from country;

# 6
rollback;
select * from country where code = 'USA';

# 7
create database test_user;
use test_user;

# 8
drop table IF exists user;

# 9
CREATE TABLE `user` (
`id` VARCHAR(50) NOT NULL DEFAULT '',
`name` VARCHAR(100) NOT NULL DEFAULT '익명',
`pass` VARCHAR(100) NOT NULL DEFAULT '',
PRIMARY KEY (`id`)
);

# 10
Insert into user (id, pass, name)
values ('ssafy', '1234', '김싸피'), ('hong', '5678', '홍싸피'), ('test', 'test', '테스트');

# 11
Update user
set pass = concat(id, '@', name)
where id = 'test';
select * from user where id = 'test';

# 12
Delete from user
where id = 'test';
select * from user;

# 13
commit;
