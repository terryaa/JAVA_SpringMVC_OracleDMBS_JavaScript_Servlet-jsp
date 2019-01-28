/*
���̺�� gogek
gobun number(3)
goname varchar2(25)
gotel varchar2(34)
gojumin varchar2(14)
godam number(3)
pk:gobun
unique,not null:jimin
foreign key godam-> sawon.sabun
*/

create table gogek(
gobun number(3),
goname varchar2(25),
gotel varchar2(34),
gojumin varchar2(14) constraint gogek_gojumin_nn not null,
godam number(3),
constraint gogek_gobun_pk primary key(gobun),
constraint gogek_gojumin_uq unique(gojumin),
constraint gogek_godam_sabun_fk foreign key(godam)
references sawon(sabun)
);
delete from dept;
delete from sawon;
delete from gogek;
commit;
--pk:gobun
--unique,not null:jimin
--foreign key godam-> sawon.sabun

Insert Into Dept Values(10, '�ѹ���','����');
Insert Into Dept Values(20, '������','����');
Insert Into Dept Values(30, '�����','�λ�');
Insert Into Dept Values(40, '������', '����');
Insert Into Dept Values(50, '���ߺ�', '����');

Insert Into sawon Values(1,'��浿',10,'ȸ��',5000,'1980/01/01','����',null);
Insert Into sawon Values(2,'�ѱ���',20,'����',3000,'1988/11/01', '����',1);
Insert Into sawon Values(3,'�̼���',20,'����',3500,'1985/03/01','����', 2);
Insert Into sawon Values(5,'�̼���',20,'���',1200,'1990/05/01','����', 3);
Insert Into sawon Values(7,'��⸸',20,'����',2300,'1996/06/01','����', 2);
Insert Into sawon Values(11,'������',20,'����',1600,'1989/12/01','����', 2);
Insert Into sawon Values(14,'ä�ö�',20,'���',3400,'1993/10/01','����', 3);
Insert Into sawon Values(17,'�̼���',30,'����',2803,'1984/05/01','����', 1);
Insert Into sawon Values(13,'����ȭ',10,'����',3000,'1996/11/01','����', 1);
Insert Into sawon Values(19,'�Ӳ���',20,'���',2200,'1988/04/01','����', 7);
Insert Into sawon Values(20,'������',10,'����',4500,'1990/05/01','����', 13);
Insert Into sawon Values(6,'���θ�',30,'����',4003,'1995/05/01','����', 17);
Insert Into sawon Values(8,'ä��ȭ',30,'�븮',1703,'1992/06/01','����', 17);
Insert Into sawon Values(12,'������',10,'�븮',1800,'1990/10/01','����', 20);
Insert Into sawon Values(9,'����ȭ',10,'���',1100,'1984/08/01','����', 12);
Insert Into sawon Values(4,'�̶̹�',30,'�븮',2503,'1983/04/01','����', 17);
Insert Into sawon Values(10,'������',30,'���',1303,'1988/11/01','����', 4);
Insert Into sawon Values(15,'���϶�',10,'���',2000,'1991/04/01','����', 12);
Insert Into sawon Values(16,'������',30,'���',400,'1981/04/01','����', 4);
Insert Into sawon Values(18,'������',30,'���',1003,'1986/07/01','����', 4);
Insert Into sawon Values(21,'�����',50,'����',4500,'2000/05/01','����', 1);
Insert Into sawon Values(22,'ȫ����',50,'����',3500,'2001/11/01','����', 21);
Insert Into sawon Values(23,'������',50,'�븮',2500,'2002/08/01','����', 22);
Insert Into sawon Values(24,'������',50,'���',2000,'2010/05/11','����', 23);


insert into gogek values(1,'����', '123-1234', '700113-1537915',3);
insert into gogek values(2,'����', '343-1454', '690216-1627914',2);
insert into gogek values(3,'����', '144-1655', '750320-2636215',null);
insert into gogek values(4,'ö��', '673-1674', '770430-1234567',4);
insert into gogek values(5,'����', '123-1674', '720521-1123675',3);
insert into gogek values(6,'ĵ��', '673-1764', '650725-2534566',null);
insert into gogek values(7,'����', '176-7677', '630608-1648614',7);
insert into gogek values(8,'�赹', '673-6774', '800804-1346574',9);
insert into gogek values(9,'ȫ��', '767-1234', '731225-1234689',13);
insert into gogek values(10,'�ȳ�','767-1677', '751015-2432168',4);
insert into gogek values(11,'�䳪','767-1677', '041010-4142355',24);
insert into gogek values(12,'�α�','767-1677', '031015-3112163',24);
commit;

select sname as ����̸� from sawon;
select sname ����̸� from sawon;
select sname "��� �̸�" from sawon;
select sname || '�� �����ȣ��' || sabun || '�Դϴ�.' as sainfo from sawon;

select sname,sapay/12 as ���� from sawon;
select sname , sapay/2 *100 as ���ʽ� from sawon;
select sname,deptno,sapay/2*100 as ���ʽ� from sawon where deptno=10;
select sname,sapay from sawon where sapay>=2000 and sapay<=3000;
select sname,deptno,sapay from sawon 
where deptno>=10 and deptno<=30;

-- in������. or����ϴ°ͺ��� ���α׷����� ��������.
--not in()
select deptno, sname from sawon where deptno in(10,20);
select deptno, sname from sawon where deptno not in(10,20);

