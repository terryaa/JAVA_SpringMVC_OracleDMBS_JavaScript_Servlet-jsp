/*
	Function(�Լ�)
	���� : ���� ���Ǵ� ���� �Ǵ� ������ �̸� �����Ͽ� ȣ���ؼ� ���
	->��� ���̺��� ����.
	������ �Ϻη� ȣ��
	--out�̾��� ��� ���ϰ��� ����
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