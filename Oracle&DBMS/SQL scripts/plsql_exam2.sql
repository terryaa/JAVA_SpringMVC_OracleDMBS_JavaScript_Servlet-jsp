/*
사원 번호를 입력받아서 그 사우너의 커미션을 변경하는 프로그램
단, 급여가 1000미만->급여의 10%
1000~2000 --> 급여의 15%
2000초과 --> 급여의 20%
null->0
*/

accept no prompt '사원 번호:'

declare
	vsabun sawon_new.sabun%type;
	vsname sawon_new.sname%type;
	vcomm sawon_new.comm%type;
	vsapay sawon_new.sapay%type;
	
begin

	select sabun, sname, sapay, comm 
	into vsabun, vsname, vsapay, vcomm
	from sawon_new 
	where sabun=&no;

	if (vsapay < 1000) then
		vcomm := vsapay*0.10;
	elsif (vsapay>=1000 and vsapay<=2000) then
		vcomm := vsapay*0.15;
	elsif (vsapay>2000) then
		vcomm := vsapay*0.20;
	elsif vsapay is null then
		vcomm := 0;
	end if;

	update sawon_new set comm =vcomm where sabun=&no;
	commit;
	dbms_output.put_line('실행 결과');
	dbms_output.put_line('사원번호 : '||vsabun);
	dbms_output.put_line('이름 : '||vsname);
	dbms_output.put_line('급여 : '||vsapay);
	dbms_output.put_line('커미션 : '||vcomm);

end;
/