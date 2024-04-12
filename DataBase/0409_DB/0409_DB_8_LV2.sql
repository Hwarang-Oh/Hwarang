-- Active: 1710890946343@@127.0.0.1@3306@dbhw
SELECT * FROM cinema;

SELECT * FROM movie;

SELECT @@AutoCommit;

set AutoCommit = false;

-- 1. movie 테이블과 cinema 테이블을 Cross 조인하면 몇개의 행이 조회되는시 출력하시오.
SELECT count(*) FROM movie JOIN cinema;

-- 2. 모든 영화가 어떤 cinema에서 상영중인지 알 수 있도록 영화 정보와 시네마 정보를 모두 출력하시오.
SELECT *
FROM movie
    JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`;

-- 3. 서울에 있는 시네마에서 상영하는 영화들을 조회하시오.
SELECT *
FROM movie
    JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`
WHERE
    `Location` = '서울';

-- 4. 광주에 있는 시네마에서 상영하는 영화가 몇개인지 조회하시오.
SELECT count(*) '상영 중', cinema.`Location`
FROM movie
    JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`
GROUP BY
    cinema.`Location`
HAVING
    `Location` = '광주';

-- 5. cinema 이름으로 그룹핑 하여 각 시네마 마다 몇개의 영화가 상영중인지 조회하시오.
SELECT cinema.`CinemaName`, count(*) '상영 중'
FROM movie
    JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`
GROUP BY
    cinema.`CinemaName`;

-- 6. cinema 이름으로 그룹핑 하여 각 시네마 마다 몇개의 영화가 상영중인지 출력하는데 상영중인 영화가 0개인 시네마도 조회하시오.
SELECT cinema.`CinemaName`, count(movie.id) '상영 중'
FROM movie
    Right JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`
GROUP BY
    cinema.`CinemaName`;

-- 7. cinema 지역으로 그룹핑 하는데 상영하는 영화의 개수가 1개인 시네마의 지역들을 조회하시오.
SELECT cinema.`Location`, count(movie.id) '상영 중'
FROM movie
    Right JOIN cinema ON movie.`CinemaCode` = cinema.`CinemaCode`
GROUP BY
    cinema.`Location`
HAVING
    count(movie.`ID`) = 1;

-- 8. 영화 이름이 '이터널스' 인 영화의 상영 시간 이상인 영화 이름과 상영 시간을 출력하시오.
SELECT m.`Title`, m.`RunningTime`
FROM movie m
WHERE
    `RunningTime` >= (
        SELECT `RunningTime`
        FROM movie
        where
            `Title` LIKE '이터널스'
    );

-- 9. 상영 시간이 156분 이상인 영화들을 상영중인 cinema 이름을 출력하시오.
SELECT c.`CinemaName`
FROM cinema c
WHERE
    `CinemaCode` IN (
        SELECT `CinemaCode`
        FROM movie
        where
            `RunningTime` >= 156
    );

-- 10. 상영 시간이 156분 이상인 영화들 중 제목에 '해리포터' 라는 단어를 포함하는 영화 제목과 상영시간을 출력하시오.
SELECT m.`Title`, m.`RunningTime`
FROM movie m
WHERE
    `RunningTime` >= 156
    and `Title` LIKE '%해리포터%';