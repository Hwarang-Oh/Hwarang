-- Active: 1710890946343@@127.0.0.1@3306@dbhw
SELECT @@autocommit;

set autocommit = false;

-- 1번 :  현재 날짜와 올해가 몇 일이 지났는지,100일 후는 몇일인지 출력하시오.(아래는 2020년 기준 예시)
select DATE_FORMAT(now(), '%Y-%m-%d') '오늘', DATEDIFF(
        now(), DATE_FORMAT(now(), '%Y-01-01')
    ) '올해 지난 날', DATE_FORMAT(
        DATE_ADD(now(), INTERVAL 100 day), '%Y-%m-%d'
    ) '100일 후';

-- 2번 : country에서 asia에 있는 나라 중 희망 수명이 있는 경우에
-- 기대 수명이 80 초과면 장수국가, 60 초과면 일반국가, 그렇지 않으면 단명국가라고 표현하시오.
--기대 수명으로 정렬한다.(51건)
select
    name,
    continent,
    lifeExpectancy,
    if(
        lifeExpectancy > 80, '장수국가', if(
            lifeExpectancy > 60, '일반국가', '단명국가'
        )
    ) '구분'
from country
where
    continent = 'asia';

-- 3번 : country에서 (gnp-gnpold)를 gnp 향상이라고 표현하시오.
-- 단 gnpold가 없는 경우 신규라고 출력하고 name으로 정렬한다.(239건)
select name, gnp, gnpold, if(
        gnpold IS NOT NULL, gnp - gnpold, '신규'
    ) 'gnp 향상'
from country
ORDER BY name;

-- 4번 : 2020년 어린이 날이 평일이면 행복, 토요일 또는 일요일이면 불행이라고 출력하시오.
SELECT WEEKDAY('2024-05-05') '어린이날', if(
        WEEKDAY('2024-05-05') >= 5, '불행', '행복'
    ) '행복여부';

-- 5번 :  country에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
select count(`Code`) '전체', COUNT(`IndepYear`) '독립 연도 보유'
from country;

-- 6번 : country에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2자리로 반올림한다.
SELECT SUM(`LifeExpectancy`) '합계', round(AVG(`LifeExpectancy`), 2) '평균', MAX(`LifeExpectancy`) '최대', MIN(`LifeExpectancy`) '최소'
FROM country;

-- 7번 : country에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.(7건)
SELECT Continent, count(continent), sum(population) as '인구 합'
from country
GROUP BY
    `Continent`
ORDER BY count(continent) DESC;

-- 8번 : country에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3건만 출력한다.
SELECT continent, sum(surfaceArea)
FROM country
GROUP BY
    `Continent` '표면적 합'
ORDER BY sum(`SurfaceArea`) desc
limit 3;

-- 9번 :  country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다.(5건)
SELECT continent, sum(gnp) 'gnp 합'
FROM country
where
    `Population` >= 50000000
GROUP BY
    `Continent`
ORDER BY 2;

-- 10번 : country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 이때 gnp의 합이 5,000,000 이상인 것만 구하시오.
SELECT continent, sum(gnp) 'gnp 합'
FROM country
where
    `Population` >= 50000000
GROUP BY
    `Continent`
Having
    sum(gnp) > 5000000;

-- 11번 : country에서 연도별로 10개 이상의 나라가 독립한 해는 언제인가?
Select IndepYear, count(CODE)
FROM country
WHERE
    `IndepYear` is not null
GROUP BY
    IndepYear
HAVING
    count(Code) >= 10;

-- 12번 : country에서 국가별로 gnp와 함께 전세계 평균 gnp, 대륙 평균 gnp를 출력하시오.(239건)
SELECT c.Continent, c.Name, c.GNP, world_avg.avg_world_gnp '전세계 평균', continent_avg.avg_continent_gnp '대륙 평균'
FROM
    country c
    JOIN (
        SELECT Continent, AVG(GNP) AS avg_continent_gnp
        FROM country
        GROUP BY
            Continent
    ) AS continent_avg ON c.Continent = continent_avg.Continent
    JOIN (
        SELECT AVG(GNP) AS avg_world_gnp
        FROM country
    ) AS world_avg
ORDER BY c.Continent, c.Name;