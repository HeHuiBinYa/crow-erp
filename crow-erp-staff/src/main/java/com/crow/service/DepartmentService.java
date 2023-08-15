package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Columnar;
import com.crow.model.Department;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DepartmentService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 9:57
 * @Role
 */
public interface DepartmentService {
    Boolean insertDepatment(Department department);
    Boolean deleteDepatment(Integer did);
    Boolean updateDepatment(Department department);
    List<Department> selectDepatment();
    IPage pageDepatment(Integer size,Integer pageSize, Department department);
    Columnar[] columnarDepartment();
}
