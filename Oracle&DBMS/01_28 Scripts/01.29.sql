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
select sname,sahire,add_months(sahire,480) from sawon;

--��¥�� ����Ǵ� round/trunc�Լ�
--�������� ������ �ݿø�
select sname,sahire,round(sahire,'yyyy') from sawon;

--�����Լ� ['��-����']
select sysdate - to_yminterval('10-01') from dual;
select sahire + to_yminterval( trunc( months_between(sysdate,sahire)/12) ||'-'||
 
select to_date('2019/04/21','yyyy/mm/dd') -( to_date('2015/07/23','yyyy/mm/dd') + ( to_yminterval ( trunc(months_between
('2019/04/21','2015/07/23')/12) ||'-'|| trunc(mod(months_between('2019/04/21','2015/07/23'),12)) ) ) ) from dual;

select  sysdate - (sahire + ( to_yminterval ( trunc(months_between
(sysdate,sahire)/12) ||'-'|| trunc(mod(months_between(sysdate,sahire),12)) ) )  )from sawon;

--[�� ��:��:��']
select sysdate+to_dsinterval('100 00:00:00') from dual;
--months_between ��¥�� ��¥ ������ �������� ���ϴ� �Լ�
select sahire, trunc(months_between(sysdate,sahire))from sawon;
select sahire, months_between(sysdate,sahire)from sawon;
select  trunc(months_between(sysdate,sahire)) from sawon;

--����Ʈ �ۼ��� �� �����Ұ�
--���� ���� trunc(mont~~~ :�ּ�����
--��������1)������̺��� ����� �ٹ��ϼ�, ���� , �ٹ��� ����
--      ������ 10/05/11 | 3081 _ 8�� 5���� 5��
--��������2) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ,�̸�,�ٹ��ϼ��� ����Ͻÿ�
--��������3)��� ����� 60�� ���� ���� �������� ���,���,���� �ΰ��� ������
--�̸� �Ի��� ������ �� �������Ͻÿ�.
select to_date('2019/01/19','yyyy/mm/dd')+60 from dual;
--�������� 1)
select sname �����, sahire �����, trunc(sysdate-sahire) �ٹ��ϼ�,
trunc(months_between(sysdate,sahire)) �ٹ�����,
trunc(months_between(sysdate,sahire)/12)||'��'|| trunc(mod(months_between(sysdate,sahire),12)) ||'��'||
 (trunc(sysdate)
        - add_months(sahire, trunc(months_between(sysdate,sahire))
        )) ||'��'  �ٹ������
from sawon;

select sname �����, sahire �����, trunc(sysdate-sahire) �ٹ��ϼ�,
trunc(months_between(sysdate,sahire)) �ٹ�����,
trunc(months_between(sysdate,sahire)/12)||'��'|| trunc(mod(months_between(sysdate,sahire),12)) ||'��'||
 (trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        )) ||'��'  �ٹ������ from sawon;

--��������2)
select deptno,sname,sahire �Ի���, last_day(sahire)-sahire �Ի��Ѵ��Ǳٹ��ϼ� from sawon;
--��������3)
select next_day(to_date('2019/01/19','yyyy/mm/dd')+60,'��') from dual;
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
select sum(sapay)/24,avg(nvl(sapay,0)), count(*),max(sapay),min(sapay) from sawon;
--nvl:�÷��ϳ� �ܵ����� �Լ�
-- avg:count ���� ������ �� �־����
-- count(sapay): ���� �������� ���� => count(nvl(sapay,0)) �� ����
select count(sapay) from sawon;
select * from sawon;

--�μ��� �޿� �հ踦 ���
--�� 10,20�� �μ������
--�� �޿��հ谡 15000�̻��� �׷츸 ���
select deptno, sum(sapay) from sawon
where deptno=10 or deptno=30  --where������ grounp�Լ��� ��� �� �� ����
group by deptno
--���ĵ� -- group by ***; ***���ִ� ���� �̸�.... �׷�ȭ
--�Ϲ� �÷��� ����Լ��� ���̾����� ��ȯ���� Ʋ���� �׷�ȭ�� ��������Ѵ�.
having sum(sapay) >=15000; --group by�� ���� ������

---------------------
/*
select : �������÷�...
from : ��𿡼�(���̺�,��)
where : ������,����Լ� ���Ұ���(from ���� ���� ���� �м��ϱ⶧��)
group by: �׷����� ��ħ.
having :groupby������ϴ� ����Լ� ��밡��
order by :����
*/
select num,name,pnum from memphone where pnum like '%032%';
--����) ����, ��å�� �ο����� �޿��ղ��� ���
--��)���ڸ� �׷�ȭ�ϰ� �ο��� 2�������� ����� ���
--�ο����� ���� ������ �����Ͻÿ�
select sgender , sajob,rank() over(order by (count(nvl(sajob,0))) desc), 
count(nvl(sajob,0)),sum(sapay) from sawon where sgender='����' group by sgender,sajob having count(nvl(sajob,0))<=2; 

