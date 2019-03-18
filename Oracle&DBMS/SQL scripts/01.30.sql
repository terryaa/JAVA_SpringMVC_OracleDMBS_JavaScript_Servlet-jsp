단일행 서브쿼리: 하나의 행만 검색해서 메인쿼리에 보내는것을말한다.
=,<>,<,<=,>,>=

select dname from dept where deptno=(select deptno from sawon where sname='류별나');

--as만 붙이면 테이블이 복제가된다.  where값에 dummy값(0 ,1등)을 들어오면 schema만 추출하고 데이터는 추출되지않는
--복사가 이루어진다.
create table sawon_test as select * from sawon;
select deptno, sname from sawon_test
update sawon_test set sname='류별나' where sabun=24;
commit;
select deptno, sname from sawon_test where sname = '류별나';
select dname from dept where deptno=(select deptno from sawon_test where sname='류별나');
commit;
select deptno,sname from sawon_test where sname='류별나';
--단일행 서브쿼리와 다중행 서브쿼리에 대한 이해
select dname from dept where deptno where=(select deptno from sawon_test where sname='류별나'); --단일행 조건(=)에 1개초과의 데이터가조회되어 에러
select dname from dept where deptno in(select deptno from sawon_test where sname='류별나'); --in을 통하여 다중행 서브쿼리로변경
--10번부서에 근무하는 사원의 이름과 10분 부서의 부서명을 조인으로 출력
--group by를 넣으면 무궁화가 10이 1개출력, 안넣으면 2개출력된다. 중복처리가 되고안되고임. 
select d.deptno,d.dname,s.saname from sawon s, dept d where s.deptno=d.deptno and d.deptno=10; group by d.deptno,d.dname,s.sname;
select * from sawon s, dept d where d.deptno=10 and s.deptno=10;
--인라인 뷰로 바꾸기
--위의 join은 테이블의 모든 튜플에 대하여 join을 한 뒤에 deptno=10을 찾는다.
--인라인뷰는 먼저 10 총무부 를 만든다음에 sawon과 비교를 하기때문에 전체비교+전체비교 보다는 인라인뷰가 더 속도가 빠르다.
select s.saname, s.deptno from sawon s, (select deptno from dept where deptno=10) d 
where s.deptno=d.deptno;
--사원들의 평균 급여보다 더 많은 급여를 받는 사원을 검색해보자. 
select  sname , sapay from sawon where sapay > (select avg(nvl(sapay,0)) from sawon) ;
--부서 번호가 20인 사원중에 최대급여를 받는 사원보다 급여를 많이 받는 사원검색
--단일,다중인지 먼저확인
select sname, sapay from sawon where sapay>(select max(sapay) from sawon where deptno=20) ;

문제1) 김길동이 속해있는 부서의 모든 사원의 사번,이름,입사일,급여를 출력하시오.
select sabun, sname, sahire, sapay from sawon where deptno in(select deptno from sawon where sname='김길동');
문제2) 부서위치가 가산인 모든 사원의 이름, 부서번호를 출력하시오.
select sname,deptno from sawon where deptno in(select deptno from dept where loc='가산');
--subquery는 inlineview,join보다 성능이좋다. 
--inlineview는 join을 쓰기때문에.
select s.sname,d.deptno from sawon s, (select deptno from dept where loc='가산') d where s.deptno=d.deptno;

2. 다중행 서브쿼리
-서브쿼리에서 반환되는 결과가 하나이상의 행일떄 사용
-반드시 다중 행 연산자 (Multiple Row Operator)과 함께 사용.
<다중행 연산자
IN: 메인쿼리의 비교조건이 서브쿼리의 결과 중에서 하나라도 일치하면 참.
select sabun,sname,sahire,sapay from sawon where dpetnoin(select deptno from sawon where sname like '%김%');
ANY, SOME : 메인쿼리의 비교조건이 서브쿼리의 검색 결과와 하나 이상이 일치하면 참
ALL: 메인쿼리의 비교조건이 서브 쿼리의 검색결과와 모든값이 일치하면 참
Exist:메인쿼리의 비교조건이 서브쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면참. 

--강감찬과 같은 부서에있는 사람들의 이름과 고용일자를 출력해보자.
--saname의 값이 중복이 될 경우 단일행 서브쿼릴로는 에러가 발생한다.!**
select sname,sahire,deptno from sawon where deptno in(select deptno from sawon where sname='강감찬');

select sname,sahire,deptno from sawon where deptno in(select deptno from sawon where sname='강감찬')
and sname!='강감찬';

--급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보를 출력
--distinct 중복된 컬럼의 값을 제거
select distinct deptno from sawon where sapay>=3000;
select deptno from sawon where sapay>=3000;
select saname, deptno from sawon where deptno in(select distinct deptno from sawon where sapay>=3000);
--distinct : 를 사용하나 마나 같은 결과가 나오지만
--어떤점이 다를것인가?

--ALL 연산자: 메인 조건의 비교 조건이 서브쿼리에서 검색한 결과값과 모두 일치하면 참이된다.
찾아진값에대해서 aand연산을 해서 모두 참이면 참이 되는 샘이다.
< ALL : 최소값을 반환
> ALL : 최대값 반환
where sapay > ALL(select sapay from sawon where deptno=30);
--부서번호가 30qjs사원들 중에서 급여를 가장 많이 받은 사원 보다 더 많은 급여를 받는 사람의 이름,급여를 출력하는 예제이다.
4003보다 높은 사원들만 출력될것이다.
select max(sapay) from sawon where deptno=30;
select sname, sapay from sawon
where sapay > ALL(select sapay from sawon where deptno=30);

