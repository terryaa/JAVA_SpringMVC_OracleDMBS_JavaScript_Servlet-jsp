/*
��� ��ȣ�� �Է¹޾Ƽ� �� ������ Ŀ�̼��� �����ϴ� ���α׷�
��, �޿��� 1000�̸�->�޿��� 10%
1000~2000 --> �޿��� 15%
2000�ʰ� --> �޿��� 20%
null->0
*/

accept no prompt '��� ��ȣ:'

declare
	vsabun sawon_new.sabun%type;
	vsname sawon_new.sname%type;
	vcomm sawon_new.comm%type;
	vsapay sawon_new.sapay%type;
	
begin

	select sabun, sname, sapay, comm 
	into vsabun, vsname, vsapay, vcomm
	from sawon_new 
	where sabun=&no;

	if (vsapay < 1000) then
		vcomm := vsapay*0.10;
	elsif (vsapay>=1000 and vsapay<=2000) then
		vcomm := vsapay*0.15;
	elsif (vsapay>2000) then
		vcomm := vsapay*0.20;
	elsif vsapay is null then
		vcomm := 0;
	end if;

	update sawon_new set comm =vcomm where sabun=&no;
	commit;
	dbms_output.put_line('���� ���');
	dbms_output.put_line('�����ȣ : '||vsabun);
	dbms_output.put_line('�̸� : '||vsname);
	dbms_output.put_line('�޿� : '||vsapay);
	dbms_output.put_line('Ŀ�̼� : '||vcomm);

end;
/