/*
사원테이블에서 입력받은 부서의 평균급여를 계산해주는 PL/SQL만드시오.
단 %type을 사용해서 작성해보기
*/
	
accept deptbun prompt '부서번호'

declare
	vsdeptno sawon.deptno%type;
	vsapay sawon.sapay%type;
	vavgsapay vsapay%type; 
	vdname dept.dname%type;
begin
	select s.deptno,d.dname , avg(sapay) into vsdeptno,vdname,vavgsapay
	 from sawon s, dept d where s.deptno=&deptbun and d.deptno=s.deptno
	 group by s.deptno , d.dname ;
	
	dbms_output.put_line('실행 결과');
	dbms_output.put_line('사원번호 : '||vsdeptno);
	dbms_output.put_line('이름 : '||vdname);
	dbms_output.put_line('급여 : '||vavgsapay);
end;
/

/*
	vsabun sawon.sabun%type;
	vsname sawon.sname%type;
	vsapay sawon.sapay%type;

begin
		--select ~ into : into뒤에 기술한 변수에 select 값을 대입
	select sabun, sname, sapay into vsabun,vsname,vsapay
	from sawon where sabun = &bun ;
	--출력
	dbms_output.put_line('실행 결과');
	dbms_output.put_line('사원번호 : '||vsabun);
	dbms_output.put_line('이름 : '||vsname);
	dbms_output.put_line('급여 : '||vsapay);
end;

*/