ANY,SOME 연산자
메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상이 일치하면 참이된다.
>ANY 하면 비교값 중 하나보다 크냐: 하고 묻는 것이 된다.
즉, 그 값들 중 어느하나 보다 더 크ㅕㄴ, 그 값들 중 최소값보다 더 크면 참이된다.
<ANY 최대값
--부서번호가 30번 사우너들의 급여중 가장 작은 값돕다 많은 급여를 받은 사우너의 이름과 급여를 출력
select min(sapay from sawon where deptno=30;
select saname,sapay from sawon where sapay < ANY(select sapay from sawon where deptno=30);

--부서번호가 10인 사원이 존재하면 모든 부서의 이름을 출력!
select dname from dept where exists (select sabun from sawon where deptno=10);

--서브쿼리를 이용한 데이터 수정하기 ****
create table dept01 as select * from dept where 1=0;
select * from dept01;
desc dept01;
create table dept02 as select * from dept;
select deptno,dname,loc from dept02;
--20번 부서의 지역명을 50번 부서의 지역명으로 변경하려면?
update dept02 set loc='가산' where deptno=20;
rollback;
update dept02 set (dname,loc)=(select dname,loc from dept02 where deptno=50) where deptno=20;

--사원테이블을 sawon01로 복제한다.
--서브쿼리를 사용해서 데이터를 삭제한다. (delete from sawon01 where sabun=1)
--1번의 사원데이터를 삭제
--실습)사원테이블에서 부서명이 '전산부'인 모든 사원을 삭제하시요.

create table sawon01 as select * from sawon;
delete from sawon01 where deptno=(select deptno from dept where dname='전산부');
select * from sawon01;

-View
물리적인 테이블을 근거한 논리적인 가상 테이블
테이블에는 데이터가 존재하지만 뷰에는 데이터가 존재하지 않으면서 SQL만 저장되어있음
목적)
1.복잡하고 긴 쿼리문을 뷰로 정의하면 항상 간편하게 사용할 수 있다.
2.보안에 유리하다(쿼리문장을 저장한다), 뷰 삭제시 기본테이블의 구조와 데이터에는 영향을주지않는다.
단순뷰와 복합뷰:하나의 테이블이나 여러개의 테이블이나, 그룹함수 불가능,그룹함수 사용, DML 사용이 가능 불가능이냐로나뉨
create or replae view : 같은 이름의 뷰가 있어도 덮어씨움
force: 기본테입르의 존재여부와 상관없이 view생성
with check option : 주어진 제약 조건에 맞는 데이터만 입력 및 수정을 허용
with read only : 검색전용뷰;

create table dept_cp as select * from dept;
create table sawon_cp as select * from sawon;
--단순 뷰
create force view sawon_view1 as select * from sawon_cp;
select * from tab;
select * from sawon_view1;
select view_name,text from user_views;
drop view sawon_view1;

create force view dept_view1 as select deptno,dname,loc||'입니다' from dept_cp;
create force view dept_view1 as select * from dept_cp;
insert into dept_view1 values(60,'진흥부','서울'); 
select * from dept_view1; select * from dept_cp;
drop view dept_view1;
--단순 뷰에서 DML 명령어 사용이 불가능한 경우
--뷰 정의때 포함되지 않은 기본 테이블의 컬럼이 not null조건으로 포함되어 있을경우
--insert문이 불가, 가상 컬럼일 경우, distinct 포함한 경우, 그룹한수 group by절을 포함한 경우.

--복합 뷰
create view sawon_dept_view as
select s.sname, s.deptno, d.dname from sawon s, dept d where s.deptno=d.deptno;
with check option : 조건에사용되어진칼럼값은 뷰를 통한 데이터 수정불가;
create or replace view with_chk_op_view as select sname,sapay,deptno from sawon_cp
where deptno=30 with check option; 
select * from with_chk_op_view;
update with_chk_op_view set deptno=20 where sapay=500;
--검증 아래에 with check option이 적용안된 것은 수정이 됨
update with_chk_op_view set sapay=500 where deptno=30; 

with read only:읽기 전용 뷰;

create or replace view with_read_only_view as select sname,sapay,deptno from sawon_cp
where deptno=30 with read only;
update with_read_only_view set deptno=20 where sapay=400;
select * from with_read_only_view;
rollback;

동의어(Synonym)
1. 데이터베이스의 투명성을 제공하기 위해서 사용
Synonym은 다른 유저의 객체를 참조할때 많이 사용
2. 객체의 긴 이름을 사용하기 편한 짧은 이름으로 해서 SQL코딩을 단순화
3. 객체를 참조하는 사용자의 오브젝트를 감출 수 있기 때문에 이에 대한 보안을 유지.
Synonym종류
1. private synonym
-전용 synonym은 특정 사용자만 이용
2. public synonym
-공용 synonym은 공용 사용자 그룹이 소유하며 그 database에 있는 모든 사용자가 사용.
동의어 생성: create synonym tablename for 소유자.tablename
삭제: drop synonym tablename ;
보안을위해서도 사용자이름.객체   로 접근하는게아니라 공용어로 만들어서 공용어만접근하게하여
보안을 강화.;
commit;

select * from sawon;

select sname 사원 , sajob 직책 from sawon where samgr=(select sabun from sawon where sname='한국남');

select d.deptno 부서번호, sname 이름, sajob 직책, dname 부서명, loc 지역, sapay 급여
from sawon s, dept d
where sajob not in(select sajob from sawon where deptno=30) and d.deptno=10
order by sapay desc;

select sajob from sawon where deptno=30;

select avg(sapay) from sawon where deptno=10;
select s.deptno, dname, avg(sapay) ,dname
	 from sawon s, dept d where s.deptno=&deptbun group by s.deptno,d.dname;