accept bun prompt '�����ȣ �Է�:'
declare
	vsawon sawon%rowtype;

begin
	dbms_output.put_line('tt');
		--select ~ into : into�ڿ� ����� ������ select ���� ����
	select * into vsawon
	from sawon where sabun = &bun ;
	--���
	dbms_output.put_line('���� ���');
	dbms_output.put_line('�����ȣ : '||vsawon.sabun);
	dbms_output.put_line('�̸� : '||vsawon.sname);
	dbms_output.put_line('�޿� : '||vsawon.sajob);
	dbms_output.put_line('�޿� : '||vsawon.sapay);
end;
/