������ ��������: �ϳ��� �ุ �˻��ؼ� ���������� �����°������Ѵ�.
=,<>,<,<=,>,>=

select dname from dept where deptno=(select deptno from sawon where sname='������');

--as�� ���̸� ���̺��� �������ȴ�.  where���� dummy��(0 ,1��)�� ������ schema�� �����ϰ� �����ʹ� ��������ʴ�
--���簡 �̷������.
create table sawon_test as select * from sawon;
select deptno, sname from sawon_test;
update sawon_test set sname='������' where sabun=24;
commit;
select deptno, sname from sawon_test where sname = '������';
select dname from dept where deptno=(select deptno from sawon_test where sname='������');
commit;
select deptno,sname from sawon_test where sname='������';
--������ ���������� ������ ���������� ���� ����
select dname from dept where deptno where=(select deptno from sawon_test where sname='������'); --������ ����(=)�� 1���ʰ��� �����Ͱ���ȸ�Ǿ� ����
select dname from dept where deptno in(select deptno from sawon_test where sname='������'); --in�� ���Ͽ� ������ ���������κ���
--10���μ��� �ٹ��ϴ� ����� �̸��� 10�� �μ��� �μ����� �������� ���
--group by�� ������ ����ȭ�� 10�� 1�����, �ȳ����� 2����µȴ�. �ߺ�ó���� �ǰ�ȵǰ���. 
select d.deptno,d.dname,s.sname from sawon s, dept d where s.deptno=d.deptno and d.deptno=10; group by d.deptno,d.dname,s.sname;
select * from sawon s, dept d where d.deptno=10 and s.deptno=10;
--�ζ��� ��� �ٲٱ�
--���� join�� ���̺��� ��� Ʃ�ÿ� ���Ͽ� join�� �� �ڿ� deptno=10�� ã�´�.
--�ζ��κ�� ���� 10 �ѹ��� �� ��������� sawon�� �񱳸� �ϱ⶧���� ��ü��+��ü�� ���ٴ� �ζ��κ䰡 �� �ӵ��� ������.
select s.sname,d.dname from sawon s, (select deptno,sname from dept where deptno=10) 
where s.deptno=d.deptno;
--������� ��� �޿����� �� ���� �޿��� �޴� ����� �˻��غ���. 
select  sname , sapay from sawon where sapay > (select avg(nvl(sapay,0)) from sawon) ;
--�μ� ��ȣ�� 20�� ����߿� �ִ�޿��� �޴� ������� �޿��� ���� �޴� ����˻�
--����,�������� ����Ȯ��
select sname, sapay from sawon where sapay>(select max(sapay) from sawon where deptno=20) ;

����1) ��浿�� �����ִ� �μ��� ��� ����� ���,�̸�,�Ի���,�޿��� ����Ͻÿ�.
select sabun, sname, sahire, sapay from sawon where deptno in(select deptno from sawon where sname='��浿');
����2) �μ���ġ�� ������ ��� ����� �̸�, �μ���ȣ�� ����Ͻÿ�.
select sname,deptno from sawon where deptno in(select deptno from dept where loc='����');
--subquery�� inlineview,join���� ����������. 
--inlineview�� join�� ���⶧����.
select s.sname,d.deptno from sawon s, (select deptno from dept where loc='����') d where s.deptno=d.deptno;

2. ������ ��������
-������������ ��ȯ�Ǵ� ����� �ϳ��̻��� ���ϋ� ���
-�ݵ�� ���� �� ������ (Multiple Row Operator)�� �Բ� ���.
<������ ������
IN: ���������� �������� ���������� ��� �߿��� �ϳ��� ��ġ�ϸ� ��.
select sabun,sname,sahire,sapay from sawon where dpetnoin(select deptno from sawon where sname like '%��%');
ANY, SOME : ���������� �������� ���������� �˻� ����� �ϳ� �̻��� ��ġ�ϸ� ��
ALL: ���������� �������� ���� ������ �˻������ ��簪�� ��ġ�ϸ� ��
Exist:���������� �������� ���������� ��� �߿��� �����ϴ� ���� �ϳ��� �����ϸ���. 

--�������� ���� �μ����ִ� ������� �̸��� ������ڸ� ����غ���.
--saname�� ���� �ߺ��� �� ��� ������ ���������δ� ������ �߻��Ѵ�.!**
select sname,sahire,deptno from sawon where deptno in(select deptno from sawon where sname='������');

select sname,sahire,deptno from sawon where deptno in(select deptno from sawon where sname='������')
and sname!='������';

--�޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� ������ �μ����� �ٹ��ϴ� ������� ������ ���
--distinct �ߺ��� �÷��� ���� ����
select distinct deptno from sawon where sapay>=3000;
select deptno from sawon where sapay>=3000;
select sname, deptno from sawon where deptno in(select distinct deptno from sawon where sapay>=3000);
--distinct : �� ����ϳ� ���� ���� ����� ��������
--����� �ٸ����ΰ�?

--ALL ������: ���� ������ �� ������ ������������ �˻��� ������� ��� ��ġ�ϸ� ���̵ȴ�.
ã�����������ؼ� aand������ �ؼ� ��� ���̸� ���� �Ǵ� ���̴�.
< ALL : �ּҰ��� ��ȯ
> ALL : �ִ밪 ��ȯ

--�μ���ȣ�� 30qjs����� �߿��� �޿��� ���� ���� ���� ��� ���� �� ���� �޿��� �޴� ����� �̸�,�޿��� ����ϴ� �����̴�.
4003���� ���� ����鸸 ��µɰ��̴�.
select max(sapay) from sawon where deptno=30;
select sname, sapay from sawon
where sapay > ALL(select sapay from sawon where deptno=30);

