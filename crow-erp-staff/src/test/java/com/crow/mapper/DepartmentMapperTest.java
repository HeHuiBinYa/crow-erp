package com.crow.mapper;

import com.crow.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void test(){
        Department department = new Department();
        department.setDid(2);
        System.out.println(departmentMapper.updateDepatment(department));
    }
}