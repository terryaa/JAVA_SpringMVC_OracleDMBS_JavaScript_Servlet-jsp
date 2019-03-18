--날짜연산
/*
날짜 +,- 숫자 : 날짜로부터 그 기간만큼 지난 날짜를 계싼
날짜 - 날짜: 두 날짜사이에 기간을 계산
*/

select sysdate - 1 yesterday,sysdate,sysdate +1 tomorrow from dual;

/*
변환함수
to_char날짜|숫자,'형식): 날짜 또는 숫자를 짖어한 형식의 문자열로 반환
to_date(날짜형식의문자열,'형식') : 날짜형식의 문자열을 지정한 형식의 날짜로 변환
*/
select regexp_replace(sysdate,'/','') from dual;

select to_number('100') + 100 from dual;
select to_date('1992','yyyy') from dual;
select to_char(sysdate,'yyyy') to_char(sysdate,'CC'),
to_char(sysdate,'RRRR')from dual;
select to_char(sysdate,'YEAR')from dual; -- 영문표기
select to_char(sysdate,'yy') from dual; --연도 2자리
select to_char(sysdate,'month'),to_char(sysdate,'mon') from dual; 
select to_char(sysdate,'q') from dual; --분기
select to_char(sysdate,'d') from dual; --요일(1~7 :1->일요일)
select to_char(sysdate,'dy')from dual; --
select to_char(sysdate,'day','NLS_DATE_LANGUAGE=ENGLISH') from dual;
select to_char(sysdate,'day') from dual;
select to_char(sysdate,'dd')from dual;
select to_char(sysdate,'ddd') from dual;
select to_char(sysdate,'hh') from dual;
select to_char(sysdate,'mi') from dual;
select to_char(sysdate,'ss') from dual;
--2019년 01월29일로 출력해보기
select sysdate,to_char(sysdate,'yyyy"년" mm"월" dd"일" day') from dual; 
-- 숫자 관련 형식(9-값이 없다면 출력을 안함, 0-값이 없어도 출력
select sname, to_char(sapay,'fm$9,990') from sawon;

--next,last
--오늘을 기준으로 가장 가까운 다음 화요일은 언제인지를 반환함
select next_day(sysdate,to_char(sysdate,'dy')) from dual;
--지정한 년/월의 마지막 날짜(이달의 마지막 날짜는)
select last_day(sysdate) from dual;
--add_months : 특정 개월수를 더한 날짜를 구해주는 함수
select sname,sahire,add_months(sahire,480) from sawon;

--날짜에 연산되는 round/trunc함수
--기준으로 월에서 반올림, trunc는 소수점 이하를 버림.
select saname,sahire,round(sahire,'yyyy') from sawon;

--연산함수 ['년-개월']
select sysdate - to_yminterval('10-01') from dual;
select sahire + to_yminterval( trunc( months_between(sysdate,sahire)/12) ||'-'||
 
select to_date('2019/04/21','yyyy/mm/dd') -( to_date('2015/07/23','yyyy/mm/dd') + ( to_yminterval ( trunc(months_between
('2019/04/21','2015/07/23')/12) ||'-'|| trunc(mod(months_between('2019/04/21','2015/07/23'),12)) ) ) ) from dual;

select  sysdate - (sahire + ( to_yminterval ( trunc(months_between
(sysdate,sahire)/12) ||'-'|| trunc(mod(months_between(sysdate,sahire),12)) ) )  )from sawon;

--[일 시:분:초']
select sysdate+to_dsinterval('100 00:00:00') from dual;
--months_between 날짜와 날짜 사이의 개월수를 구하는 함수
select sahire, trunc(months_between(sysdate,sahire))from sawon;
select sahire, months_between(sysdate,sahire)from sawon;
select  trunc(months_between(sysdate,sahire)) from sawon;

--레포트 작성한 후 제출할것
--연산 설명 trunc(mont~~~ :주석포함
--연습문지1)사원테이블에서 사원의 근무일수, 개월 , 근무년 월일
--      감수정 10/05/11 | 3081 _ 8년 5개월 5일
--연습문제2) 입사한 달의 근무일수를 계산하여 부서번호,이름,근무일수를 출력하시오
--연습문제3)모든 사원의 60일 지난 후의 월요일은 몇년,몇월,몇일 인가를 구한후
--이름 입사일 월요일 로 ㅊㄹ력하시요.
select to_date('2019/01/19','yyyy/mm/dd')+60 from dual;
--연습문제 1)
select sname 사원명, sahire 고용일, trunc(sysdate-sahire) 근무일수,
trunc(months_between(sysdate,sahire)) 근무개월,
trunc(months_between(sysdate,sahire)/12)||'년'|| trunc(mod(months_between(sysdate,sahire),12)) ||'월'||
 (trunc(sysdate)
        - add_months(sahire, trunc(months_between(sysdate,sahire))
        )) ||'일'  근무년월일
