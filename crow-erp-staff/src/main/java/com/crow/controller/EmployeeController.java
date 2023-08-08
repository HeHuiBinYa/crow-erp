package com.crow.controller;

import com.crow.mapper.EmployeeMapper;
import com.crow.model.Association;
import com.crow.model.ResultResponse;
import com.crow.service.AssociationService;
import com.crow.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:EmployeeController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:50
 * @Role
 */
@RestController
@RequestMapping("/staff")
public class EmployeeController {
    private EmployeeService employeeService;
    private AssociationService associationService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AssociationService associationService) {
        this.employeeService = employeeService;
        this.associationService = associationService;
    }

    @PostMapping("increase_association")
    public ResultResponse insertEmployee(Association association){
        Boolean bool = false;
        bool = employeeService.insertEmployee(association.getEmployee());

        if (bool){
            bool = associationService.insertAssociation(association);
            if (bool){
                return new ResultResponse(200,"添加成功!");
            }
        }

        return new ResultResponse();
    }
}
