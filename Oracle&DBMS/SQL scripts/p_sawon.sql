create or replace procedure p_sawon(deptnum IN number, cur OUT SYS_REFCURSOR)
is
begin

	open cur for
	select * from sawon_px
	where deptno=deptnum;
end;
/
