/*DROP SCHEMA if exists cake_manager_schema;
CREATE SCHEMA cake_manager_schema;
drop table if exists cakes;
create table cakes
(
    id        int primary key AUTO_INCREMENT,
    name      varchar(50) not null,
    cake_type varchar(20) not null
);

drop table if exists client_info;
create table client_info
(
    id            int AUTO_INCREMENT primary key,
    name          varchar(50) not null,
    address       varchar(100),
    email_address varchar(50),
);

drop table if exists client_cake;
create table client_cake
(
    id        int AUTO_INCREMENT primary key,
    cake_id   int foreign key references cakes(id), ,
    client_id int foreign key references client_info(id),
);

*/