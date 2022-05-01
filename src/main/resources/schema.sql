
DROP SCHEMA if exists cake_manager_schema;
CREATE SCHEMA cake_manager_schema;
/*
drop table if exists client_cake;
create table client_cake
(
    id int primary key,
    cake_id   int references cakes(id),
    client_id int references client_info(id),
);
insert into client_cake (cake_id, client_id) values (1, 1);


drop table if exists cakes;
create table cakes
(
    id        int primary key AUTO_INCREMENT,
    name      varchar(50) not null,
    cake_type varchar(20) not null
);
insert into cakes (name, cake_type) values ('Pineapple Cake', 'Vegan');
insert into cakes (name, cake_type) values ('Pineapple Cheese Cake', 'Vegetarian');
insert into cakes (name, cake_type) values ('Pineapple Cake', 'Eggs');

drop table if exists client_info;
create table client_info
(
    id            int AUTO_INCREMENT primary key,
    name          varchar(50) not null,
    address       varchar(100),
    email_address varchar(50)
);
insert into client_info (name, address, email_address) values ('Zara', 'London', 'zara@email.com' );



*/
