drop table member;
commit;

insert into movie (movie_number, movie_price ) values (100,1);
insert into member (member_number,member_id) values (1,'terryaa');
insert into member (member_number,member_id) values (2,'terryaaaa');
CREATE SEQUENCE member_number_seq
 START WITH     3
 INCREMENT BY   1;
insert into member
(member_number,member_id,member_join_date)
values (member_number_seq.nextVal,'terryaa3','19/03/16');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa4','19/03/17');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa5','19/03/18');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa6','19/03/19');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa7','19/03/20');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa8','19/03/20');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa9','19/02/17');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa10','19/02/18');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa11','19/01/17');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa12','18/12/10');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa13','18/12/17');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa14','18/11/07');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa15','17/11/07');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa16','16/11/07');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa17','15/11/07');
insert into member (member_number,member_id,member_join_date) values (member_number_seq.nextVal,'terryaa18','15/11/07');
CREATE SEQUENCE movie_number_seq
 START WITH     101
 INCREMENT BY   1;
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/20',50000,1000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/19',100000,9000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/16',750000,10000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/17',50000,15000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/03',578000,1150000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/02',123000,2000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/03/01',345000,30500000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/02/20',1230000,5500000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/02/20',3450000,1000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/02/16',2340000,1000000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/02/05',6547000,40500000);
insert into movie (movie_number, movie_purchase_date,movie_investment,movie_copyright_cost)
values (movie_number_seq.nextVal,'19/02/10',704000,20300000);




CREATE SEQUENCE watchlog_number_seq
 START WITH     6
 INCREMENT BY   1;
 delete from watchlog where watchlog_number=1;
insert  into watchlog values(1,100,1,sysdate);
insert  into watchlog values(2,100,1,'19/03/17');
insert  into watchlog values(3,100,1,'19/03/16');
insert  into watchlog values(4,100,1,'19/03/15');
insert  into watchlog values(5,100,1,'19/03/14');

insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/19');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/19');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/19');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/18');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/17');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/16');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/03/15');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/02/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/02/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/02/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'19/01/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'18/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'18/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'18/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'18/11/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'17/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'17/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'16/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'16/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'16/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'16/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'15/12/20');
insert  into watchlog values(watchlog_number_seq.nextVal,100,1,'15/12/20');





select count (*) from watchlog where watchlog_date like sysdate;
select count (*) from watchlog ;

alter table member add member_join_date DATE ;

CREATE SEQUENCE viewlog_number_seq
 START WITH     9
 INCREMENT BY   1;
 delete from viewlog where viewlog_number=1;
insert  into viewlog values(1,100,1,sysdate);
insert  into viewlog values(2,100,1,'19/03/17');
insert  into viewlog values(3,100,1,'19/03/16');
insert  into viewlog values(4,100,1,'19/03/15');
insert  into viewlog values(5,100,1,'19/03/14');
insert  into viewlog values(6,100,1,'19/03/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/20');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/20');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/19');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/19');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/19');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/18');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/17');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/16');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/03/15');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/02/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/01/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/01/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'19/01/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'18/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'18/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'18/11/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'18/11/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'17/11/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'17/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'16/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'16/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'16/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'15/12/13');
insert  into viewlog values(viewlog_number_seq.nextVal,100,3,'15/12/13');






