package com.crow.service.impl;

import com.crow.mapper.EmployeeMapper;
import com.crow.model.Employee;
import com.crow.service.EmployeeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:EmployeeServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:49
 * @Role
 */
@Mapper
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }
}
