/*
if �� ��������
*/

declare
	vage number(5) :=17;
	vname varchar2(20) :='��浿';

begin
	if vage>19 then
		dbms_output.put_line(vname||'���� �����Դϴ�.');
	else
		dbms_output.put_line(vname||'���� �̼����Դϴ�.');
	end if;
end;
/