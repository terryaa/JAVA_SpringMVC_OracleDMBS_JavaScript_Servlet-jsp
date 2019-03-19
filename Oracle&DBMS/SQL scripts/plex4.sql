accept no prompt '¹Ýº¹ È½¼ö ÀÔ·Â:'
declare

begin

	for i in 0 .. &no loop
		if(   mod(i,2) = 0  ) then
			dbms_output.put_line('i°ª Â¦¼ö'||i);
		else 
			dbms_output.put_line('i°ª È¦¼ö'||i);
		end if;
	end loop;
end;
/