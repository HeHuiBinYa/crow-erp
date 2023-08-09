package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.DepartmentMapper;
import com.crow.model.Department;
import com.crow.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public Boolean insertDepatment(Department department) {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public Boolean deleteDepatment(Integer did) {
        return departmentMapper.deleteDepartment(did);
    }


    @Override
    public Boolean updateDepatment(Department department) {
        return departmentMapper.updateDepatment(department);
    }

    @Override
    public List<Department> selectDepatment() {
        return departmentMapper.selectDepartment();
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
        IPage iPage = departmentMapper.pageDepartment(page, department);
        return iPage;
    }
}
