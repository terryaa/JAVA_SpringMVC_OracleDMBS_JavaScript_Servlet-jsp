create or replace trigger gogek_delete
	after delete on gogek
	for each row
begin
	delete from gogek_ex where gobun=:old.gobun;
end;
/
