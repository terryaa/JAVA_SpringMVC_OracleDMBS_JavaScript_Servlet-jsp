select first_name from employees where first_name='SCOTT';


--����1)
select first_name , last_name , salary 
from employees where salary>=(select salary from employees where first_name='Valli');
--����2)
--distinct ���� �Ҽ��ִ��������غ���
select distinct d.department_id,department_name,l.city,job_id from departments d, employees e,locations l
where e.job_id='ST_CLERK' and d.location_id=l.location_id ;
--����4)
select first_name,last_name,d.department_id from departments d, employees e
where e.department_id=d.department_id and 
d.department_id in(select department_id from departments 
where location_id=(select location_id from locations where city='Seattle'));
--����3)
select first_name,last_name from employees where 
regexp_like (first_name,'[t]|[T]') or regexp_like(last_name,'[t]||[T]') ;

--����5)
select first_name, last_name , salary from employees 
where department_id=(select department_id from departments where department_name='Sales');

--����6)
select first_name, last_name, salary from employees 
where manager_id in(select employee_id from employees where last_name='King' or first_name='King');

--����7)
select first_name,last_name, salary from employees where department_id in
( select department_id from employees 
where( regexp_like (first_name,'[s]|[S]') or regexp_like(last_name,'[s]||[S]') )  )
and salary>(select avg(salary) from employees);