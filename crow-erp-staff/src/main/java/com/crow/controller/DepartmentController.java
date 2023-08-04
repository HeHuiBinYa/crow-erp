package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.ResultResponse;
import com.crow.service.DepartmentService;
import com.crow.utils.RedisUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DepartmentController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 10:02
 * @Role
 */
@Log4j2
@RestController
@RequestMapping("/staff")
public class DepartmentController {
    private DepartmentService departmentService;
    private RedisUtils redisUtils;

    @Autowired
    public DepartmentController(DepartmentService departmentService, RedisUtils redisUtils) {
        this.departmentService = departmentService;
        this.redisUtils = redisUtils;
    }

    @PostMapping("/increase")
    public ResultResponse increase(Department department){
        System.out.println(department);
        if (department.getDname() == null){
            return new ResultResponse("新添加部门职位不能为空!");
        }
        if (department.getPosition() == null){
            return new ResultResponse("新添加部门职务不能为空");
        }
        if (department.getDuty() == null){
            return new ResultResponse("新添加部门职责不能为空");
        }

        Boolean bool = departmentService.insertDepatment(department);

        if (bool){
            return new ResultResponse(200,"新部门添加完毕");
        }

        return new ResultResponse("系统繁忙!");
    }

    @PostMapping("/page")
    public ResultResponse page(Integer size,Integer pageSize,Department department){
        System.out.println(size);
        System.out.println(pageSize);
        System.out.println(department);
        if (redisUtils.exists("department"+size+"-"+pageSize)){
            System.out.println("缓存");
            return new ResultResponse(redisUtils.getKey("department"+size+"-"+pageSize));
        }else{
            IPage iPage = departmentService.pageDepatment(size, pageSize, department);
            redisUtils.seTex("department"+size+"-"+pageSize,iPage,30L);
            return new ResultResponse(iPage);
        }
    }
}