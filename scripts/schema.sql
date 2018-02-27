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


Repository类的定义:
public interface Repository<T, ID extends Serializable> {
}
1)Repository是一个空接口,标记接口,没有包含方法声明的接口
2)如果我们定义的接口EmployeeRepository extends Repository,那么就说明我们定义的接口会被Spring所管理
  如果我们自己的接口没有Extends Repository,运行时会报错:
  org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean
  of type 'com.imooc.repository.EmployeeRepository' available
  没有继承接口就不会被Spring管理
3)添加注解能达到不用extends Repository的功能
  @RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
4)Repository的子接口
  CrudRepository:继承Repository,实现了CRUD相关的方法
  PagingAndSortingRepository:继承CrudRepository,实现了分页排序相关的方法
  JpaRepository:继承PagingAndSortingRepository,实现JPA规范相关的方法

insert into employee (name, age) values ("test1",20);
insert into employee (name, age) values ("test2",21);
insert into employee (name, age) values ("test3",22);
insert into employee (name, age) values ("test4",20);
insert into employee (name, age) values ("test5",21);
insert into employee (name, age) values ("test6",22);
insert into employee (name, age) values ("test16",22);