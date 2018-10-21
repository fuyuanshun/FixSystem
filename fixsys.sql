create database fixsys default character set utf8;
use fixsys;

create table f_admin(
id int primary key auto_increment,
name varchar(30) not null,
password varchar(30) not null
);

create table uinfo(
id int primary key auto_increment,
name varchar(20) not null,
floor varchar(100) not null,
room varchar(100) not null,
phone varchar(30) not null,
info varchar(255) not null,
createDate varchar(200) not null
);

create table user(
id int primary key auto_increment,
name varchar(30) not null,
floor varchar(100) not null,
room varchar(100) not null,
phone varchar(30) not null
);

