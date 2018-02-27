package com.imooc.repository;


import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

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
//@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee, Integer> {

    public Employee findByName(String name);

}

/*===============================================================================
1.Repository Hierarchy 结构体系图
    CrudRepository    内置写好的save、update、delete等方法
    PagingAndSortingRespository    分页和排序
    JpaRepository
    JpaSpecificationExecutor    其他的jpa的特殊操作


 ===============================================================================*/