/*
������̺��� �Է¹��� �μ��� ��ձ޿��� ������ִ� PL/SQL����ÿ�.
�� %type�� ����ؼ� �ۼ��غ���
*/
	
accept deptbun prompt '�μ���ȣ'

declare
	vsdeptno sawon.deptno%type;
	vsapay sawon.sapay%type;
	vavgsapay vsapay%type; 
	vdname dept.dname%type;
begin
	select s.deptno,d.dname , avg(sapay) into vsdeptno,vdname,vavgsapay
	 from sawon s, dept d where s.deptno=&deptbun and d.deptno=s.deptno
	 group by s.deptno , d.dname ;
	
	dbms_output.put_line('���� ���');
	dbms_output.put_line('�����ȣ : '||vsdeptno);
	dbms_output.put_line('�̸� : '||vdname);
	dbms_output.put_line('�޿� : '||vavgsapay);
end;
/

/*
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

*/