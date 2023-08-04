package com.crow.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentServiceImplTest {
    @Autowired
    private DepartmentService departmentService;

    @Test
    void test(){
        IPage iPage1 = departmentService.pageDepatment(0,15, new Department());

        System.out.println(iPage1.getRecords());
    }
}