from sawon;

select sname 사원명, sahire 고용일, trunc(sysdate-sahire) 근무일수,
trunc(months_between(sysdate,sahire)) 근무개월,
trunc(months_between(sysdate,sahire)/12)||'년'|| trunc(mod(months_between(sysdate,sahire),12)) ||'월'||
 (trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        )) ||'일'  근무년월일 from sawon;

--연습문제2)
select deptno,sname,sahire 입사일, last_day(sahire)-sahire 입사한달의근무일수 from sawon;
--연습문제3)
select next_day(to_date('2019/01/19','yyyy/mm/dd')+60,'월') from dual;
--

/*
석차함수
형식 : rank() over([partition by 컬럼명] order by 컬럼명 [desc]) "석차"
over : 순위를 부여하기위한 대상 집합의 정렬 기준과 분할 기준 정의
partition by: 컬럼명을 기준으로 분할, 생략시에는 전체 집합을 대상으로 순위부여
order by 컬럼명: 컬럼을 기준으로 정렬
*/
---------------------------------------------------------
/*
Rank함수는 1등이 2건인경우에는 당므 순우를 3등으로 부여한다.
-정렬결과를 기준으로 전체 순위를 출력하기위해 사용
Dense_rank함수는다음 순위를 2등으로 부여한다.
0동일 순위를 무시한 연속 순위를 출력하기위해 사용된다.
*/

select gobun,godam,goname, rank() over(order by godam desc)
from gogek where godam is not null;
select gobun,godam,goname, dense_rank() over(order by godam desc)
from gogek where godam is not null;

--문제)부서별로 급여가 높은 순으로 석차를 출력하시오.(단 널 값은 제외)
-- 부서 번호 , 사원이름, 급여, 석차
select deptno 부서번호, sname 사원이름 , sapay 급여, 
rank() over(partition by deptno order by sapay desc) from sawon where sapay is not null;

--계산함수, 집계함수, 그룹함수
--sum,avg,count,max,min함수
--그룹함수와 일반 집계컬럼 함께 사용하기 위해서 group b 일반집계컬럼,..--정렬작업
select sum(sapay)/24,avg(nvl(sapay,0)), count(*),max(sapay),min(sapay) from sawon;
--nvl:컬럼하나 단독적용 함수
-- avg:count 영향 널포함 꼭 넣어야함
-- count(sapay): 널을 포함하지 않음 => count(nvl(sapay,0)) 널 포함
select count(sapay) from sawon;
select * from sawon;

--부서별 급여 합계를 출력
--단 10,20번 부서만출력
--단 급여합계가 15000이상인 그룹만 출력
select deptno, sum(sapay) from sawon
where deptno=10 or deptno=30  --where절에는 grounp함수를 사용 할 수 없다
group by deptno
--정렬됨 -- group by ***; ***에있는 값을 미리.... 그룹화
--일반 컬럼을 계산함수랑 같이쓸떄는 반환수가 틀려서 그룹화를 시켜줘야한다.
having sum(sapay) >=15000; --group by에 대한 조건절

---------------------
/*
select : 추출할컬럼...
from : 어디에서(테이블,뷰)
where : 조건절,계산함수 사용불가능(from 다음 가장 먼저 분석하기때문)
group by: 그룹으로 합침.
having :groupby를써야하는 계산함수 사용가능
order by :정렬
*/
select num,name,pnum from memphone where pnum like '%032%';
--문제) 성별, 직책별 인원수와 급여합께를 출력
--단)여자만 그룹화하고 인원이 2명이하인 사원만 출력
--인원수가 많은 순으로 정렬하시오
select sgender , sajob,rank() over(order by (count(nvl(sajob,0))) desc), 
count(nvl(sajob,0)),sum(sapay) from sawon where sgender='여자' group by sgender,sajob having count(nvl(sajob,0))<=2; 

--인원수가 많은 순으로 정렬하시오
select sgender, sajob, count(nvl(sajob,0)),sum(sapay)
from sawon
where sgender='여자' group by sgender, sajob
having count (nvl(sajob,0))<=2
order by sajob;

select deptno,max(sapay) from sawon group by deptno order by 2 desc;

