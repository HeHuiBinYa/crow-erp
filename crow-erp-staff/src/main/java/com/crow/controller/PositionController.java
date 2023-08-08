package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.Position;
import com.crow.model.ResultResponse;
import com.crow.service.DepartmentService;
import com.crow.service.PositionService;
import com.crow.utils.RedisUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:PositionMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/6 16:27
 * @Role
 */
@RestController
@RequestMapping("/staff")
public class PositionController {
    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    /**
     * 添加职位
     * @param position
     * @return
     */
    @PostMapping("/increase_position")
    public ResultResponse increase(Position position){
        System.out.println(position);
        if (position.getPlevel().isEmpty()){
            return new ResultResponse("新添加部门职位不能为空!");
        }
        if (position.getPsalary() == null){
            return new ResultResponse("新添加部门职务不能为空");
        }
        if (position.getPosition() == null){
            return new ResultResponse("新添加部门职责不能为空");
        }

        Boolean bool = positionService.insertPosition(position);

        if (bool){
            return new ResultResponse(200,"新部门添加完毕");
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 删除职位
     * @param pid
     * @return
     */
    @PostMapping("/omit_position")
    public ResultResponse edit(Integer pid){
        if (pid != null){
            Boolean bool = positionService.deletePosition(pid);

            if (bool){
                return new ResultResponse(200,"删除部门完毕");
            }
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 修改职位
     * @param position
     * @return
     */
    @PostMapping("/edit_position")
    public ResultResponse edit(Position position){
        if (position.getPlevel().isEmpty()){
            position.setPlevel(null);
        }
        if (position.getPosition().isEmpty()){
            position.setPosition(null);
        }
        if (position.getPsalary() == null){
            position.setPsalary(null);
        }

        Boolean bool = positionService.updatePosition(position);

        if (bool){
            return new ResultResponse(200,"修改部门完毕");
        }

        return new ResultResponse("系统繁忙!");
    }

    /**
     * 分页条件查询
     * @param size
     * @param pageSize
     * @param position
     * @return
     * @throws Exception
     */
    @PostMapping("/page_position")
    public ResultResponse page(Integer size,Integer pageSize,Position position) throws Exception {
        System.out.println(position);
        if (position.getPlevel().isEmpty()){
            position.setPlevel(null);
        }
        if (position.getPosition().isEmpty()){
            position.setPosition(null);
        }
        if (position.getPsalary() == null){
            position.setPsalary(null);
        }
        IPage iPage = positionService.pagePosition(size, pageSize, position);
        return new ResultResponse(iPage);
    }
}
