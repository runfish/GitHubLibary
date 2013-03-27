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

create table customer(
customer_id int primary key,
customer_name varchar2(30) unique not null,
customer_password varchar2(20) not null,
customer_real_name varchar2(20),
customer_birthday date,
customer_mail varchar2(30),
customer_tel varchar2(30) not null,
customer_address varchar2(150) not null,
customer_postcode varchar2(20) not null,
customer_freeze int not null
customer_member int not null,
);

create table deal(
DEAL_ID           INTEGER PRIMARY KEY,                                                                                                                                                                                           
DEAL_CUSTOMER_ID  INTEGER not null,                                                                                          
CONSIGNEE_INFO    VARCHAR2(80),                         
PAY_PATTERN       VARCHAR2(5),                         
RECEIVE_PATTERN   VARCHAR2(5),
item_amount       int,   
is_accept    int,                       
constraint FK_CUSTOMER_ID foreign key (deal_customer_id) references customer(customer_id)    
);
/*订单条目*/
create table deal_item(
 item_id int primary key,
 item_goods_qty int not null,
 item_goods_price number(8,2) not null,
 goods_id int not null,
 deal_status varchar2(5) default 'a',
 goods_ctg_id int not null,
 deal_id int not null,
 admin_id int not null,
 deal_receive_name varchar2(10),
 deal_date date not null,
 deal_exam_date date,
 constraint FK_ITEM_GOODS FOREIGN KEY (goods_id) references goods(goods_id),
 constraint FK_ITEM_DEAL FOREIGN KEY(deal_id)  references deal(deal_id),
 constraint FK_ITEM_CTG_ID foreign key (goods_ctg_id) references small_category (s_ctg_id)
);
create sequence seq_small_ctgid;
create sequence seq_customer;
create sequence seq_category;
create sequence seq_goods;
create sequence seq_dealItem;