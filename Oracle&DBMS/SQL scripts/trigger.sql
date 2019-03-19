create or replace trigger gogek_i
	after insert on gogek
	for each row

begin
	insert into gogek_ex
	values(:new.gobun,:new.goname,:new.gotel,:new.gojumin,:new.godam);
end;
/
