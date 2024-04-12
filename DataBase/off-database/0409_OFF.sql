SELECT e.employee_id, e.first_name, e.manager_id, m.employee_id, m.first_name
from employees e
    join employees m on e.manager_id = m.employee_id;

use elevenDB;

select e.`ENAME`, m.`ENAME`
from emp e
    Right JOIN emp m ON e.`MGR` = m.`EMPNO`
ORDER BY m.ename;

-- Smith 씨와 같은 부서에 근무하는 직원 조회
select *
From emp
where
    `DEPTNO` = (
        select `DEPTNO`
        FROM emp
        where
            `ENAME` = 'SMITH'
    );

-- 관리자인 (부하직원이 있는) 직원 조회
select *
from emp
WHERE
    empno in (
        select `MGR`
        from emp
        where
            mgr is not null
    );

-- 관리자가 아닌 (부하직원이 있는) 직원 조회
select *
from emp
WHERE
    empno Not in(
        select `MGR`
        from emp
        where
            mgr is not null
    );

select *
from emp
WHERE
    empno in (
        select `MGR`
        from emp
        where
            mgr is not null
    )
UNION
select *
from emp
WHERE
    empno Not in(
        select `MGR`
        from emp
        where
            mgr is not null
    );

-- SALESMAN의 최고 급여보다 급여를 많이 받는 직원 조회
SELECT ENAME, SAL
FROM EMP
WHERE
    SAL > (
        select MAX(SAL)
        FROM EMP
        WHERE
            JOB = 'SALESMAN'
    );

SELECT ENAME, SAL
FROM EMP
WHERE
    SAL > ANY (
        select SAL
        FROM EMP
        WHERE
            JOB = 'SALESMAN'
    );
-- ANY ALL 에서 대소 비교를 통해, 다중 행 SubQuery와의 최대 최소 비교 가능하다.
-- in -> = ANY

SELECT e.ENAME, e.SAL, e.DEPTNO
FROM emp e
WHERE
    e.SAL = (
        select MIN(SAL)
        from emp
        where
            deptNO = e.`DEPTNO`
    );
-- 상관관계 SubQuery

SELECT ENAME, SAL, DEPTNO
FROM emp
WHERE (DEPTNO, SAL) IN (
        SELECT DEPTNO, MIN(SAL)
        FROM EMP
        GROUP BY
            DEPTNO
    );