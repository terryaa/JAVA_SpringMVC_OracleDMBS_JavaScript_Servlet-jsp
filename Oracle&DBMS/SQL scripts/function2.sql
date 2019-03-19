
/*
	Function(함수)
	목적 : 자주 사용되는 계산식 또는 수식을 미리 생성하여 호출해서 사용
	->대상 테이블이 없다.
	문장의 일부로 호출
	--out이없다 대신 리턴값이 존재
*/
create or replace function gender(jumin varchar2)

return varchar2
is
	v_num number(4);
begin
	v_num :=substr(jumin,8,1);

	if v_num=1 or v_num=3 then
		return '남자';
	elsif v_num=2 or v_num=4 then
		return '여자';
	end if;
end;
/