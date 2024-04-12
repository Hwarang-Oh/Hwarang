-- Active: 1710890946343@@127.0.0.1@3306@ssafydb
use ssafydb;

select @@autocommit;

set autocommit = false;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select
    employee_id,
    first_name,
    salary,
    department_name
from employees
where
    employee_id = 100;

SELECT department_name from departments WHERE department_id = 90;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select
    employee_id,
    first_name,
    salary,
    department_name
from employees, departments
where
    employee_id = 100;

SELECT count(*) FROM departments;

-- alias 사용 : smth like 가상 이름?
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e, departments d
where
    e.department_id = d.department_id
    and e.employee_id = 100;

-- inner join

-- Seattle에서 근무하는 사원의 사번, 이름, 부서이름, 주소
-- Join 1
select e.employee_id, e.first_name, d.department_name, l.street_address
from
    employees e
    join departments d
    JOIN locations l on e.department_id = d.department_id
    and d.location_id = l.location_id
where
    l.city = "Seattle";

select * from locations where city = "Seattle";

select * from departments;

-- Join 2 -> 일반적으로 많이 하는 형식

select e.employee_id, e.first_name, d.department_name, l.street_address
from
    employees e
    join departments d on e.department_id = d.department_id
    JOIN locations l on d.location_id = l.location_id
where
    l.city = "Seattle";

-- using

select e.employee_id, e.first_name, e.salary, d.department_name
from employees e
    join departments d using (department_id)
WHERE
    e.employee_id = 100;

-- natural join => 왜 안되는 것인가?
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_id, d.department_name
from employees e
    NATURAL JOIN departments d
where
    e.employee_id = 100;

-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시
select d.department_id, d.department_name, l.city
from departments d
    Natural JOIN locations l
where
    d.department_id = 10;

-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수
-- 107명
SELECT e.employee_id, e.first_name, d.department_name
FROM employees e
    left JOIN departments d on e.department_id = d.department_id;

-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..
SELECT * FROM employees where department_id is null;

-- 부서가 없는(부서번호가 null) 사원 검색

-- 해결

SELECT e.employee_id, e.first_name, d.department_name
FROM employees e
    left JOIN departments d on e.department_id = d.department_id;

-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
SELECT DISTINCT department_id from departments;

-- 사원이 근무하는 부서수 >> 11

-- 사원이 없는 부서의 정보는 출력이 않됨.

SELECT department_id FROM employees;

SELECT DISTINCT
    department_id
FROM employees
WHERE
    department_id is not null;

SELECT d.department_name, e.employee_id, e.first_name
from employees e
    Right join departments d on e.department_id = d.department_id;

-- full outer join => join된 것 2개를 Union해서 해결한다.

-- 해결

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
SELECT e.employee_id, e.first_name, e.manager_id, m.employee_id, m.first_name
from employees e
    join employees m on e.manager_id = m.employee_id;

-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, s.grade
from employees e
    JOIN salgrades s on e.salary >= s.losal
    and e.salary <= s.hisal;
-- e.salary between s.losal and s.hisal;
select * from salgrades;

-- Quiz

-- 사번이 101인 사원의 근무 이력.
-- 근무 당시의 정보를 아래를 참고하여 출력.
-- 출력 컬럼명 : 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜의 형식은 00.00.00

-- 위의 정보를 출력 하였다면 위의 정보에 현재의 정보를 출력.
-- 현재 근무이력의 시작일은 이전 근무이력의 종료일 + 1일로 설정.
-- 종료일은 null로 설정.