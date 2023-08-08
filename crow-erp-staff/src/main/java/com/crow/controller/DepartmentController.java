package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.ResultResponse;
import com.crow.service.DepartmentService;
import com.crow.utils.RedisUtils;
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

    /**
     * 添加部门
     * @param department
     * @return
     */
    @PostMapping("/increase_department")
    public ResultResponse increase(Department department){
        if (department.getDname().isEmpty()){
            return new ResultResponse("新添加部门职位不能为空!");
        }
        if (department.getPosition().isEmpty()){
            return new ResultResponse("新添加部门职务不能为空");
        }
        if (department.getDuty().isEmpty()){
            return new ResultResponse("新添加部门职责不能为空");
        }

        Boolean bool = departmentService.insertDepatment(department);

        if (bool){
            redisUtils.flushDb();
            return new ResultResponse(200,"新部门添加完毕");
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 删除部门
     * @param did
     * @return
     */
    @PostMapping("/omit_department")
    public ResultResponse edit(Integer did){
        if (did != null){
            Boolean bool = departmentService.deleteDepatment(did);

            if (bool){
                redisUtils.flushDb();
                return new ResultResponse(200,"删除部门完毕");
            }
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 修改部门
     * @param department
     * @return
     */
    @PostMapping("/edit_department")
    public ResultResponse edit(Department department){
        if (department.getDname().isEmpty()){
            department.setDname(null);
        }
        if (department.getDuty().isEmpty()){
            department.setDuty(null);
        }
        if (department.getPosition().isEmpty()){
            department.setPosition(null);
        }

        Boolean bool = departmentService.updateDepatment(department);

        if (bool){
            redisUtils.flushDb();
            return new ResultResponse(200,"修改部门完毕");
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 分页条件查询
     * @param size
     * @param pageSize
     * @param department
     * @return
     * @throws Exception
     */
    @PostMapping("/page_department")
    public ResultResponse page(Integer size,Integer pageSize,Department department) throws Exception {
        if (department.getDname().isEmpty()){
            department.setDname(null);
        }
        if (department.getDuty().isEmpty()){
            department.setDuty(null);
        }
        if (department.getPosition().isEmpty()){
            department.setPosition(null);
        }
        IPage iPage = departmentService.pageDepatment(size, pageSize, department);
        return new ResultResponse(iPage);
    }
}