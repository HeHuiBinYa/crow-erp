package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.DepartmentMapper;
import com.crow.model.Department;
import com.crow.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DepartmentServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 9:57
 * @Role
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Boolean insertDepatment(Department department) {
        return departmentMapper.insertDepatment(department);
    }

    @Override
    public IPage pageDepatment(Integer size, Integer pageSize, Department department) {
        if (size <= 0){
            size = 1;
        }
        if (pageSize <= 0){
            pageSize = 1;
        }
        Page<Department> page = new Page<>(size,pageSize);
        IPage iPage = departmentMapper.pageDepatment(page, department);
        return iPage;
    }
}
