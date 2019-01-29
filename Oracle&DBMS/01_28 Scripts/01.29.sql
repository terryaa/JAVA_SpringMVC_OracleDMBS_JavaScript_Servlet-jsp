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
select sname,sahire,add_months(sahire,5) from sawon;

--날짜에 연산되는 round/trunc함수
--기준으로 월에서 반올림
select sname,sahire,round(sahire,'yyyy') from sawon;

--연산함수 ['년-개월']
select sysdate + to_yminterval('01-00') from dual;

--[일 시:분:초']
select sysdate+to_dsinterval('100 00:00:00') from dual;
select trunc(sysdate) - to_date('19'||sahire, 'yyyy/mm/dd') from sawon;
--months_between 날짜와 날짜 사이의 개월수를 구하는 함수
select sahire, trunc(months_between(sysdate,sahire))from sawon;
select sahire, months_between(sysdate,sahire)from sawon;

--레포트 작성한 후 제출할것
--연산 설명 trunc(mont~~~ :주석포함
--연습문지1)사원테이블에서 사원의 근무일수, 개월 , 근무년 월일
--      감수정 10/05/11 | 3081 _ 8년 5개월 5일
--연습문제2) 입사한 달의 근무일수를 계산하여 부서번호,이름,근무일수를 출력하시오
--연습문제3)모든 사원의 60일 지난 후의 월요일은 몇년,몇월,몇일 인가를 구한후
--이름 입사일 월요일 로 ㅊㄹ력하시요.

select sname 사원명, sahire 고용일, trunc(sysdate-sahire) 근무일수,
trunc(months_between(sysdate,sahire)) 근무개월   from sawon;

select round(months_between(sysdate,sahire))/12 ||'년'|| from sawon;
select trunc(months_between('2019/04/21','2015/01/22')/12)  from dual;
select trunc(mod(months_between('2019/04/21','2015/01/19'),12))  from dual;

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
select sum(sapay)/24,avg(sapay), count(*),max(sapay),min(sapay) from sawon;
--nvl:컬럼하나 단독적용 함수
-- avg:count 영향 널포함 꼭 넣어야함
-- count(sapay): 널을 포함하지 않음 => count(nvl(sapay,0))
select * from sawon;