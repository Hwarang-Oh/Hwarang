-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id
from employees
where employee_id = 100;


select department_name
from departments
where department_id = 90;


-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employees.employee_id, employees.first_name, employees.salary, departments.department_name
from employees, departments
where employees.department_id = departments.department_id 
and employees.employee_id = 100;

select count(*)
from employees;


select count(*)
from departments;

-- alias 사용
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e, departments d
where e.department_id = d.department_id 
and e.employee_id = 100;


-- inner join
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.employee_id = 100;

select e.employee_id, e.first_name, e.salary, d.department_name
from employees e join departments d
on e.department_id = d.department_id
where e.employee_id = 100;


-- Seattle에서 근무하는 사원의 사번, 이름, 부서이름, 주소
select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e join departments d join locations l
on e.department_id = d.department_id
and d.location_id = l.location_id
where l.city = 'Seattle';

select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and l.city = 'Seattle';

select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e join departments d 
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id
where l.city = 'Seattle';

select *
from locations
where city = 'Seattle';

select *
from departments;

select *
from employees
where department_id is null;


-- using
select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e join departments d 
using (department_id)
join locations l
using (location_id)
where l.city = 'Seattle';

select e.employee_id, e.first_name, e.salary, d.department_name
from employees e join departments d
using (department_id)
where e.employee_id = 100;


-- natural join
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e natural join departments d
where e.employee_id = 100;

select *
from employees;

select *
from departments;


-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시
select d.department_id, d.department_name, l.city
from departments d NATURAL join locations l
where d.department_id = 10;


-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수 
-- 107명
select count(employee_id)
from employees;



-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..
select e.employee_id, e.first_name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id;


-- 부서가 없는(부서번호가 null) 사원 검색
select *
from employees
where department_id is null;


-- 해결
select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id;


-- 회사에 사원이 근무하는 모든 부서
-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
select department_id
from departments;


-- 사원이 근무하는 부서수 >> 11
select distinct department_id
from employees
where department_id is not null;

-- 사원이 없는 부서의 정보는 출력이 않됨.
select d.department_name, e.employee_id, e.first_name
from employees e join departments d
where e.department_id = d.department_id;


-- 해결
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- 모든 사원 , 모든 부서

select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id
union
select e.employee_id, e.first_name, d.department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
select e.employee_id 사번, e.first_name 사원이름, e.manager_id 매니저사번, m.employee_id "매니저사번2", m.first_name 매니저이름
from employees e join employees m
on e.manager_id = m.employee_id;

select *
from employees;

-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select employee_id, first_name, salary
from employees;

select *
from salgrades;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
on e.salary >= s.losal
and e.salary <= s.hisal;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
on e.salary between s.losal
and s.hisal;


-- 사번이 101인 사원의 근무 이력.
-- 근무 당시의 정보를 아래를 참고하여 출력.
-- 출력 컬럼명 : 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜의 형식은 00.00.00

-- 위의 정보를 출력 하였다면 위의 정보에 현재의 정보를 출력.
-- 현재 근무이력의 시작일은 이전 근무이력의 종료일 + 1일로 설정.
-- 종료일은 null로 설정.


select *
from job_history;

select *
from employees
where employee_id = 101;