--�ο����� ���� ������ �����Ͻÿ�
select sgender, sajob, count(nvl(sajob,0)),sum(sapay)
from sawon
where sgender='����' group by sgender, sajob
having count (nvl(sajob,0))<=2
order by sajob;

select deptno,max(sapay) from sawon group by deptno order by 2 desc;

--rownum:���� �÷�,�ӽ÷� �÷��� �ο��Ǵ� �Ϸù�ȣ
--where ������ ���� ������ �����Ҷ� ���, ��������(�ټ����� �ֽ� �����͸�..)
--�޿��� ���� ������ ����� ���, ��ȣ �Բ� ���
select rownum,sname,sapay  --
from sawon  --1��° ����
where rownum<=3   --2��° ����
order by sapay desc, sname;  --3��° ����. �̹� rownum�� �����Ǿ��ֱ� ������ �ǹ̾���.
--From -> where -> select -> order by 
--from ���� ���� ���� ����ǰ� sawon���̺� rownum�� �ο��ȴ�.
--�� ���Ŀ� where���� ����Ǳ� ������ ������ �̷������ ���� rownum<=3�� row�� ���õȴ�. 
--�̷��� inline view�� �ʿ��ϴ�. 
--view�� rownum�� �پ ���ĵǹ����� ���� �����ؾ��ϱ⶧����, ����Ǳ� ���� ���̺��� �����ϵ��̸������Ѵ�.
select rownum,sname,sapay from
(select rownum,sname,sapay from sawon order by sapay desc,sname )
where rownum <=3;
--from�� �ڿ� subquery�� �����ϸ� view���ȴ�. 
--subquery�� ()�ȿ�������, ��������ȴ�. 

select sum(decode (sajob,'���',sapay,0)) "���",
sum(decode(sajob,'�븮',sapay,0))"�븮",
sum(decode(sajob,'����',sapay,0))"����",
sum(decode(sajob,'ȸ��',sapay,0))"ȸ��",
sum(sapay) "�հ�" from sawon;
--���� �հ� ���ϱ� 
--���� | ���� | �հ�
select sum(decode (sgender,'����',sapay,0)) "����",
sum(decode(sgender,'����',sapay,0))"����",
count(*) "�հ�" from sawon;

--����
--����ϴ� �÷��� �ΰ� �̻��� ���̺� �����ϴ� ��� ���Ǵ� ��� ���� ���
--32����������
--����
--1. eque(inner) join:���εǴ� ���̺� ���� ���ǿ� �����ϴ� �ุ�� ����
--2. outer join(left&right) : ���εǴ� ���̺��� ���ǿ� �����ϴ� ���
--�̽��� ���̺��� ��� �����Ͱ� ����
--3. cross join:���εǴ� ���̺��� � ���赵 ���� �汸(table*table)->īƼ�� ���δ�Ʈ
------
--4. self join:�ڱ��ڽ��� ���̺�� ���εǴ� ���
--����
1.T-SQL ����:where ������, ���̺���� �����Ͽ� ǥ��
-select~: ���ϴ� �÷� ����
-from~ : ����� �÷��� ���� ���̺� ����
-where~ : ���� ���̺��� ���� �Ǵ� ������ ����
2.Ansi ����:on ������, ���������� ǥ��
--���εǴ� ���̺��� ���� �÷����� ������� -ansi
select sname,deptno,dname from sawon natural join dept;
select sname,deptno,dname from sawon join dept using(deptno);
--�÷����� ���ƾ� �Ǵ°��� ���� , �޶� partition�̸�������� ��絥���Ͱ� �������Ծƴ϶� ���������γ��� ��������
select goname,godam,sname from sawon natural join gogek;
select goname,godam,sname from sawon join gogek using(godam);
--�����,�μ���ȣ,�μ����� ���
select s.sname,s.deptno,d.dname from sawon s, dept d
where s.deptno=d.deptno;

select sname,godam,sname from sawon s, gogek g
where g.godam=s.sabun(+); 
--outer inner ����.
--inner�� join�ϴ� atrribute�� �Ѵ� null�̾ƴϿ����Ѵ�.
--outer�� left�� ���� null�����, right�� ������ null�� ��� �Ǵ� join�̴�. 

select s.sname,s.deptno,d.dname from safwon s join dept d on (s.deptno=d.deptno);--ansi
--����,��ȭ��ȣ,����ڸ��� ���(��,����ڰ� ���� ���� ���)
select g.goname,g.gotel,s.sname from gogek g, sawon s where g.godam=s.sabun(+);
select g.goname,g.gotel,s.sname from gogek g left outer join sawon s on (g.godam=s.sabun);
--�����,��å,����ڸ�,��å�����
select s.sname, s.sajob,m.sname,m.sajob from sawon s, sawon m where s.samgr=m.sabun(+);


