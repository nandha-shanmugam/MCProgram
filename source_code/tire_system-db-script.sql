create table member(id int not null GENERATED ALWAYS AS IDENTITY,username varchar(40) not null,address varchar(60) not null
,state varchar(20) not null,country varchar(20) not null,email varchar(40) not null
,PAN varchar(12) not null,contact varchar(13) null,dob varchar(15) null,created_by varchar(40),created_time timestamp not null
,primary key(id));

insert into member(username,address,state,country,email,pan,contact,dob,created_by,created_time)
values('Nandha','56, Raja street, Erode - 638 187','Tamilnadu','India',
	  'nandha_associate@cognizant.com','ABAPN5678R','9095899914',
	  '21-08-1995','Nandha',now());

create table vehicle(id int not null GENERATED ALWAYS AS IDENTITY,member_id int not null,
name varchar(20) null,type varchar(15) null,
model int null,vin varchar(18) not null,created_by varchar(40),created_time timestamp not null,
primary key(id),constraint fk_member_id foreign key(member_id) references member(id));

  
insert into vehicle(member_id,name,type,model,vin,created_by,created_time) values(1,'Pulsar','two wheeler',2015,
'987654321234567898','Nandha',now());

insert into vehicle(member_id,name,type,model,vin,created_by,created_time) values(1,'Honda City','four wheeler',2019,
'456321678987546321','Nandha',now());

insert into vehicle(member_id,name,type,model,vin,created_by,created_time) values(1,'Apache','two wheeler',2019,
'456321678987546321','Nandha',now());

alter table member add column updated_by varchar(40) not null default 'Nandha',add column updated_time timestamp default now();

alter table vehicle add column updated_by varchar(40) not null default 'Nandha',add column updated_time timestamp default now();


create table orders(id int not null GENERATED ALWAYS AS IDENTITY,member_id int not null,item_name varchar(20) not null,item_type varchar(20) not null,
order_number varchar(50) not null,quantity int not null,services_required varchar(200) not null,created_by varchar(40),created_time timestamp not null,
primary key(id),constraint fk_member_id foreign key(member_id) references member(id));


create table users(id int not null GENERATED ALWAYS AS IDENTITY,username varchar(20) not null,password varchar(200) not null);