ANY,SOME ������
���� ������ �� ������ ���� ������ �˻� ����� �ϳ� �̻��� ��ġ�ϸ� ���̵ȴ�.
>ANY �ϸ� �񱳰� �� �ϳ����� ũ��: �ϰ� ���� ���� �ȴ�.
��, �� ���� �� ����ϳ� ���� �� ũ�Ť�, �� ���� �� �ּҰ����� �� ũ�� ���̵ȴ�.
<ANY �ִ밪
--�μ���ȣ�� 30�� ���ʵ��� �޿��� ���� ���� ������ ���� �޿��� ���� ������ �̸��� �޿��� ���
select min(sapay from sawon where deptno=30;
select sname,sapay from sawon where sapay > ANY(select sapay from sawon where deptno=30);

--�μ���ȣ�� 10�� ����� �����ϸ� ��� �μ��� �̸��� ���!
select dname from dept where exists (select sabun from sawon where deptno=10);

--���������� �̿��� ������ �����ϱ� ****
create table dept01 as select * from dept where 1=0;
select * from dept01;
desc dept01;
create table dept02 as select * from dept;
select deptno,dname,loc from dept02;
--20�� �μ��� �������� 50�� �μ��� ���������� �����Ϸ���?
update dept02 set loc='����' where deptno=20;
rollback;
update dept02 set (dname,loc)=(select dname,loc from dept02 where deptno=50) where deptno=20;

--������̺��� sawon01�� �����Ѵ�.
--���������� ����ؼ� �����͸� �����Ѵ�. (delete from sawon01 where sabun=1)
--1���� ��������͸� ����
--�ǽ�)������̺��� �μ����� '�����'�� ��� ����� �����Ͻÿ�.

create table sawon01 as select * from sawon;
delete from sawon01 where deptno=(select deptno from dept where dname='�����');
select * from sawon01;

-View
�������� ���̺��� �ٰ��� ������ ���� ���̺�
���̺��� �����Ͱ� ���������� �信�� �����Ͱ� �������� �����鼭 SQL�� ����Ǿ�����
����)
1.�����ϰ� �� �������� ��� �����ϸ� �׻� �����ϰ� ����� �� �ִ�.
2.���ȿ� �����ϴ�(���������� �����Ѵ�), �� ������ �⺻���̺��� ������ �����Ϳ��� �����������ʴ´�.
�ܼ���� ���պ�:�ϳ��� ���̺��̳� �������� ���̺��̳�, �׷��Լ� �Ұ���,�׷��Լ� ���, DML ����� ���� �Ұ����̳ķγ���
create or replae view : ���� �̸��� �䰡 �־ �����
force: �⺻���Ը��� ���翩�ο� ������� view����
with check option : �־��� ���� ���ǿ� �´� �����͸� �Է� �� ������ ���
with read only : �˻������;

create table dept_cp as select * from dept;
create table sawon_cp as select * from sawon;
--�ܼ� ��
create force view sawon_view1 as select * from sawon_cp;
select * from tab;
select * from sawon_view1;
select view_name,text from user_views;
drop view sawon_view1;

create force view dept_view1 as select deptno,dname,loc||'�Դϴ�' from dept_cp;
create force view dept_view1 as select * from dept_cp;
insert into dept_view1 values(60,'�����','����'); 
select * from dept_view1; select * from dept_cp;
drop view dept_view1;
--�ܼ� �信�� DML ��ɾ� ����� �Ұ����� ���
--�� ���Ƕ� ���Ե��� ���� �⺻ ���̺��� �÷��� not null�������� ���ԵǾ� �������
--insert���� �Ұ�, ���� �÷��� ���, distinct ������ ���, �׷��Ѽ� group by���� ������ ���.

--���� ��
create view sawon_dept_view as
select s.sname, s.deptno, d.dname from sawon s, dept d where s.deptno=d.deptno;
with check option : ���ǿ����Ǿ���Į������ �並 ���� ������ �����Ұ�;
create or replace view with_chk_op_view as select sname,sapay,deptno from sawon_cp
where deptno=30 with check option; 
select * from with_chk_op_view;
update with_chk_op_view set deptno=20 where sapay=500;
--���� �Ʒ��� with check option�� ����ȵ� ���� ������ ��
update with_chk_op_view set sapay=500 where deptno=30; 

with read only:�б� ���� ��;

create or replace view with_read_only_view as select sname,sapay,deptno from sawon_cp
where deptno=30 with read only;
update with_read_only_view set deptno=20 where sapay=400;
select * from with_read_only_view;
rollback;

���Ǿ�(Synonym)
1. �����ͺ��̽��� ������ �����ϱ� ���ؼ� ���
Synonym�� �ٸ� ������ ��ü�� �����Ҷ� ���� ���
2. ��ü�� �� �̸��� ����ϱ� ���� ª�� �̸����� �ؼ� SQL�ڵ��� �ܼ�ȭ
3. ��ü�� �����ϴ� ������� ������Ʈ�� ���� �� �ֱ� ������ �̿� ���� ������ ����.
Synonym����
1. private synonym
-���� synonym�� Ư�� ����ڸ� �̿�
2. public synonym
-���� synonym�� ���� ����� �׷��� �����ϸ� �� database�� �ִ� ��� ����ڰ� ���.
���Ǿ� ����: create synonym tablename for ������.tablename
����: drop synonym tablename ;
���������ؼ��� ������̸�.��ü   �� �����ϴ°Ծƴ϶� ������ ���� ���������ϰ��Ͽ�
������ ��ȭ.;
