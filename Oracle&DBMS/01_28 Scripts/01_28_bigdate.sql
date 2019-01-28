/*
테이블명 gogek
gobun number(3)
goname varchar2(25)
gotel varchar2(34)
gojumin varchar2(14)
godam number(3)
pk:gobun
unique,not null:jimin
foreign key godam-> sawon.sabun
*/

create table gogek(
gobun number(3),
goname varchar2(25),
gotel varchar2(34),
gojumin varchar2(14) constraint gogek_gojumin_nn not null,
godam number(3),
constraint gogek_gobun_pk primary key(gobun),
constraint gogek_gojumin_uq unique(gojumin),
constraint gogek_godam_sabun_fk foreign key(godam)
references sawon(sabun)
);
delete from dept;
delete from sawon;
delete from gogek;
commit;
--pk:gobun
--unique,not null:jimin
--foreign key godam-> sawon.sabun

Insert Into Dept Values(10, '총무부','서울');
Insert Into Dept Values(20, '영업부','대전');
Insert Into Dept Values(30, '전산부','부산');
Insert Into Dept Values(40, '관리부', '광주');
Insert Into Dept Values(50, '개발부', '가산');

Insert Into sawon Values(1,'김길동',10,'회장',5000,'1980/01/01','남자',null);
Insert Into sawon Values(2,'한국남',20,'부장',3000,'1988/11/01', '남자',1);
Insert Into sawon Values(3,'이순신',20,'과장',3500,'1985/03/01','남자', 2);
Insert Into sawon Values(5,'이순라',20,'사원',1200,'1990/05/01','여자', 3);
Insert Into sawon Values(7,'놀기만',20,'과장',2300,'1996/06/01','여자', 2);
Insert Into sawon Values(11,'류별나',20,'과장',1600,'1989/12/01','여자', 2);
Insert Into sawon Values(14,'채시라',20,'사원',3400,'1993/10/01','여자', 3);
Insert Into sawon Values(17,'이성계',30,'부장',2803,'1984/05/01','남자', 1);
Insert Into sawon Values(13,'무궁화',10,'부장',3000,'1996/11/01','여자', 1);
Insert Into sawon Values(19,'임꺽정',20,'사원',2200,'1988/04/01','남자', 7);
Insert Into sawon Values(20,'깨똥이',10,'과장',4500,'1990/05/01','남자', 13);
Insert Into sawon Values(6,'공부만',30,'과장',4003,'1995/05/01','남자', 17);
Insert Into sawon Values(8,'채송화',30,'대리',1703,'1992/06/01','여자', 17);
Insert Into sawon Values(12,'류명한',10,'대리',1800,'1990/10/01','남자', 20);
Insert Into sawon Values(9,'무궁화',10,'사원',1100,'1984/08/01','여자', 12);
Insert Into sawon Values(4,'이미라',30,'대리',2503,'1983/04/01','여자', 17);
Insert Into sawon Values(10,'공부해',30,'사원',1303,'1988/11/01','남자', 4);
Insert Into sawon Values(15,'구하라',10,'사원',2000,'1991/04/01','여자', 12);
Insert Into sawon Values(16,'김유신',30,'사원',400,'1981/04/01','남자', 4);
Insert Into sawon Values(18,'강감찬',30,'사원',1003,'1986/07/01','남자', 4);
Insert Into sawon Values(21,'김민희',50,'부장',4500,'2000/05/01','여자', 1);
Insert Into sawon Values(22,'홍실이',50,'과장',3500,'2001/11/01','여자', 21);
Insert Into sawon Values(23,'개발이',50,'대리',2500,'2002/08/01','남자', 22);
Insert Into sawon Values(24,'감수정',50,'사원',2000,'2010/05/11','남자', 23);


insert into gogek values(1,'류민', '123-1234', '700113-1537915',3);
insert into gogek values(2,'강민', '343-1454', '690216-1627914',2);
insert into gogek values(3,'영희', '144-1655', '750320-2636215',null);
insert into gogek values(4,'철이', '673-1674', '770430-1234567',4);
insert into gogek values(5,'류완', '123-1674', '720521-1123675',3);
insert into gogek values(6,'캔디', '673-1764', '650725-2534566',null);
insert into gogek values(7,'똘이', '176-7677', '630608-1648614',7);
insert into gogek values(8,'쇠돌', '673-6774', '800804-1346574',9);
insert into gogek values(9,'홍이', '767-1234', '731225-1234689',13);
insert into gogek values(10,'안나','767-1677', '751015-2432168',4);
insert into gogek values(11,'요나','767-1677', '041010-4142355',24);
insert into gogek values(12,'인군','767-1677', '031015-3112163',24);
commit;

