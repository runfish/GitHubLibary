

/*大类*/
create table big_category(
 b_ctg_id int primary key,
 b_ctg_name varchar2(30) unique not null,
 b_ctg_status char(1) not null
);

/*小类*/
create table small_category(
 s_ctg_id int primary key,
 s_ctg_name varchar2(30) unique not null,
 s_ctg_status char(1) not null,
 b_ctg_id int not null,
 constraint FK_SMALL_BIG foreign key (b_ctg_id) references big_category(b_ctg_id)
);
create sequence seq_small_ctgid;



create table goods(
goods_id int primary key,
goods_name varchar2(20) unique not null,
goods_price number(6,2) not null,
goods_empty int not null,
goods_desc varchar2(150),
goods_ctg_id int not null,
goods_qty int not null,
goods_admin_id int not null,
goods_image blob,
constraint FK_GOODS_CTG_ID foreign key (goods_ctg_id) references small_category (s_ctg_id)
);