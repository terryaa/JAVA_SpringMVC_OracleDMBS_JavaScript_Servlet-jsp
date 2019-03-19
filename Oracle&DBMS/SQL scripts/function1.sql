/*
	Function(함수)
	목적 : 자주 사용되는 계산식 또는 수식을 미리 생성하여 호출해서 사용
	->대상 테이블이 없다.
	문장의 일부로 호출
	--out이없다 대신 리턴값이 존재
*/

create or replace function f_name(name varchar2)
return varchar2
is
	v_name varchar2(20);
begin
	v_name :=substr(name,2,2);
	return v_name;
end;
/