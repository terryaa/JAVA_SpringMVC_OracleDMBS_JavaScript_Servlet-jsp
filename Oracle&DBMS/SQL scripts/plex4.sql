accept no prompt '�ݺ� Ƚ�� �Է�:'
declare

begin

	for i in 0 .. &no loop
		if(   mod(i,2) = 0  ) then
			dbms_output.put_line('i�� ¦��'||i);
		else 
			dbms_output.put_line('i�� Ȧ��'||i);
		end if;
	end loop;
end;
/