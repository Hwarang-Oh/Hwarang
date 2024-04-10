-- Active: 1710890946343@@127.0.0.1@3306@scott
use scott;

/* view 만들기 */
CREATE VIEW v_emp (eno, ename, sal) AS
SELECT empno, ename, sal
from emp
where
    deptno = 10;

SELECT * FROM v_emp;

/* view 만들기2 */
drop view v_emp;

CREATE or REPLACE VIEW v_emp (eno, ename, sal, deptno) AS
SELECT empno, ename, sal, deptno
from emp
where
    deptno = 10
with
    check option;

SELECT * FROM v_emp;

/* Insert 하면 Base Table에 들어감 */
/* Option에 맞는 요소만 DML이 가능하게 만들어주는 with check Option */
INSERT into v_emp VALUES (9900, 'SSAFY1', 5000, 10);

INSERT INTO v_emp VALUES (9991, 'SSAFY2', 5000, 20);

INSERT INTO v_emp VALUES (9992, 'SSAFY2', 5000, 20);

delete from emp where empno > 9000;

/* view 만들기 3 - offline 실습 */

-- step 1
-- Case when Then : 해당하지 않으면, Null로 채워짐
SELECT
    deptno,
    job,
    CASE
        WHEN job = 'CLERK' THEN sal
    END AS clerk,
    CASE
        WHEN job = 'MANAGER' THEN sal
    END AS manager,
    CASE
        WHEN job = 'PRESIDENT' THEN sal
    END AS president,
    CASE
        WHEN job = 'ANALYST' THEN sal
    END AS analyst,
    CASE
        WHEN job = 'SALESMAN' THEN sal
    END AS salesman
FROM emp;

-- step 2
SELECT
    deptno,
    sum(
        CASE
            WHEN job = 'CLERK' THEN sal
        END
    ) clerk,
    sum(
        CASE
            WHEN job = 'MANAGER' THEN sal
        END
    ) manager,
    sum(
        CASE
            WHEN job = 'PRESIDENT' THEN sal
        END
    ) president,
    sum(
        CASE
            WHEN job = 'ANALYST' THEN sal
        END
    ) analyst,
    sum(
        CASE
            WHEN job = 'SALESMAN' THEN sal
        END
    ) salesman
FROM emp
GROUP BY
    deptno;

SELECT
    deptno,
    count(
        CASE
            WHEN job = 'CLERK' THEN sal
        END
    ) clerk,
    count(
        CASE
            WHEN job = 'MANAGER' THEN sal
        END
    ) manager,
    count(
        CASE
            WHEN job = 'PRESIDENT' THEN sal
        END
    ) president,
    count(
        CASE
            WHEN job = 'ANALYST' THEN sal
        END
    ) analyst,
    count(
        CASE
            WHEN job = 'SALESMAN' THEN sal
        END
    ) salesman
FROM emp
GROUP BY
    deptno;

-- step 3 : Inline View를 만들어서 해결

SELECT
    deptno,
    sum(e.clerk) clerk,
    sum(e.manager) manager,
    sum(e.president) president,
    sum(e.analyst) analyst,
    sum(e.salesman) salesman
FROM (
        SELECT
            deptno, job, CASE
                WHEN job = 'CLERK' THEN sal
            END AS clerk, CASE
                WHEN job = 'MANAGER' THEN sal
            END AS manager, CASE
                WHEN job = 'PRESIDENT' THEN sal
            END AS president, CASE
                WHEN job = 'ANALYST' THEN sal
            END AS analyst, CASE
                WHEN job = 'SALESMAN' THEN sal
            END AS salesman
        FROM emp
    ) e
GROUP BY
    e.deptno;