select sname as 사원이름 from sawon;
select sname 사원이름 from sawon;
select sname "사원 이름" from sawon;
select sname || '의 사원번호는' || sabun || '입니다.' as sainfo from sawon;

select sname,sapay/12 as 연봉 from sawon;
select sname , sapay/2 *100 as 보너스 from sawon;
select sname,deptno,sapay/2*100 as 보너스 from sawon where deptno=10;
select sname,sapay from sawon where sapay>=2000 and sapay<=3000;
select sname,deptno,sapay from sawon 
where deptno>=10 and deptno<=30;

-- in연산자. or사용하는것보다 프로그래밍이 수월해짐.
--not in()
select deptno, sname from sawon where deptno in(10,20);
select deptno, sname from sawon where deptno not in(10,20);

--like 문자열 연산자.
-- % 어떤 여러 문자열
-- __ 어떤 한 문자열
--예) 이름중에 "길"이 들어가는 사원을 출력하기
select sname from sawon where sname like '%길%';
select sname from sawon where sname like '__이';

--dual 테이블 : 가상 테이블
--한 행으로 결과를 출력하기위한 가상 테이블
--산술 연산, 가상 컬럼등의 값을 한번에 출력하기위한 목적으로 사용
select 100*2 result , 140 sum from dual;
desc dual;
/*

이름    널? 유형          
----- -- ----------- 
DUMMY    VARCHAR2(1) */

select sysdate from dual;
select * from dual;

--숫자함수
select -10, abs(-10) from dual;
select sin(10),cos(10),tan(10) from dual;

--반올림
select round(88.88) from dual;
select round(88.888,0) from dual;
select round(88.888,2) from dual;
select round(88.888,-2) from dual;
--wkfltnfmfqjfla
select trunc(888.888) from dual;
--상한값(ceil),하한값(fllor)
select ceil(10.001), floor(10.99) from dual;
select mod(10,2) from dual;

select length('kostaBigdata Oracle') from dual;
select lower('kostabigdata Oracle'), upper('kostaBigdata Oracle')
from dual;
--이니셜을 대문자로
select initcap('kosta bigdata oracle') from dual;
select * from nls_database_parameters where parameter like '%CHARACTERSET%';
--AL32utf8 :한글정렬기능을 지원,3바이트공간을차지함
select lengthb('kosta'),length('kosta') from dual;
--lengthb는 문자열의 바이트수반환
select lengthb('오라클'), length('오라클') from dual;
--문자열 자르기 (trim), rtrim,ltrim
select trim(' kosta bigdata ' ),length(' kosta bigdata '),
length(trim(' kosta bigdata ')) from dual;
select ltrim('%%%kosta bigdata ','%'), rtrim('%%%kosta bigdata%%%','%') from dual;
--instr(문자열,찾을문자열,검색시작,n번째)
--문자열중에서 지정한 탁정문자가 포함된 위치를 반환하는 함수 : indexOf
select instr('kosta_kosta','k',1,2) from dual;
--Substr(문자열,n부터,n개)
-- 오라클인덱스는 1부터시작
select substr('Welcomee to Oracle',4) from dual;

--연습문제) 실습테이블 만들기
create table memphone(
num number(3) constraint memphone_num_pk primary key,
name varchar2(20),
pnum varchar2 (30));
create sequence memphone_seq
increment by 1
start with 1;

insert into memphone values (memphone_seq.nextVal,'김길동','02)567-1235');
insert into memphone values (memphone_seq.nextVal,'하지동','032)227-8235');
insert into memphone values (memphone_seq.nextVal,'김노래','031)167-8495');
insert into memphone values (memphone_seq.nextVal,'김헤헤','031)837-8475');
insert into memphone values (memphone_seq.nextVal,'김오오','032)967-6235');
commit;
--memberphone 테이블에서 사용저의 전화번호 중에
--사용자,국번,전화번호 형태로 출력하시오.
select name as '사용자', substr(pnum,instr(pnum,')',1,1)) from memphone;

select name ,substr(pnum,1,instr(pnum,')',1,1)-1) AS "phone", substr(pnum,instr(pnum,')',1,1)+1) from memphone;

