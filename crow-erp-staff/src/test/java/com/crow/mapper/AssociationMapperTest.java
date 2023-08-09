package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Association;
import com.crow.model.vo.EmployeeVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssociationMapperTest {
    @Autowired
    private AssociationMapper associationMapper;

    @Test
    void pageAssociationTest(){
        EmployeeVo employeeVo = new EmployeeVo();
        Page page = new Page(2, 2);
        IPage<Association> associationIPage = associationMapper.pageAssociation(page, employeeVo);
        associationIPage.getRecords().forEach(System.out::println);
    }
}