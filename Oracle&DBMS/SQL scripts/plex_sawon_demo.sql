accept bun promt '사원번호 입력:'
declare
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
/