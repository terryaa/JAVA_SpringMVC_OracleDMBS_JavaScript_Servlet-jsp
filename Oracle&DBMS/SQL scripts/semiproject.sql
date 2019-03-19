drop table member;
commit;

insert into movie (movie_number, movie_price ) values (100,1);
insert into member (member_number,member_id) values (1,'terryaa');
insert into member (member_number,member_id) values (2,'terryaaaa');
insert  into watchlog values(1,100,1,sysdate);
insert  into watchlog values(2,100,1,'19/03/17');
insert  into watchlog values(3,100,1,'19/03/16');
insert  into watchlog values(4,100,1,'19/03/15');
insert  into watchlog values(5,100,1,'19/03/14');

select count (*) from watchlog where watchlog_date like sysdate;
select count (*) from watchlog ;

alter table member add member_join_date DATE ;


insert  into viewlog values(1,100,1,sysdate);
insert  into viewlog values(2,100,1,'19/03/17');
insert  into viewlog values(3,100,1,'19/03/16');
insert  into viewlog values(4,100,1,'19/03/15');
insert  into viewlog values(5,100,1,'19/03/14');
insert  into viewlog values(6,100,1,'19/03/13');

insert  into loginlog values(1,1,sysdate,sysdate);
insert  into loginlog values(2,1,'19/03/16','19/03/16');
insert  into loginlog values(3,1,'19/03/15','19/03/15');
insert  into loginlog values(4,1,'19/03/14','19/03/14');
insert  into loginlog values(5,1,'19/03/13','19/03/13');
insert  into loginlog values(6,1,'19/03/13','19/03/12');
insert  into loginlog values(7,1,'19/03/13','19/03/11');
insert  into loginlog values(9,1,'19/03/17','19/03/17');
insert  into loginlog values(11,1,'19/03/19','19/03/19');
insert  into loginlog values(12,1,'19/03/18','19/03/19');

insert  into moviesoldlog values(1,1,100,1,sysdate);
insert  into moviesoldlog values(2,1,100,1,'19/03/16');
insert  into moviesoldlog values(3,1,100,1,'19/03/15');
insert  into moviesoldlog values(4,1,100,1,'19/03/14');
insert  into moviesoldlog values(5,1,100,1,'19/03/13');
insert  into moviesoldlog values(6,1,100,1,'19/03/12');
insert  into moviesoldlog values(7,1,100,1,'19/03/11');
insert  into moviesoldlog values(8,1,100,1,'19/03/10');

select movie_sold_date from moviesoldlog where movie_sold_date<=sysdate and movie_sold_date>= (sysdate-5); 


commit;
select loginglog_login, count(*) from loginlog where loginglog_login = (select loginglog_login from loginlog
where loginglog_login<=sysdate and loginglog_login>=(sysdate-5) ) group by loginglog_login;

select loginglog_login, count(*) from loginlog
group by loginglog_login 
having loginglog_login<=sysdate and loginglog_login>=(sysdate-10) order by loginglog_login desc  ;
delete from loginlog where loginlog_number=1;
commit;