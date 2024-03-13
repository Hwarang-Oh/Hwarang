-- 1
use world;

-- 2
select * from city;
select * from country;
select * from countrylanguage;

-- 3
select *
from country
where code = 'KOR';

-- 4
select *
from country
where gnp-gnpold > 0
order by gnp-gnpold ASC;

-- 5
select distinct continent
from country
order by length(continent);

-- 6
select concat(name,'은', region, '에 속하며 인구는 ', population,'명이다.')
from country
where continent = 'Asia';

-- 7
select *
from country
where IndepYear is null and population > 10000;

-- 8
select code, name, population
from country
where population between 100000000 and 200000000
order by population desc
LIMIT 3;

-- 9
select code, name, indepyear
from country
where indepyear in (800, 1810, 1811, 1901)
order by indepyear ASC, code desc;

-- 10
select code, name, region
from country
where region like '%asia%' and instr(name,'o') = 2; # '%_o'

-- 11
select char_length('홍길동') 한글, length('hong') 영문;

-- 12
select code, name, governmentform
from country
where governmentform like '%republic%' and length(name) >= 10
order by length(name) desc
limit 10;

-- 13
select code, name
from country
where code like 'a%' or 'i%' or 'u%' or 'o%' or 'e%'
order by name asc
limit 3 offset 2;

-- 14
select name, concat(left(name,2), repeat('*', length(name) - 4),  right(name,2))
from country; 

-- 15
select distinct replace(region,' ','_') 지역들
from country
order by length(지역들) desc;

-- 16
select name, surfacearea, population, round(surfacearea/population,3) '1인당 점유면적'
from country
where population >= 100000000
order by '1인당 점유면적' asc;


