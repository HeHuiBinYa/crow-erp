package com.crow.controller;

import com.crow.model.Association;
import com.crow.model.Employee;
import com.crow.model.ResultResponse;
import com.crow.service.AssociationService;
import com.crow.service.EmployeeService;
import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
@RefreshScope
@RestController
@RequestMapping("/staff")
public class EmployeeController {
    private EmployeeService employeeService;
    private AssociationService associationService;

    @Value("${odd_numbers.staff}")
    private String staff;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AssociationService associationService) {
        this.employeeService = employeeService;
        this.associationService = associationService;
    }

    @GetMapping("/employee_id")
    public ResultResponse employee_id(){
        return new ResultResponse(200,false,"请求成功",StringUtils.odd_numbers(staff));
    }

    @PostMapping("increase_association")
    public ResultResponse insertEmployee(@Valid Employee employee,Integer did,Integer pid, BindingResult br){
        System.out.println(employee);
        System.out.println(br.hasErrors());
        System.out.println(did+"  "+pid);
        if (br.hasErrors()){
            return new ResultResponse(br.getAllErrors().get(0).getDefaultMessage());
        }


//        Boolean bool = false;
//        bool = employeeService.insertEmployee(association.getEmployee());
//
//        if (bool){
//            bool = associationService.insertAssociation(association);
//            if (bool){
//                return new ResultResponse(200,"添加成功!");
//            }
//        }

        return new ResultResponse();
    }

}
