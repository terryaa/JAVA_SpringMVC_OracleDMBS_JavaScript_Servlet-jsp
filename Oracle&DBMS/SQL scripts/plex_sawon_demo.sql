accept bun promt '�����ȣ �Է�:'
declare
	vsabun sawon.sabun%type;
	vsname sawon.sname%type;
	vsapay sawon.sapay%type;

begin
		--select ~ into : into�ڿ� ����� ������ select ���� ����
	select sabun, sname, sapay into vsabun,vsname,vsapay
	from sawon where sabun = &bun ;
	--���
	dbms_output.put_line('���� ���');
	dbms_output.put_line('�����ȣ : '||vsabun);
	dbms_output.put_line('�̸� : '||vsname);
	dbms_output.put_line('�޿� : '||vsapay);
end;
/