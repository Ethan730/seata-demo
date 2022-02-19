drop database seata;

CREATE DATABASE IF NOT EXISTS seata DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use seata;

create table `order`(
                        id int(11) primary key ,
                        number int(11)
);

create table `account`(
                          id int(11) primary key ,
                          money int(11)
);

insert into `order`(id, number) values(1, 10);
insert into `account`(id, money) values(1, 100);