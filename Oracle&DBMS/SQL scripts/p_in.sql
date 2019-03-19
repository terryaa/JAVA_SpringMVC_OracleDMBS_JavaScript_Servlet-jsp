create or replace procedure ps_in(
sname in sawon_px.sname%type,
dno in sawon_px.deptno%type,
sjob in sawon_px.sajob%type,
spay in sawon_px.sapay%type,
sgender in sawon_px.sgender%type
)
is
begin
	insert into sawon_px
	(sabun, sname, deptno, sajob, sapay, sahire, sgender)
	values(sa_px_seq.nextVal,sname,dno,sjob,spay,sysdate,sgender);
end;
/