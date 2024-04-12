-- Active: 1710890946343@@127.0.0.1@3306@world
SELECT @@autocommit;

set autocommit = false;

use world;

-- 1번 : 도시명 kabul이 속한 국가의 이름은?
SELECT cnt.Code, cnt.Name
FROM country cnt
    join city cit on cnt.code = cit.countrycode
WHERE
    cit.`Name` = 'Kabul';

--2번 : 국가의 공식 언어 사용율이 100%인 국가의 정보를 출력하시오. 국가 이름으로 오름차순 정렬한다.(8건)
SELECT cnt.`Name`, cnl.`Language`, cnl.`Percentage`
FROM
    country cnt
    JOIN countrylanguage cnl on cnt.`Code` = cnl.`CountryCode`
WHERE
    cnl.`Percentage` = 100.0
    and cnl.`IsOfficial` = TRUE
ORDER BY cnt.`Name`;

--3번 : 도시명 amsterdam에서 사용되는 주요 언어와 amsterdam이 속한 국가는?
SELECT cit.`Name`, cnl.`Language`, cnt.`Name`
FROM
    city cit
    JOIN countrylanguage cnl
    JOIN country cnt ON cit.`CountryCode` = cnl.`CountryCode`
    and cit.`CountryCode` = cnt.`Code`
where
    cit.`Name` = 'amsterdam'
    and cnl.`IsOfficial` = TRUE;

-- 4번 : 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오. 단 수도 정보가 없다면 출력하지 않는다. (3건)
SELECT cnt.`Name`, cnt.`Capital`, cit.`Name`, cit.`Population`
FROM country cnt
    JOIN city cit ON cnt.`Capital` = cit.`ID`
where
    cnt.`Name` like 'united%';

-- 5번 : 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오. 단 수도 정보가 없다면 수도 없음이라고 출력한다. (4건)
SELECT cnt.`Name`, IFNULL(cnt.`Capital`, '수도없음'), IFNULL(cit.`Name`, '수도없음'), IFNULL(cit.`Population`, '수도없음')
FROM country cnt
    LEFT JOIN city cit ON cnt.`Capital` = cit.`ID`
where
    cnt.`Name` like 'united%';

-- 6번 : 국가 코드 che의 공식 언어 중 가장 사용률이 높은 언어보다 사용율이 높은 공식언어를 사용하는 국가는 몇 곳인가?
SELECT count(*) '국가 수'
FROM countrylanguage cnl
WHERE
    `Percentage` > (
        select MAX(`Percentage`)
        FROM countrylanguage cnl2
        where
            cnl2.`CountryCode` = 'che'
            and cnl2.`IsOfficial` = TRUE
    )
    and `IsOfficial` = TRUE;

-- 7번 : 국가명 south korea의 공식 언어는?
SELECT cnl.`Language`
FROM
    countrylanguage cnl
    JOIN country cnt ON cnl.`CountryCode` = cnt.`Code`
WHERE
    cnt.`Name` = 'south korea'
    and cnl.`IsOfficial` = TRUE;

-- 8번 : 국가 이름이 bo로 시작하는 국가에 속한 도시의 개수를 출력하시오. (3건)
SELECT cnt.`Name`, cnt.`Code`, count(*) '도시개수'
FROM country cnt
    JOIN city cit ON cnt.`Code` = cit.`CountryCode`
WHERE
    cnt.`Name` LIKE 'bo%'
GROUP BY
    cnt.`Code`;

-- 10번 : 인구가 가장 많은 도시는 어디인가?
SELECT cnt.`CODE`, cit.`Name`, cit.`Population`
FROM country cnt
    JOIN city cit ON cnt.`Code` = cit.`CountryCode`
WHERE
    cit.`Population` = (
        SELECT MAX(`Population`)
        FROM city
    );

-- 11번 : 가장 인구가 적은 도시의 이름, 인구수, 국가를 출력하시오.
SELECT cnt.`Name`, cit.`CountryCode`, cit.`Name`, cit.`Population`
FROM country cnt
    JOIN city cit ON cnt.`Code` = cit.`CountryCode`
WHERE
    cit.`Population` = (
        SELECT MIN(`Population`)
        FROM city
    );

-- 12번 : KOR의 seoul보다 인구가 많은 도시들을 출력하시오.
Select cit.`CountryCode`, cit.`Name`, cit.`Population`
FROM city cit
WHERE
    cit.`Population` > (
        SELECT `Population`
        FROM city cit2
        where
            cit2.`Name` = 'seoul'
            and cit2.`CountryCode` = 'KOR'
    );

-- 13번 : San Miguel 이라는 도시에 사는 사람들이 사용하는 공식 언어는?
Select cit.`CountryCode`, cnl.`Language`
FROM city cit
    JOIN countrylanguage cnl ON cit.`CountryCode` = cnl.`CountryCode`
WHERE
    cit.`Name` = 'San Miguel'
    and `IsOfficial` = TRUE;

-- 14번 :  국가 코드와 해당 국가의 최대 인구수를 출력하시오. 국가 코드로 정렬한다.(232건)
Select `CountryCode`, max(`Population`)
FROM city
GROUP BY
    `CountryCode`
ORDER BY `CountryCode`;

-- 15번 : 국가별로 가장 인구가 많은 도시의 정보를 출력하시오. 국가 코드로 정렬한다.(232건)
SELECT cit1.`CountryCode`, cit1.`Name`, cit2.maxPop
FROM city cit1
    JOIN (
        SELECT `CountryCode`, MAX(`Population`) AS maxPop
        FROM city
        GROUP BY
            `CountryCode`
    ) cit2 ON cit1.`ID` = cit2.`ID`;

SELECT `CountryCode`, MAX(`Population`) AS maxPop
FROM city
GROUP BY
    `CountryCode`;

-- 16번 : 국가 이름과 함께 국가별로 가장 인구가 많은 도시의 정보를 출력하시오.(239건)
SELECT cit1.`CountryCode`, cnt.`Name` AS CountryName, cit1.`Name` AS CityName, cit2.maxPop
FROM
    city cit1
    JOIN (
        SELECT `CountryCode`, MAX(`Population`) AS maxPop
        FROM city
        GROUP BY
            `CountryCode`
    ) cit2 ON cit1.`CountryCode` = cit2.`CountryCode`
    JOIN country cnt ON cnt.`Code` = cit1.`CountryCode`;