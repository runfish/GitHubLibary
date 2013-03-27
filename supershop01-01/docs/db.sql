create table customer(
customer_id int primary key,
customer_name varchar2(20) unique not null,
customer_password varchar2(20) not null,
customer_real_name varchar2(20),
customer_birthday date,
customer_mail varchar2(20),
customer_tel varchar2(20) not null,
customer_address varchar2(100) not null,
customer_postcode varchar2(20) not null,
customer_member char(1) not null
);


create table category(
category_id int primary key,
category_name varchar2(20) unique not null,
category_rank int not null
);

create table goods(
goods_id int primary key,
goods_name varchar2(20) unique not null,
goods_price number(6,2) not null,
goods_empty char(1) not null,
goods_desc varchar2(30),
goods_ctg_id int not null,
goods_qty int not null,
goods_admin_id int not null,
goods_image blob,
constraint FK_GOODS_CTG_ID foreign key (goods_ctg_id) references category (category_id),
constraint FK_GOODS_ADMIN_ID foreign key (goods_admin_id) references customer (customer_id)
);

create table order(
order_id int primary key,
order_date date not null,
order_sum number(6,2) not null,
order_goods_qty int not null,
order_goods_id int not null,
order_customer_id int not null,
order_admin_id int not null,
constraint FK_ORDER_ADMIN_ID foreign key (order_admin_id) references goods (goods_admin_id),
constraint FK_ORDER_CUSTOMER_ID foreign key (order_customer_id) references customer (customer_id)
);

create sequence seq_customer;
create sequence seq_category;
create sequence seq_goods;
create sequence seq_order;