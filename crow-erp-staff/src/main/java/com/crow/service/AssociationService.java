package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Association;
import com.crow.model.vo.EmployeeVo;
import org.apache.ibatis.annotations.Param;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AssociationService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:48
 * @Role
 */
public interface AssociationService {
    IPage<Association> pageAssociation(EmployeeVo employeeVo);
    Boolean insertAssociation(Association association);
    Boolean updatedAssociation(Integer eid,Integer pid,Integer did);
}
