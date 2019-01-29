--��¥����
/*
��¥ +,- ���� : ��¥�κ��� �� �Ⱓ��ŭ ���� ��¥�� ���
��¥ - ��¥: �� ��¥���̿� �Ⱓ�� ���
*/

select sysdate - 1 yesterday,sysdate,sysdate +1 tomorrow from dual;

/*
��ȯ�Լ�
to_char��¥|����,'����): ��¥ �Ǵ� ���ڸ� ¢���� ������ ���ڿ��� ��ȯ
to_date(��¥�����ǹ��ڿ�,'����') : ��¥������ ���ڿ��� ������ ������ ��¥�� ��ȯ
*/
select regexp_replace(sysdate,'/','') from dual;

select to_number('100') + 100 from dual;
select to_char(sysdate,'yyyy') to_char(sysdate,'CC'),
to_char(sysdate,'RRRR')from dual;
select to_char(sysdate,'YEAR')from dual; -- ����ǥ��
select to_char(sysdate,'yy') from dual; --���� 2�ڸ�
select to_char(sysdate,'month'),to_char(sysdate,'mon') from dual; 
select to_char(sysdate,'q') from dual; --�б�
select to_char(sysdate,'d') from dual; --����(1~7 :1->�Ͽ���)
select to_char(sysdate,'dy')from dual; --
select to_char(sysdate,'day','NLS_DATE_LANGUAGE=ENGLISH') from dual;
select to_char(sysdate,'day') from dual;
select to_char(sysdate,'dd')from dual;
select to_char(sysdate,'ddd') from dual;
select to_char(sysdate,'hh') from dual;
select to_char(sysdate,'mi') from dual;
select to_char(sysdate,'ss') from dual;
--2019�� 01��29�Ϸ� ����غ���
select sysdate,to_char(sysdate,'yyyy"��" mm"��" dd"��" day') from dual; 
-- ���� ���� ����(9-���� ���ٸ� ����� ����, 0-���� ��� ���
select sname, to_char(sapay,'fm$9,990') from sawon;

--next,last
--������ �������� ���� ����� ���� ȭ������ ���������� ��ȯ��
select next_day(sysdate,to_char(sysdate,'dy')) from dual;
--������ ��/���� ������ ��¥(�̴��� ������ ��¥��)
select last_day(sysdate) from dual;
--add_months : Ư�� �������� ���� ��¥�� �����ִ� �Լ�
select sname,sahire,add_months(sahire,5) from sawon;

--��¥�� ����Ǵ� round/trunc�Լ�
--�������� ������ �ݿø�
select sname,sahire,round(sahire,'yyyy') from sawon;

--�����Լ� ['��-����']
select sysdate + to_yminterval('01-00') from dual;

--[�� ��:��:��']
select sysdate+to_dsinterval('100 00:00:00') from dual;
select trunc(sysdate) - to_date('19'||sahire, 'yyyy/mm/dd') from sawon;
--months_between ��¥�� ��¥ ������ �������� ���ϴ� �Լ�
select sahire, trunc(months_between(sysdate,sahire))from sawon;
select sahire, months_between(sysdate,sahire)from sawon;

--����Ʈ �ۼ��� �� �����Ұ�
--���� ���� trunc(mont~~~ :�ּ�����
--��������1)������̺��� ����� �ٹ��ϼ�, ���� , �ٹ��� ����
--      ������ 10/05/11 | 3081 _ 8�� 5���� 5��
--��������2) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ,�̸�,�ٹ��ϼ��� ����Ͻÿ�
--��������3)��� ����� 60�� ���� ���� �������� ���,���,���� �ΰ��� ������
--�̸� �Ի��� ������ �� �������Ͻÿ�.

select sname �����, sahire �����, trunc(sysdate-sahire) �ٹ��ϼ�,
trunc(months_between(sysdate,sahire)) �ٹ�����   from sawon;

select round(months_between(sysdate,sahire))/12 ||'��'|| from sawon;
select trunc(months_between('2019/04/21','2015/01/22')/12)  from dual;
select trunc(mod(months_between('2019/04/21','2015/01/19'),12))  from dual;

--

/*
�����Լ�
���� : rank() over([partition by �÷���] order by �÷��� [desc]) "����"
over : ������ �ο��ϱ����� ��� ������ ���� ���ذ� ���� ���� ����
partition by: �÷����� �������� ����, �����ÿ��� ��ü ������ ������� �����ο�
order by �÷���: �÷��� �������� ����
*/
---------------------------------------------------------
/*
Rank�Լ��� 1���� 2���ΰ�쿡�� ��� ���츦 3������ �ο��Ѵ�.
-���İ���� �������� ��ü ������ ����ϱ����� ���
Dense_rank�Լ��´��� ������ 2������ �ο��Ѵ�.
0���� ������ ������ ���� ������ ����ϱ����� ���ȴ�.
*/

select gobun,godam,goname, rank() over(order by godam desc)
from gogek where godam is not null;
select gobun,godam,goname, dense_rank() over(order by godam desc)
from gogek where godam is not null;

--����)�μ����� �޿��� ���� ������ ������ ����Ͻÿ�.(�� �� ���� ����)
-- �μ� ��ȣ , ����̸�, �޿�, ����
select deptno �μ���ȣ, sname ����̸� , sapay �޿�, 
rank() over(partition by deptno order by sapay desc) from sawon where sapay is not null;

--����Լ�, �����Լ�, �׷��Լ�
--sum,avg,count,max,min�Լ�
--�׷��Լ��� �Ϲ� �����÷� �Բ� ����ϱ� ���ؼ� group b �Ϲ������÷�,..--�����۾�
select sum(sapay)/24,avg(sapay), count(*),max(sapay),min(sapay) from sawon;
--nvl:�÷��ϳ� �ܵ����� �Լ�
-- avg:count ���� ������ �� �־����
-- count(sapay): ���� �������� ���� => count(nvl(sapay,0))
select * from sawon;