create table gogek(
gobun number(3),
goname varchar2(25),
gotel varchar2(34),
gojumin varchar2(14) not null,
godam number(3),
constraint gogek_gobun_pk primary key(gobun),
constraint gogek_gojumin_uq unique(gojumin),
constraint gogek_godam_sabun_fk foreign key(godam)
references sawon(sabun)
);
--pk:gobun
--unique,not null:jimin
--foreign key godam-> sawon.sabun