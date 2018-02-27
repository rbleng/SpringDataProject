package com.imooc.repository;


import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import javax.persistence.ManyToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Repository接口是Spring Data的核心接口，不提供任何方法
 * public interface Repository<T,ID extends Serializable>{}
 * 范型参数T表示对哪个实体类进行处理，ID表示T指代的实体类的id的类型
 *
 * 可以继承Repository类，也可以通过RepositoryDefinition注解的方式
 *
 * Repository
 * Repository Query Specifications
 * RepositoryDefinition
 * Query Annotation
 * Update/Delete/Transaction
 */
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository {  //extends Repository<Employee, Integer> {

    public Employee findByName(String name);

    //where name like ?% and age <?
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    //where name like %? and age <?
    public List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    //where name in (?,?......) or age <?
    public List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    //where name in (?,?......) And age <?
    public List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

//    @Query("select o from Employee o where id=(select max(id) from Empolyee t1)")
//    public Employee getEmployeeByMaxId();

    //使用占位符的方式
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name, Integer age);

    //使用命名参数的方式
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public List<Employee> queryParams2(@Param("name")String name, @Param("age")Integer age);

    //使用占位符的方式
    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);

    //使用命名参数的方式
    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike2(@Param("name")String name);

    //原生态的查询
    @Query(nativeQuery = true, value="select count(1) from employee")
    public long getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    public void update(@Param("id") Integer id, @Param("age") Integer age);
}

/*===============================================================================
1.Repository Hierarchy 结构体系图
    CrudRepository    内置写好的save、update、delete等方法
    PagingAndSortingRespository    分页和排序
    JpaRepository
    JpaSpecificationExecutor    其他的jpa的特殊操作


 ===============================================================================*/