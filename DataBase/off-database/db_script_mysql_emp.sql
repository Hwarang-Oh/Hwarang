-- drop database if exists scott;
-- create database scott;
-- use scott;
create DATABASE elevenDB;
use elevenDB;

CREATE TABLE SALGRADE( 
	GRADE int(2),
	LOSAL int,
	HISAL int,
	CONSTRAINT PK_GRADE PRIMARY KEY(grade));
    
CREATE TABLE DEPT(
	DEPTNO int(2) ,
	DNAME VARCHAR(14) ,
	LOC VARCHAR(13),
	CONSTRAINT PK_DEPT PRIMARY KEY(DEPTNO)) ;


CREATE TABLE EMP(
	EMPNO int(4) ,
	ENAME VARCHAR(10),
	JOB VARCHAR(9),
	MGR int(4) ,
	HIREDATE DATETIME,
	SAL FLOAT(7,2),
	COMM FLOAT(7,2),
	DEPTNO int(2), 
    CONSTRAINT PK_EMP PRIMARY KEY(EMPNO),
	CONSTRAINT FK_DEPTNO FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO));

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,str_to_date('17-12-1980','%d-%m-%Y'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,str_to_date('20-02-1981','%d-%m-%Y'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,str_to_date('22-02-1981','%d-%m-%Y'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,str_to_date('02-04-1981','%d-%m-%Y'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,str_to_date('28-09-1981','%d-%m-%Y'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,str_to_date('01-05-1981','%d-%m-%Y'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,str_to_date('09-06-1981','%d-%m-%Y'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,str_to_date('13-07-1987','%d-%m-%Y'),3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,str_to_date('17-11-1981','%d-%m-%Y'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,str_to_date('08-09-1981','%d-%m-%Y'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,str_to_date('13-07-1987','%d-%m-%Y'),1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,str_to_date('03-12-1981','%d-%m-%Y'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,str_to_date('03-12-1981','%d-%m-%Y'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,str_to_date('23-01-1982','%d-%m-%Y'),1300,NULL,10);



INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;
