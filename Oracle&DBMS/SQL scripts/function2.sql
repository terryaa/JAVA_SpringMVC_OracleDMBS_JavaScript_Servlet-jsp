
/*
	Function(�Լ�)
	���� : ���� ���Ǵ� ���� �Ǵ� ������ �̸� �����Ͽ� ȣ���ؼ� ���
	->��� ���̺��� ����.
	������ �Ϻη� ȣ��
	--out�̾��� ��� ���ϰ��� ����
*/
create or replace function gender(jumin varchar2)

return varchar2
is
	v_num number(4);
begin
	v_num :=substr(jumin,8,1);

	if v_num=1 or v_num=3 then
		return '����';
	elsif v_num=2 or v_num=4 then
		return '����';
	end if;
end;
/