-- step 5 : View 생성하고, Select
create or replace view v_emp_dept_job as
SELECT
    deptno,
    job,
    sal,
    CASE
        WHEN job = 'CLERK' THEN sal
    END AS clerk,
    CASE
        WHEN job = 'MANAGER' THEN sal
    END AS manager,
    CASE
        WHEN job = 'PRESIDENT' THEN sal
    END AS president,
    CASE
        WHEN job = 'ANALYST' THEN sal
    END AS analyst,
    CASE
        WHEN job = 'SALESMAN' THEN sal
    END AS salesman
FROM emp;

select
    dname,
    sum(clerk) clerk,
    sum(manager) manager,
    sum(president) president,
    sum(analyst) analyst,
    sum(salesman) salesman,
    sum(sal)
from v_emp_dept_job
    join dept using (deptno)
GROUP BY
    dname;
-- step6 부서별 입사월별 사원수를 피벗테이블로 조 회
CREATE OR REPLACE VIEW v_emp_dept_regmonth as
SELECT
    deptno,
    sal,
    CASE
        WHEN MONTH(hiredate) = 1 THEN sal
    End AS '1',
    CASE
        WHEN MONTH(hiredate) = 2 THEN sal
    End AS '2',
    CASE
        WHEN MONTH(hiredate) = 3 THEN sal
    End AS '3',
    CASE
        WHEN MONTH(hiredate) = 4 THEN sal
    End AS '4',
    CASE
        WHEN MONTH(hiredate) = 5 THEN sal
    End AS '5',
    CASE
        WHEN MONTH(hiredate) = 6 THEN sal
    End AS '6',
    CASE
        WHEN MONTH(hiredate) = 7 THEN sal
    End AS '7',
    CASE
        WHEN MONTH(hiredate) = 8 THEN sal
    End AS '8',
    CASE
        WHEN MONTH(hiredate) = 9 THEN sal
    End AS '9',
    CASE
        WHEN MONTH(hiredate) = 10 THEN sal
    End AS '10',
    CASE
        WHEN MONTH(hiredate) = 11 THEN sal
    End AS '11',
    CASE
        WHEN MONTH(hiredate) = 12 THEN sal
    End AS '12'
FROM emp;

CREATE OR REPLACE VIEW v_emp_dept_regmonth2 as
SELECT
    deptno,
    sal,
    if(
        MONTH(hiredate) = 1, sal, NULL
    ) as m1,
    if(
        MONTH(hiredate) = 2, sal, NULL
    ) as m2,
    if(
        MONTH(hiredate) = 3, sal, NULL
    ) as m3,
    if(
        MONTH(hiredate) = 4, sal, NULL
    ) as m4,
    if(
        MONTH(hiredate) = 5, sal, NULL
    ) as m5,
    if(
        MONTH(hiredate) = 6, sal, NULL
    ) as m6,
    if(
        MONTH(hiredate) = 7, sal, NULL
    ) as m7,
    if(
        MONTH(hiredate) = 8, sal, NULL
    ) as m8,
    if(
        MONTH(hiredate) = 9, sal, NULL
    ) as m9,
    if(
        MONTH(hiredate) = 10, sal, NULL
    ) as m10,
    if(
        MONTH(hiredate) = 11, sal, NULL
    ) as m11,
    if(
        MONTH(hiredate) = 12, sal, NULL
    ) as m12
FROM emp;

select deptno, count(m1), count(m2), count(m3), count(m4), count(m5), count(m6), count(m7), count(m8), count(m9), count(m10), count(m11), count(m12)
from v_emp_dept_regmonth2
GROUP BY
    deptno
with
    rollup;
-- ifnull(deptno, '총계') -> null 이면 총계

-- View 활용 (v_emp_dept_regmonth)
-- case 구문 대신 if 함수 활용
-- extract, date format, month ..etc -> 다양한 방법으로 가져올 수 있음.
-- rollup의 기능 => Grouping이 중첩된다?
-- group by a, b, c with rollup ( a b c 결과를 토대로 한 Grouping에 roll up => a, b grouping -> ... -> 중간 소계 같은 것을 만들어낼때 괜찮음 )