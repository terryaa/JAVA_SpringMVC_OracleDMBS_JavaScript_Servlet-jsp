create table member(
num number constraint member_num_pk primary key,
id varchar2(10) constraint member_id_nn not null,
pwd varchar2(10),
name varchar2(24),
email varchar2(34),
tel varchar2(34),
hiredate date,
constraint member_id_uq unique(id));
create sequence member_seq
increment by 1
start with 1;
select * from member;
select count (*), name from member where id='terryaa' and pwd='werwer' group by name;
drop table board;
create table board(
num number(5) constraint board_num_pk primary key,
pass varchar2(30),
name varchar2(30),
email varchar2(30),
title varchar2(30),
content varchar2(1000),
readcount number(4) default 0,
writedate date default sysdate);
create sequence board_seq start with 1 increment by 1;

insert into board(num,name,email,pass,title,content) values(board_seq.NEXTVAL , '������','pinksung@nate.com','1234','�湮','�ݰ����ϴ�.');
insert into board(num,name,email,pass,title,content) values(board_seq.NEXTVAL , '������','pinksung@nate.com','1234','���','���־��.');
insert into board(num,name,email,pass,title,content) values(board_seq.NEXTVAL , '������','raccon@nate.cm','3333','���','�Ͻ��Դϴ�');
insert into board(num,name,email,pass,title,content) values(board_seq.NEXTVAL , '������','one@nate.com','1111','������','���������̸��ֽ��ϴ�');
create table board_tx(
num number(5) constraint board_tx_num_pk primary key,
id varchar2(30),
title varchar2(30),
content varchar2(1000)
);
create sequence board_tx_seq increment by 1 start with 1;
create table customer_tx(
num number(5) constraint customer_tx_num_pk primary key,
ssn varchar2(20),
name varchar2(20),
address varchar2(20)
);
create table member_tx(
num number(5) constraint member_tx_num_pk primary key,
id varchar2(20),
password varchar2(20),
name varchar2(20),
address varchar2(20));
create sequence member_txt_seq increment by 1 start with 1;
insert into member_tx values(member_tx_seq.nextVal, 'test','1234','haha','incheon');