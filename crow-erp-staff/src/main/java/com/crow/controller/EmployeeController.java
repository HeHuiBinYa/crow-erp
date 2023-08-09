package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Association;
import com.crow.model.Employee;
import com.crow.model.ResultResponse;
import com.crow.model.vo.EmployeeVo;
import com.crow.service.AssociationService;
import com.crow.service.EmployeeService;
import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:EmployeeController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:50
 * @Role
 */
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
    public ResultResponse insertEmployee(@Valid Employee employee,Integer did,Integer pid){
        System.out.println(employee);
        System.out.println(did+" "+pid);

        Boolean bool = false;
        bool = employeeService.insertEmployee(employee);

        System.out.println(employee);
        Association association = new Association();

        if (bool){
            association.getEmployee().setEid(employee.getEid());
            association.getPosition().setPid(pid);
            association.getDepartment().setDid(did);
            bool = associationService.insertAssociation(association);

            if (bool){
                return new ResultResponse(200,"添加成功!");
            }
        }

        return new ResultResponse();
    }

    @PutMapping("/edit_association")
    public ResultResponse updatedEmployee(@Valid Employee employee,Integer did,Integer pid){
        System.out.println(employee);
        System.out.println(did+"  "+pid);

        Boolean bool = employeeService.updateEmployee(employee);

        if (bool){
            bool = associationService.updatedAssociation(employee.getEid(),did,pid);
            if (bool){
                return new ResultResponse(200,"修改完毕");
            }
        }

        return new ResultResponse();
    }

    @PostMapping("/page_association")
    public ResultResponse pageAssociation(@Valid EmployeeVo employeeVo){
        System.out.println(employeeVo);
        if (employeeVo.getEname().isEmpty()){
            employeeVo.setEname(null);
        }
        if (employeeVo.getSex().isEmpty()){
            employeeVo.setSex(null);
        }
        if (employeeVo.getTel().isEmpty()){
            employeeVo.setTel(null);
        }
        if (employeeVo.getPlace().isEmpty()){
            employeeVo.setPlace(null);
        }
        if (employeeVo.getState().isEmpty()){
            employeeVo.setState(null);
        }
        if (employeeVo.getPid() == null){
            employeeVo.setPid(null);
        }
        if (employeeVo.getDid() == null){
            employeeVo.setDid(null);
        }
        if (employeeVo.getSizePage() == null){
            employeeVo.setSizePage(null);
        }
        if (employeeVo.getEndAge() == null){
            employeeVo.setEndAge(null);
        }

        System.out.println(employeeVo);
        IPage<Association> page = associationService.pageAssociation(employeeVo);

        if (page != null){
            return new ResultResponse(page);
        }

        return new ResultResponse();
    }
}
