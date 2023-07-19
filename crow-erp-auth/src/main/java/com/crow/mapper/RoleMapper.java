package com.crow.mapper;

import com.crow.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:RoleMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/18 14:27
 * @Role
 */
@Mapper
public interface RoleMapper {
    @Select("select * from SYS_ROLE")
    List<Role> selectRoleList();
}
