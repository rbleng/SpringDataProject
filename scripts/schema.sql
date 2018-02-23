create table student(
id int not null auto_increment,
name varchar(20) not null,
age int not null,
primary key(id)
);

desc student;

insert into student (name, age) values ("zhangsan",20);
insert into student (name, age) values ("lisi",21);
insert into student (name, age) values ("wangwu",22);

select * from student;