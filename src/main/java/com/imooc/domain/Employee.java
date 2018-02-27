package com.imooc.domain;

import javax.persistence.*;

/**
 * 雇员: 先开发实体类===>自动生成数据表
 */
@Entity
@Table(name = "test_employee")
public class Employee {

    @GeneratedValue //自增
    @Id
    private Integer id;

    @Column(length = 20,nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