--rownum:가상 컬럼,임시로 컬럼에 부여되는 일련번호
--where 절에서 행의 갯수를 제한할때 사용, 공지사항(다섯개의 최신 데이터만..)
--급여가 많은 세명의 사원을 출력, 번호 함께 출력
select rownum,saname,sapay
from sawon  --1번째 실행
where rownum<4   --2번째 실행
order by sapay desc, saname;  --3번째 실행. 이미 rownum이 생성되어있기 떄문에 의미없다.
--From -> where -> select -> order by 
--from 절이 가장 먼저 실행되고 sawon테이블에 rownum가 부여된다.
--그 이후에 where절이 실행되기 때문에 정렬이 이루어지기 전에 rownum<=3인 row가 선택된다. 
--이럴떄 inline view가 필요하다. 
--view가 rownum이 붙어서 정렬되버리기 전에 실행해야하기때문에, 실행되기 전의 테이블을 복제하듯이만들어야한다.
select rownum,sname,sapay from
(select rownum,sname,sapay from sawon order by sapay desc,sname )
where rownum <=3;
--from절 뒤에 subquery를 지정하면 view가된다. 
--subquery는 ()안에적히며, 먼저실행된다. 

select sum(decode (sajob,'사원',sapay,0)) "사원",
sum(decode(sajob,'대리',sapay,0))"대리",
sum(decode(sajob,'부장',sapay,0))"부장",
sum(decode(sajob,'회장',sapay,0))"회장",
sum(sapay) "합계" from sawon;
--성별 합계 구하기 
--남자 | 여자 | 합계
select sum(decode (sgender,'남자',sapay,0)) "남자",
sum(decode(sgender,'여자',sapay,0))"여자",
count(*) "합계" from sawon;

--조인
--사용하는 컬럼이 두개 이상의 테이블에 존재하는 경우 사용되는 고급 쿼리 명령
--32개까지가능
--종류
--1. eque(inner) join:조인되는 테이블 간의 조건에 만족하는 행만을 추출
--2. outer join(left&right) : 조인되는 테이블간의 조건에 만족하는 행과
--미스터 테이블의 모든 데이터가 추출
--3. cross join:조인되는 테이블간의 어떤 관계도 없는 경구(table*table)->카티션 프로덕트
------
--4. self join:자기자신의 테이블과 조인되는 경우
--문법
1.T-SQL 문법:where 조건절, 테이블명을 나열하여 표현
-select~: 원하는 컬럼 나열
-from~ : 사용한 컬럼을 가진 테이블 나열
-where~ : 사용된 테이블간의 관계 또는 조건을 포현
2.Ansi 문법:on 조건절, 서술형태의 표현
--조인되는 테이블간의 관계 컬럼명이 같은경우 -ansi
select saname,deptno,dname from sawon natural join dept;
select saname,deptno,dname from sawon join dept using(deptno);
--컬럼명이 같아야 되는것을 증명 , 달라서 partition이만들어져서 모든데이터가 합쳐진게아니라 순차적으로나옴 더해진게
select goname,godam,saname from sawon natural join gogek;
select goname,godam,saname from sawon join gogek using(godam);
--사원명,부서번호,부서명을 출력
select s.saname,s.deptno,d.dname from sawon s, dept d
where s.deptno=d.deptno;

select sname,godam,sname from sawon s, gogek g
where g.godam=s.sabun(+); 
--outer inner 조인.
--inner은 join하는 atrribute가 둘다 null이아니여야한다.
--outer는 left는 우항 null이허용, right은 좌항의 null이 허용 되는 join이다. 

select s.saname,s.deptno,d.dname from sawon s join dept d on (s.deptno=d.deptno);--ansi
--고객명,전화번호,담당자명을 출력(단,담당자가 없는 고객도 출력)
select g.goname,g.gotel,s.saname from gogek g, sawon s where g.godam=s.sabun(+);
select g.goname,g.gotel,s.sname from gogek g left outer join sawon s on (g.godam=s.sabun);
--사원명,직책,담당자명,직책을출력
select s.sname, s.sajob,m.sname,m.sajob from sawon s, sawon m where s.samgr=m.sabun(+);


--고객명,담당자명,직책,부서명을 출력(담당자가 없는 고객도 출력)
select g.goname,g.godam,s.sajob,d.dname  from gogek g, dept d, sawon s
where g.godam=s.sabun(+) and s.deptno=d.deptno(+);
--부서명,사원명,직책,담당자명,직책을 출력(단,담당자가 없는 사원도 출력)
select d.dname, s.sname,s.sajob,m.sname,m.sajob from sawon s, sawon m, dept d
where d.deptno(+)=s.deptno and s.samgr=m.sabun(+);
--부서(명)별 급여 합계를 출력
select d.dname, sum(s.sapay) from sawon s, dept d
where d.deptno=s.deptno group by d.dname;


