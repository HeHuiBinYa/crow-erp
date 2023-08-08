package com.crow.mapper;

import com.crow.model.Association;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AssociationMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:36
 * @Role
 */
@Mapper
public interface AssociationMapper {
    @Insert("insert into sys_emp_association(eid,did,pid) values (#{association.employee.eid},#{association.position.pid},#{association.department.did}})")
    Boolean insertAssociation(Association association);
}