--like ���ڿ� ������.
-- % � ���� ���ڿ�
-- __ � �� ���ڿ�
--��) �̸��߿� "��"�� ���� ����� ����ϱ�
select sname from sawon where sname like '%��%';
select sname from sawon where sname like '__��';

--dual ���̺� : ���� ���̺�
--�� ������ ����� ����ϱ����� ���� ���̺�
--��� ����, ���� �÷����� ���� �ѹ��� ����ϱ����� �������� ���
select 100*2 result , 140 sum from dual;
desc dual;
/*

�̸�    ��? ����          
----- -- ----------- 
DUMMY    VARCHAR2(1) */

select sysdate from dual;
select * from dual;

--�����Լ�
select -10, abs(-10) from dual;
select sin(10),cos(10),tan(10) from dual;

--�ݿø�
select round(88.88) from dual;
select round(88.888,0) from dual;
select round(88.888,2) from dual;
select round(88.888,-2) from dual;
--wkfltnfmfqjfla
select trunc(888.888) from dual;
--���Ѱ�(ceil),���Ѱ�(fllor)
select ceil(10.001), floor(10.99) from dual;
select mod(10,2) from dual;

select length('kostaBigdata Oracle') from dual;
select lower('kostabigdata Oracle'), upper('kostaBigdata Oracle')
from dual;
--�̴ϼ��� �빮�ڷ�
select initcap('kosta bigdata oracle') from dual;
select * from nls_database_parameters where parameter like '%CHARACTERSET%';
--AL32utf8 :�ѱ����ı���� ����,3����Ʈ������������
select lengthb('kosta'),length('kosta') from dual;
--lengthb�� ���ڿ��� ����Ʈ����ȯ
select lengthb('����Ŭ'), length('����Ŭ') from dual;
--���ڿ� �ڸ��� (trim), rtrim,ltrim
select trim(' kosta bigdata ' ),length(' kosta bigdata '),
length(trim(' kosta bigdata ')) from dual;
select ltrim('%%%kosta bigdata ','%'), rtrim('%%%kosta bigdata%%%','%') from dual;
--instr(���ڿ�,ã�����ڿ�,�˻�����,n��°)
--���ڿ��߿��� ������ Ź�����ڰ� ���Ե� ��ġ�� ��ȯ�ϴ� �Լ� : indexOf
select instr('kosta_kosta','k',1,2) from dual;
--Substr(���ڿ�,n����,n��)
-- ����Ŭ�ε����� 1���ͽ���
select substr('Welcomee to Oracle',4) from dual;

--��������) �ǽ����̺� �����
create table memphone(
num number(3) constraint memphone_num_pk primary key,
name varchar2(20),
pnum varchar2 (30));
create sequence memphone_seq
increment by 1
start with 1;

insert into memphone values (memphone_seq.nextVal,'��浿','02)567-1235');
insert into memphone values (memphone_seq.nextVal,'������','032)227-8235');
insert into memphone values (memphone_seq.nextVal,'��뷡','031)167-8495');
insert into memphone values (memphone_seq.nextVal,'������','031)837-8475');
insert into memphone values (memphone_seq.nextVal,'�����','032)967-6235');
commit;
--memberphone ���̺��� ������� ��ȭ��ȣ �߿�
--�����,����,��ȭ��ȣ ���·� ����Ͻÿ�.
select name as '�����', substr(pnum,instr(pnum,')',1,1)) from memphone;

select name ,substr(pnum,1,instr(pnum,')',1,1)-1) AS "phone", substr(pnum,instr(pnum,')',1,1)+1) from memphone;

--���� ä��� �Լ�
select rpad(sname,9,'��'), lpad(sname,8,'��') from sawon;

--decode �Լ� : oracle ������ �����ϴ� SQL�Լ�
--decode(���ذ�,����1,���1����2,���2,,�׿�) "�÷�"
--case�Լ� : decode �� ����� Ȯ���� �Լ�

/*
    case[���ذ�] when ���ذ� ���ǰ�1  then ��� 1
    when ���ذ� ���ǰ�2 then ���2
    else �׿��ǰ��
    end "Į����"
*/
--���� : decode �Լ��� ���ذ��� ���ϴ� �÷����� "=" �񱳸� ���ؼ��� ���ǰ� ��ġ
--case ���,��,���� �پ��� �񱳰� �����ϴ�.
select deptno,dname from dept;
select sname,deptno,decode(deptno,50,'���ߺ�',20,'������',30,'�����','�Ѱ�����') from sawon order by 2 asc;
--case�����ιٱź���
select sname,deptno, case when deptno>10 then '���ߺ�' else '�Ѱ�����' end AS GRADE  from sawon;

select sname||'�� �޿��� '||sapay||' �Դϴ�. �̹��� ���ʽ��� �޿��� 50%('||sapay/2||') �Դϴ�.' AS �޿���ȸ  from sawon where sname='��浿';
select '�μ���ȣ'||deptno as deptno, sname||'���� �޿��� '||sapay||'�Դϴ�.' as message from sawon where sapay>=2000 and sapay<=3000 and deptno=20;
select sname as �����, sapay as �޿�, round(sapay/12,-1) as ���� , floor(sapay*3.3/100) as ���� from sawon;