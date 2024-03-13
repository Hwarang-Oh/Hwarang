-- 1
SELECT 
    *
FROM
    movie;
-- 2
select title
from movie;
-- 3
select *
from movie
where title = '이터널스';
-- 4
select *
from movie
where title like '해리%';
-- 5
select *
from movie
where title like '%포터%';
-- 6
select title
from movie
where id in (1000,1004);
-- 7
select lcase('touppercase') 대문자;
-- 8
select concat('해리포터와','마법사의 돌') 연결;
-- 9
select left(title,2) as '두 글자'
from movie
where year(releasedate) >= 2018 and month(releasedate) >= 1 and day(releasedate) > 1;
-- 10
select replace(title, '해리포터', '말포이') '영화 제목'
from movie
where title like '%해리포터%';
-- 11
select round(pi(), 2);

