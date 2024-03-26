select @@autoCommit;
set autocommit = false;

# 1
create DATABASE test_movie;
use test_movie;

# 2
drop table if EXISTS `movie`;

# 3
create table `movie` (
  `ID` int Not Null,
  `Title` VARCHAR(40) Not Null,
  `ReleaseDate` DATE,
  `RunningTime` int NOT Null
);

# 4
ALTER Table `movie`
Add COLUMN `Director` VARCHAR(40) Not Null;

# 5
ALTER Table `movie`
MODIFY COLUMN `Director` VARCHAR(32) Null;

# 6
ALTER Table `movie`
DROP COLUMN `Director`;

# 7
INSERT INTO movie (ID, Title, ReleaseDate, RunningTime) 
VALUES (1000, '이터널스', '2021-11-05', 156),
  (1001, '트랜스포터', '2002-10-02', 92),
  (1002, '해리포터와 마법사의 돌', '2001-12-14', 152),
  (1003, '해리포터와 비밀의 방', '2002-12-14', 162),
  (1004, '기생충', '2019-05-30', 153);
SELECT * FROM movie;

# 8
UPDATE movie
set Title = '해리포터와 불의 잔'
where id = 1003;
SELECT * FROM movie;

# 9
DELETE FROM movie
where RunningTime <= 100;
SELECT * FROM movie;

# 10
delete from movie;
SELECT * FROM movie;

# End of Solution
Drop table movie;
Drop DATABASE test_movie;
ROLLBACK;