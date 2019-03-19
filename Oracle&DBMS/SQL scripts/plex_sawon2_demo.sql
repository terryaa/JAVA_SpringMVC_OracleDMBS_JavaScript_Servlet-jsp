accept bun prompt '사원번호 입력:'
declare
	vsawon sawon%rowtype;

begin
	dbms_output.put_line('tt');
		--select ~ into : into뒤에 기술한 변수에 select 값을 대입
	select * into vsawon
	from sawon where sabun = &bun ;
	--출력
	dbms_output.put_line('실행 결과');
	dbms_output.put_line('사원번호 : '||vsawon.sabun);
	dbms_output.put_line('이름 : '||vsawon.sname);
	dbms_output.put_line('급여 : '||vsawon.sajob);
	dbms_output.put_line('급여 : '||vsawon.sapay);
end;
/