--문제1)
select trunc( to_char(sysdate,'yyyy')/100 +1) 세기 , 
trunc( to_char(sysdate,'yyyy')) 연도,
to_char(sysdate,'dy') 요일 from dual;
--문제2)
select sysdate 오늘날짜,to_char(sysdate,'yyyy"년" mm"월" dd"일" day')||'이며 '||
to_char(sysdate,'q')||'분기, 앞으로 1년중에 '
|| trunc(  to_date(to_char(sysdate,'yyyy')+1||'01/01','yyyy/mm/dd')-sysdate) ||'일 남았으며, '||
(365- trunc(  to_date(to_char(sysdate,'yyyy')+1||'01/01','yyyy/mm/dd')-sysdate) ) ||'일 지났습니다'
 출력물 from dual; 

--문제3)
--1번방법
select sname 사원명, sahire 고용일, trunc(sysdate-sahire) 근무일수,
trunc(months_between(sysdate,sahire)) 근무개월,
trunc(months_between(sysdate,sahire)/12)||'년'|| trunc(mod(months_between(sysdate,sahire),12)) ||'월'||
 (trunc(sysdate)
        - add_months(sahire, trunc(months_between(sysdate,sahire))
        )) ||'일'  근무년월일
from sawon;
--2번방법
select sname 사원명, sahire 고용일, trunc(sysdate-sahire) 근무일수,
trunc(months_between(sysdate,sahire)) 근무개월,
trunc(months_between(sysdate,sahire)/12)||'년'|| trunc(mod(months_between(sysdate,sahire),12)) ||'월'||
 (trunc(sysdate)
        - add_months(sahire,trunc(months_between(sysdate,sahire))
        )) ||'일'  근무년월일 from sawon;

(trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        ))
        
--문제4)
select deptno,sname,sahire 입사일, last_day(sahire)-sahire 입사한달의근무일수 from sawon;
--문제5)
select sname 사원이름, sahire 고용일,  to_char(next_day(sahire+60,'월'),'yyyy"년" mm"월" dd"일"') "60일후 첫 월요일" from sawon;
--문제6)
select deptno 부서, sname 사원, sahire 고용일, sysdate 오늘 ,  trunc(sysdate-sahire) 근무일수, 
trunc(months_between(sysdate,sahire)/12)||'년'|| trunc(mod(months_between(sysdate,sahire),12)) ||'월'||
 (trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        )) ||'일'  근무년월일 from sawon;

--문제7)
select to_char(sahire,'yy') 고용년도, sum(sapay) 연봉합, max(sapay) 최고연봉  from sawon group by sahire ;
--문제8)
select sajob 직책, count(sajob) 명수 from sawon group by sajob having count(sajob)>=3;
--문제9)
select deptno 부서, round(avg(sapay),1) 평균월급,max(sapay) 최고월급 ,min(sapay) 최저월급
from sawon  group by deptno order by avg(sapay) desc;
--문제10)
select d.deptno 부서번호,d.dname 부서명,
count(case when to_char(sahire,'yyyy')=1980  then 1 end) "1980입사" ,
count(case when to_char(sahire,'yyyy')=1981  then 1 end) "1981입사" ,
count(case when to_char(sahire,'yyyy')=1982  then 1 end) "1982입사" ,
count(case when to_char(sahire,'yyyy')=1983  then 1 end) "1983입사" 
from sawon s , dept d where s.deptno=d.deptno group by d.deptno,d.dname
having 
count(case when to_char(sahire,'yyyy')=1980  then 1 end) +
count(case when to_char(sahire,'yyyy')=1981  then 1 end) +
count(case when to_char(sahire,'yyyy')=1982  then 1 end) +
count(case when to_char(sahire,'yyyy')=1983  then 1 end) !=0  order by 1 desc;


--● 변환함수
● to_char(“날짜 or 숫자”, ‘형식)  : 날짜 또는 숫자를 지정한 형식의 문자열로 반환
● to_date(날짜형식의 문자열,‘형식’): 날짜형식의 문자열을 지정한 형식의 날짜로변환
● select to_char(sysdate,'YEAR')from dual; -- 영문표기 //  TWENTY NINETEEN
● select to_date('1992','yyyy') from =dual;  // 92/03/01