insert  into loginlog values(1,1,'19/03/16',sysdate);
insert  into loginlog values(2,1,'19/03/16','19/03/16');
insert  into loginlog values(3,1,'19/03/15','19/03/15');
insert  into loginlog values(4,1,'19/03/14','19/03/14');
insert  into loginlog values(5,1,'19/03/13','19/03/13');
insert  into loginlog values(6,1,'19/03/13','19/03/12');
insert  into loginlog values(7,1,'19/03/13','19/03/11');
insert  into loginlog values(9,1,'19/03/17','19/03/17');
insert  into loginlog values(11,1,'19/03/19','19/03/19');
insert  into loginlog values(12,1,'19/02/18','19/03/19');
insert  into loginlog values(13,1,'19/01/18','19/03/19');
insert  into loginlog values(14,1,'18/12/18','19/03/19');
insert  into loginlog values(15,1,'18/11/18','19/03/19');
insert  into loginlog values(16,1,'19/02/18','19/03/19');
insert  into loginlog values(17,1,'17/10/18','19/03/19');
insert  into loginlog values(18,1,'16/12/18','16/03/19');
insert  into loginlog values(19,1,'15/11/18','15/03/19');
insert  into loginlog values(20,1,'14/02/18','14/03/19');
insert  into loginlog values(21,1,'13/10/18','13/03/19');
insert  into loginlog values(22,1,'17/10/18','17/03/19');
insert  into loginlog values(23,1,'19/03/20','19/03/20');
insert  into loginlog values(24,1,'18/03/20','19/03/20');
insert  into loginlog values(25,1,'19/03/20','19/03/20');
insert  into loginlog values(26,1,'19/03/16','19/03/20');
insert  into loginlog values(27,1,'19/03/16','19/03/16');

delete from loginlog where loginlog_number=1;
commit;



CREATE SEQUENCE moviesoldlog_number_seq
 START WITH     9
 INCREMENT BY   1;
delete from moviesoldlog where soldlog_number=1;
insert  into moviesoldlog values(1,1,100,1,sysdate);
insert  into moviesoldlog values(2,1,100,1,'19/03/16');
insert  into moviesoldlog values(3,1,100,1,'19/03/15');
insert  into moviesoldlog values(4,1,100,1,'19/03/14');
insert  into moviesoldlog values(5,1,100,1,'19/03/13');
insert  into moviesoldlog values(6,1,100,1,'19/03/12');
insert  into moviesoldlog values(7,1,100,1,'19/03/11');
insert  into moviesoldlog values(8,1,100,1,'19/03/10');

insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'19/03/20');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'19/03/20');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'19/03/19');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'19/03/18');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'19/03/17');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'19/03/17');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'19/03/16');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'19/03/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'19/03/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'19/02/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'19/01/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'18/12/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'18/11/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'18/11/14');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'17/11/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,1,'16/11/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,2,'15/11/15');
insert  into moviesoldlog values(moviesoldlog_number_seq.nextVal,3,100,3,'15/11/15');

commit;


select movie_sold_date from moviesoldlog where movie_sold_date<=sysdate and movie_sold_date>= (sysdate-5); 


select loginglog_login, count(*) from loginlog
group by loginglog_login 
having loginglog_login<=sysdate and loginglog_login>=(sysdate-5) order by loginglog_login asc;

select  extract(year from loginglog_login)  , count(*) from loginlog
group by extract(year from loginglog_login)
having 
extract(year from loginglog_login) <= extract(year from sysdate) and
extract(year from loginglog_login) >=  (extract(year from sysdate)-4)
order by extract(year from loginglog_login) asc  ;

select extract(month from loginglog_login) ,count(*) from 
(select loginglog_login ,count(*) from loginlog
group by loginglog_login
having loginglog_login <=last_day(sysdate) and loginglog_login>=last_day( add_months(sysdate,-5) )
order by loginglog_login asc)
group by extract(month from loginglog_login)
order by extract(month from loginglog_login) asc ;


select member_join_date, count(*) from member
group by member_join_date
having  member_join_date<=sysdate and  member_join_date>=(sysdate-5) order by  member_join_date asc;

select extract(month from  member_join_date) ,count(*) from 
(select  member_join_date ,count(*) from member
group by  member_join_date
having  member_join_date <=last_day(sysdate) and  member_join_date>=last_day( add_months(sysdate,-5) )
order by  member_join_date asc)
group by extract(month from  member_join_date)
order by extract(month from  member_join_date) asc ;

select extract(year from member_join_date), count(*) from member
group by extract(year from member_join_date)
having 
extract(year from member_join_date) <= extract(year from sysdate) and
extract(year from member_join_date) >=  (extract(year from sysdate)-4)
order by extract(year from member_join_date) asc;

