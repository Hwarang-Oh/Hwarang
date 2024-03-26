create database dbtest;
use dbtest;

-- 회원 정보 table 생성.
-- table name : ssafy_member
-- column
-- idx			int			auto_increments		PK
-- userid		varchar(16)	not null
-- username		varchar(20)
-- userpwd		varchar(16)
-- emailid		varchar(20)
-- emaildomain	varchar(50)
-- joindate		timestamp	default	current_timestamp
create table saffy_member (
idx int auto_increment, # Auto Increment index
userid		varchar(16)	not null, # notNull
username		varchar(20),
userpwd		varchar(16),
emailid		varchar(20),
emaildomain	varchar(50),
joindate		timestamp	default	current_timestamp, # default : currentTime
constraint member_idx_pk primary key (idx)
);


-- 회원 정보 등록
-- 'kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com' 등록시간
insert into saffy_member (userid, username, userpwd, emailid, emaildomain)
values ('kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com');

insert into saffy_member (userid, username, userpwd, emailid, emaildomain)
values ('killdong', '홍길동', '1234', 'kimssafy', 'ssafy.com');
## 순서가 맞지 않으면, 이상하게 data가 들어간다. 

insert into saffy_member (userid, username, userpwd, emailid, emaildomain, joinDate)
values ('killdong', '홍길동', '9876', 'killdong', 'ssafy.com', now());

insert into saffy_member (username, userid, userpwd) # 필수 Data만 넣기
values ('홍길동', 'troment', '0314');

insert into saffy_member (username, userid, userpwd) # 여러개의 Data를 넣기 
values ('이싸피', 'leessafy', '1234'), ('박싸피', 'parkssafy', '9876');
## 여러개의 Data를 넣다가 마지막 1개가 오류나면, 모든 것이 반영되지 않는다

select *
from saffy_member;
-- '김싸피', 'kimssafy', '1234'
-- '이싸피', 'leessafy', '1234'
-- '박싸피', 'parkssafy', '9876'
-- userid가 kimssafy인 회원의 비번을 9876, 이메일 도메인을 ssafy.com으로 변경.
update saffy_member
set userpwd = '9876', emaildomain = 'ssafy.com'
where userid = 'kimssafy';

-- userid가 kimssafy 회원 탈퇴
delete from saffy_member
where userid = 'kimssafy';

select *
from saffy_member;
