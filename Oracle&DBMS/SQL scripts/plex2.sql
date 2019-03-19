/*
if 문 교재참조
*/

declare
	vage number(5) :=17;
	vname varchar2(20) :='김길동';

begin
	if vage>19 then
		dbms_output.put_line(vname||'님은 성년입니다.');
	else
		dbms_output.put_line(vname||'님은 미성년입니다.');
	end if;
end;
/