--����,����ڸ�,��å,�μ����� ���(����ڰ� ���� ���� ���)
select g.goname,g.godam,s.sajob,d.dname  from gogek g, dept d, sawon s
where g.godam=s.sabun(+) and s.deptno=d.deptno(+);
--�μ���,�����,��å,����ڸ�,��å�� ���(��,����ڰ� ���� ����� ���)
select d.dname, s.sname,s.sajob,m.sname,m.sajob from sawon s, sawon m, dept d
where d.deptno(+)=s.deptno and s.samgr=m.sabun(+);
--�μ�(��)�� �޿� �հ踦 ���
select d.dname, sum(s.sapay) from sawon s, dept d
where d.deptno=s.deptno group by d.dname;


--����1)
select trunc( to_char(sysdate,'yyyy')/100 +1) ���� , 
trunc( to_char(sysdate,'yyyy')) ����,
to_char(sysdate,'dy') ���� from dual;
--����2)
select sysdate ���ó�¥,to_char(sysdate,'yyyy"��" mm"��" dd"��" day')||'�̸� '||
to_char(sysdate,'q')||'�б�, ������ 1���߿� '
|| trunc(  to_date(to_char(sysdate,'yyyy')+1||'01/01','yyyy/mm/dd')-sysdate) ||'�� ��������, '||
(365- trunc(  to_date(to_char(sysdate,'yyyy')+1||'01/01','yyyy/mm/dd')-sysdate) ) ||'�� �������ϴ�'
 ��¹� from dual; 

--����3)
--1�����
select sname �����, sahire �����, trunc(sysdate-sahire) �ٹ��ϼ�,
trunc(months_between(sysdate,sahire)) �ٹ�����,
trunc(months_between(sysdate,sahire)/12)||'��'|| trunc(mod(months_between(sysdate,sahire),12)) ||'��'||
 (trunc(sysdate)
        - add_months(sahire, trunc(months_between(sysdate,sahire))
        )) ||'��'  �ٹ������
from sawon;
--2�����
select sname �����, sahire �����, trunc(sysdate-sahire) �ٹ��ϼ�,
trunc(months_between(sysdate,sahire)) �ٹ�����,
trunc(months_between(sysdate,sahire)/12)||'��'|| trunc(mod(months_between(sysdate,sahire),12)) ||'��'||
 (trunc(sysdate)
        - add_months(sahire,trunc(months_between(sysdate,sahire))
        )) ||'��'  �ٹ������ from sawon;

(trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        ))
        
--����4)
select deptno,sname,sahire �Ի���, last_day(sahire)-sahire �Ի��Ѵ��Ǳٹ��ϼ� from sawon;
--����5)
select sname ����̸�, sahire �����,  to_char(next_day(sahire+60,'��'),'yyyy"��" mm"��" dd"��"') "60���� ù ������" from sawon;
--����6)
select deptno �μ�, sname ���, sahire �����, sysdate ���� ,  trunc(sysdate-sahire) �ٹ��ϼ�, 
trunc(months_between(sysdate,sahire)/12)||'��'|| trunc(mod(months_between(sysdate,sahire),12)) ||'��'||
 (trunc(sysdate)
        - add_months(sahire,trunc(  months_between(sysdate,sahire)  /  12  )*12+trunc(mod(months_between(sysdate,sahire),12))
        )) ||'��'  �ٹ������ from sawon;

--����7)
select to_char(sahire,'yy') ���⵵, sum(sapay) ������, max(sapay) �ְ���  from sawon group by sahire ;
--����8)
select sajob ��å, count(sajob) ��� from sawon group by sajob having count(sajob)>=3;
--����9)
select deptno �μ�, round(avg(sapay),1) ��տ���,max(sapay) �ְ���� ,min(sapay) ��������
from sawon  group by deptno order by avg(sapay) desc;
--����10)
select d.deptno �μ���ȣ,d.dname �μ���,
count(case when to_char(sahire,'yyyy')=1980  then 1 end) "1980�Ի�" ,
count(case when to_char(sahire,'yyyy')=1981  then 1 end) "1981�Ի�" ,
count(case when to_char(sahire,'yyyy')=1982  then 1 end) "1982�Ի�" ,
count(case when to_char(sahire,'yyyy')=1983  then 1 end) "1983�Ի�" 
from sawon s , dept d where s.deptno=d.deptno group by d.deptno,d.dname
having 
count(case when to_char(sahire,'yyyy')=1980  then 1 end) +
count(case when to_char(sahire,'yyyy')=1981  then 1 end) +
count(case when to_char(sahire,'yyyy')=1982  then 1 end) +
count(case when to_char(sahire,'yyyy')=1983  then 1 end) !=0  order by 1 desc;
