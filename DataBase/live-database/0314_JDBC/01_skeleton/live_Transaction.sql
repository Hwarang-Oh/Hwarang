select @@autocommit; -- 현재의 autocommit 속성을 확인한다.

set autocommit=false; -- 만약 위의 조회 결과가 1 즉 true 이면 false 로 변경 후 처리한다.

use dbtest;

drop table tc_test;

create table tc_test
(	
	val varchar(10)
);

start transaction;

insert into tc_test values ('I');

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

SELECT * FROM tc_test;

rollback;

select *
from tc_test;

start transaction;

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

commit; 
select @@transaction_isolation;

select *
from tc_test;

truncate tc_test;

start transaction;

insert into tc_test
values ('a');

insert into tc_test
values ('b');

insert into tc_test
values ('c');

savepoint f1; # flag 역할, 말 그대로 savePoint! -> RollBack의 기점으로 활용할 수 있다.

insert into tc_test
values ('d');

insert into tc_test
values ('e');

insert into tc_test
values ('f');

select *
from tc_test;

rollback to f1;

select *
from tc_test;

drop table tc_test;