select movie_sold_date , count(*) from moviesoldlog
group by movie_sold_date 
having movie_sold_date<=sysdate and movie_sold_date>=(sysdate-5) order by movie_sold_date asc;

select extract(month from movie_sold_date ) ,count(*) from 
(select  movie_sold_date  ,count(*) from moviesoldlog
group by  movie_sold_date 
having  movie_sold_date  <=last_day(sysdate) and  movie_sold_date >=last_day( add_months(sysdate,-5) )
order by  movie_sold_date  asc)
group by extract(month from  movie_sold_date )
order by extract(month from  movie_sold_date ) asc ;

select extract(year from movie_sold_date), count(*) from moviesoldlog
group by extract(year from movie_sold_date)
having 
extract(year from movie_sold_date) <= extract(year from sysdate) and
extract(year from movie_sold_date) >=  (extract(year from sysdate)-4)
order by extract(year from movie_sold_date) asc;
commit;

select viewlog_date , count(*) from viewlog
group by viewlog_date 
having viewlog_date<=sysdate and viewlog_date>=(sysdate-5) order by viewlog_date asc;

select extract(month from viewlog_date ) ,sum(count) from 
(select  viewlog_date  ,count(*) as count from viewlog
group by viewlog_date
having viewlog_date  <=last_day(sysdate) and viewlog_date >=last_day( add_months(sysdate,-5) )
order by  viewlog_date  asc)
group by extract(month from  viewlog_date )
order by extract(month from  viewlog_date ) asc ;

select extract(year from viewlog_date), count(*) from viewlog
group by extract(year from viewlog_date)
having 
extract(year from viewlog_date) <= extract(year from sysdate) and
extract(year from viewlog_date) >=  (extract(year from sysdate)-4)
order by extract(year from viewlog_date) asc;
commit;

select watchlog_date , count(*) from watchlog
group by watchlog_date
having watchlog_date<=sysdate and watchlog_date>=(sysdate-5) order by watchlog_date asc;

select extract(month from watchlog_date ) ,sum(count) from 
(select  watchlog_date  ,count(*) as count from watchlog
group by watchlog_date
having watchlog_date  <=last_day(sysdate) and watchlog_date >=last_day( add_months(sysdate,-5) )
order by  watchlog_date  asc)
group by extract(month from  watchlog_date )
order by extract(month from  watchlog_date ) asc ;

select extract(year from watchlog_date), count(*) from watchlog
group by extract(year from watchlog_date)
having 
extract(year from watchlog_date) <= extract(year from sysdate) and
extract(year from watchlog_date) >=  (extract(year from sysdate)-4)
order by extract(year from watchlog_date) asc;
commit;

select count(*) from
(select movie_purchase_date from movie
group by movie_purchase_date
having movie_purchase_date >=last_day( add_months(sysdate,-2) )
and movie_purchase_date<= add_months(sysdate,-1) 
order by movie_purchase_date asc)
group by extract(month from movie_purchase_date)
order by extract(month from movie_purchase_date) asc;

select count(*) from
(select movie_purchase_date from movie
where movie_purchase_date >=last_day( add_months(sysdate,-1) )
and movie_purchase_date<=sysdate )
group by extract(month from movie_purchase_date)
order by extract(month from movie_purchase_date) asc;

select sum(movie_copyright_cost) from
(select movie_copyright_cost from movie 
where movie_purchase_date >=last_day( add_months(sysdate,-2) )
and movie_purchase_date<=add_months(sysdate,-1) );

select sum(movie_copyright_cost) from
(select movie_copyright_cost from movie 
where movie_purchase_date >=last_day( add_months(sysdate,-1) )
and movie_purchase_date<= sysdate );

select sum(movie_investment) from
(select movie_investment from movie 
where movie_purchase_date >=last_day( add_months(sysdate,-2) )
and movie_purchase_date<= add_months(sysdate,-1) );

select sum(movie_investment) from
(select movie_investment from movie 
where movie_purchase_date >=last_day( add_months(sysdate,-1) )
and movie_purchase_date<=sysdate );