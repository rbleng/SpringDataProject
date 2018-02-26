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

3) 开发JDBCUtil工具类
获取Connection, 关闭Connection, Statement, ResultSet

注意事项: 配置的属性放在配置文件中, 然后通过代码的方式将配置文件中的数据加载进来即可

4) 建立对象模型, DAO

使用Spring jdbc的方式操作数据库
1) 添加依赖
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jdbc</artifactId>
  <version>4.3.7.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>4.3.7.RELEASE</version>
</dependency>

2) 配置beans.xml

3) 开发spring jdbc版本的query和save方法