--문자 채우기 함수
select rpad(sname,9,'★'), lpad(sname,8,'★') from sawon;

--decode 함수 : oracle 에서만 제공하는 SQL함수
--decode(기준값,조건1,결과1조건2,결과2,,그외) "컬럼"
--case함수 : decode 의 기능을 확장한 함수

/*
    case[기준값] when 기준값 조건값1  then 결과 1
    when 기준값 조건값2 then 결과2
    else 그외의결과
    end "칼럼명"
*/
--차이 : decode 함수는 기준값을 비교하는 컬럼값이 "=" 비교를 통해서만 조건과 일치
--case 산술,논리,관계 다양한 비교가 가능하다.
select deptno,dname from dept;
select sname,deptno,decode(deptno,50,'개발부',20,'영업부',30,'전산부','총관리부') from sawon order by 2 asc;
--case문으로바궈보기
select sname,deptno, case when deptno>10 then '개발부' else '총관리부' end AS GRADE  from sawon;

select sname||'의 급여는 '||sapay||' 입니다. 이번달 보너스는 급여의 50%('||sapay/2||') 입니다.' AS 급여조회  from sawon where sname='김길동';
select '부서번호'||deptno as deptno, sname||'님의 급여는 '||sapay||'입니다.' as message from sawon where sapay>=2000 and sapay<=3000 and deptno=20;
select sname as 사원명, sapay as 급여, round(sapay/12,-1) as 월급 , floor(sapay*3.3/100) as 세금 from sawon;
select goname as 고객명, substr(gojumin,1,7)||'*******' as 주민번호 from gogek;
select goname as 고객명, gojumin as 주민번호 , 
case when substr(gojumin,8,1)=1 or (gojumin,8,1)=3  then '남자' when substr(gojumin,8,1)=2 or (gojumin,8,1)=4 then '여자' else '성별알수없음' end as 성별 from gogek;
select sname as 사원명, sapay as 급여, case when sapay<1000 then round(sapay*10/100,0) when sapay>1000 and sapay<2000 then round(sapay*15/100,0)
when sapay>2000 then round(sapay*20/100,0) when sapay=null then 0 else 0 end as 보너스 from sawon;

select * from sawon where not regexp_like(sname,'[가-다]');
select * from sawon where not regexp_like(sname,'[0-9]');
select * from sawon where regexp_like(sname,'!');
select * from sawon where regexp_like(sname,'?');
select * from sawon where regexp_like(sname,'*');
select * from sawon where regexp_like(sname,'\?');
select * from sawon where regexp_like(sname,'\*');
select * from sawon where not regexp_like(sname,'\*');
col "no->char" for a20
select sahire, regexp_replace(sahire,'[[:digit:]]','*') "no->char" from sawon;
col "add char" for a20
select sahire, regexp_replace(sahire,'([0-9])','\1-*') "add char" from sawon;
set line 200col no for 999
col "dot remove" for a20
select sabun, sahire,regexp_replace(sahire,'\/','') "dot remove" from sawon;
col replace for a20
select sabun, sahire,regexp_replace(sahire,'\/','*',1,1) "replace" from sawon;
select regexp_replace('aaa bbb','( ){2,}','') "one",
regexp_replace('aaa  bbb','( ){2,}','') "two" from dual;
select regexp_replace('aaa bbb','( ){2,}','*') "one",
regexp_replace('aaa  bbb','( ){2,}','*') "two" ,
regexp_replace('aaa   bbb','( ){2,}','*') "three" from dual;
set verify off
select sname, sabun from sawon where sname=regexp_replace('&id','( ){1,}','');
select regexp_replace('20120324', '([[:digit:]]{4})([[:digit:]]{2})([[:digit:]]{2})','\1-\2-\3') from dual;
select regexp_substr('ABC* *DEF $GHI %KJL','[^ ]+[DEF]') from dual;
col url for a20
select sname ltrim(regexp_substr(sname,'/([[:alnum:]]+\.?){3,4}?'),'/') "URL" from sawon where sname is not null;
col email for a20
col name for a20
col domain for a20
select sname ltrim(regexp_substr(sname,'@([[:alnum:]]+\.?){3,4}?'),'@') "URL" from sawon where deptno in(10,20);
col result for a10
select regexp_substr('sys/oracle@racdb:1521:racdb','[^:]+',1,3) result from dual;