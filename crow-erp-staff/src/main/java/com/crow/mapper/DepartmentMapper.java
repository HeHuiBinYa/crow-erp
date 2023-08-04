package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 部门
 * @ClassName:DepattmentMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 9:07
 * @Role
 */
@Mapper
public interface DepartmentMapper {
    /**
     * 添加部门
     * @param department
     * @return
     */
    @Insert("insert into sys_department(dname,position,duty) values (#{dname},#{position},#{duty})")
    Boolean insertDepatment(Department department);

    @Select({
            "<script>",
              "select * from sys_department",
               "<where>",
                  "<if test='department.dname != null'>dname like  concat('%',#{department.dname},'%'})</if>",
                  "<if test='department.position !=  null'>or position like  concat('%',#{department.position},'%'})</if>",
                  "<if test='department.duty != null'>or duty like concat('%',#{department.duty},'%'})</if>",
               "</where>",
            "</script>"
    })
    IPage<Department> pageDepatment(IPage page,@Param("department") Department department);
}
