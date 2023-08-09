package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.Position;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    Boolean insertDepartment(Department department);

    @Delete("delete from sys_department where did=#{did}")
    Boolean deleteDepartment(Integer did);

    @Select("select * from sys_department")
    List<Department> selectDepartment();

    @Select("select * from sys_department d inner join sys_emp_association a on p.did=a.did where a.eid = #{eid}")
    List<Position> selectDepartmentMap(Integer eid);

    @Update({
            "<script>",
              "update sys_department",
                "<set>",
                  "updated=now()",
                  "<if test='dname'>, dname=#{dname}</if>",
                  "<if test='position'>, position=#{position}</if>",
                  "<if test='duty'>, duty=#{duty}</if>",
                "</set>",
                "where did = #{did}",
            "</script>"
    })
    Boolean updateDepatment(Department department);

    @Select({
            "<script>",
              "select * from sys_department",
               "<where>",
                  "<if test='department.dname'>dname like  concat('%',#{department.dname},'%')</if>",
                  "<if test='department.position'>or position like  concat('%',#{department.position},'%')</if>",
                  "<if test='department.duty'>or duty like concat('%',#{department.duty},'%')</if>",
               "</where> order by updated desc",
            "</script>"
    })
    IPage<Department> pageDepartment(IPage page,@Param("department") Department department);
}
