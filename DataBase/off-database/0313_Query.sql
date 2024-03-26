use scott;
select * from EMP;

select 123.1234567, round(123.1234567), round(123.1234567, 1), round(123.1234567, 5), round(123.1234567, -1)
from dual; # dual은 1개 행만 존재 

select 123.1234567, round(123.1234567), round(123.1234567, 1), round(123.1234567, 5), round(123.1234567, -1); # round -> truncate?

select 123.1234567,   truncate(123.1234567, 1), truncate(123.1234567, 5), truncate(123.1234567, -1); # round -> truncate(반드시 인자가 2개 있어야 함) -> 버려버림!

# DI -> 특정 DB된 특화된 최적화인 SQL을 만들어낼 것임 in JPA ( ORM )
-- 문자함수 -> 이메일 주소에서 ID만 추출 / 도메인만 추출 
select substring('keyein123@gmail.com', 1, instr('keyein123@gmail.com','@') - 1), ID,  substring('keyein123@gmail.com', instr('keyein123@gmail.com','@') + 1) Domain;

select now(), sysdate(), sleep(1), now(), sysdate(); # 여러번 쓰인다면, 둘의 차이는 극명해지고.. + 용도에 따라 쓰임이 달라짐!
select curdate(), current_date(); # 날짜함수도 동의어 / 동일 표기 함수들이 많다 

select now(),
	date_add(now(), interval 2 day) as day2,
    date_add(now(), interval -2 day) as day19,
    date_add(now(), interval 1 month) as month1,
    date_add(now(), interval 13 month) as month13,
    date_add(now(), interval 2 day) as day2_2,
    date_add(now(), interval 19 day) as day19_2,
    date_add(now(), interval 999 year) as year99;

select ename, HIREDATE, datediff(now(), hiredate) # 날짜의 차이만 봐주는 함수, 시간 차이도 함께 보려면 time~~
from emp;

select dayname('2024-03-13'), dayofweek('2024-03-13'), weekday('2024-03-13'); 
# MySql이 인식하는 날짜 데이터 타입이어야 한다. 문자 타입 -> 날짜 타입으로 바꿀 수 있는 것도 존재 => 사용자의 로컬 환경에 따른 변환도 가능하다
# dayofweek() -> 주의 몇번째 요일 ( sunday : 1 ~ 
# weekday() -> 요일을 숫자로 반환 ( monday : 0 ~

select HIREDATE, date(hiredate), year(hiredate), month(hiredate) ## yaer month -> 숫자로 반환!!
from emp;

-- 
select str_to_date('24/01/01', '%y/%m/%d') # %M -> 월 이

select date_format(sysdate(), '%Y/%m/%d') , date_format(sysdate(), '%Y년 %m월 %d일'), date_format(sysdate(), '%Y/%m/%d %H:%i:%s %W');
-- 

insert into emp(empno, ename, sal, hiredate)
values(9999, 'ssafy', 9000, sysdate());

select * from emp;

select * from emp where hiredate = '24/03/13'; ## 시분초가 없는 애들과 시분초가 있는 둘을 비교하면, 형변환이 일어나 시분초 000과 비교하게 되면서 조회가 안됨
select * from emp where date(hiredate) = '24/03/13'; ## 시분초가 없는 애들과 시분초가 있는 둘을 비교하면, 형변환이 일어나 시분초 000과 비교하게 되면서 조회가 안됨

# Function 문 -> 받은 쪽에서 조건문을 처리해도 좋고, DB안에서 처리를 해조 좋다 
select count(*), count(comm), sum(comm), avg(comm), max(comm), min(comm)
from emp;

select count(*), count(comm), sum(comm), avg(comm), max(comm), min(comm)
from emp
where deptno = 30;

-- group by : 상사가 있는 사원들의 수
select count(*) - count(mgr)
from emp;

-- 상사인 사람들의 수 
select count(distinct mgr)
from emp;

-- 상사의 사번 리스트
select distinct mgr
from emp where mgr is not null;

-- group by 그룹핑기준
-- 부서별 사원수
select deptno, count(*), max(sal), ename
from emp
group by deptno; # group by에 ename을 넣으면 안되는가? => No (아예 의미가 달라지는 것)

select deptno dno, count(*), max(sal)
from emp
group by dno; # mySql만 지원하는 기능!!

-- 부서별 업무별 사원수
select deptno, job, count(*)
from emp
group by deptno, job;

select deptno, job, count(*)
from emp
group by deptno, job
having count(*) >= 3; # where절을 쓰지 못한다. 집계함수를 통한 조건절엔 having만 가능하다,



    