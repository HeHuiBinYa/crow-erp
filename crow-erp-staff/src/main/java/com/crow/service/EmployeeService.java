package com.crow.service;

import com.crow.model.Employee;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:EmployeeService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:47
 * @Role
 */
public interface EmployeeService {
    Boolean insertEmployee(Employee employee);
    Boolean updateEmployee(Employee employee);
}
