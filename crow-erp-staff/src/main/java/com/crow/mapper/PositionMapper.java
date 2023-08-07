package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.Position;
import org.apache.ibatis.annotations.*;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:PositionMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/6 16:27
 * @Role
 */
@Mapper
public interface PositionMapper {
    /**
     * 添加部门
     * @param position
     * @return
     */
    @Insert("insert into sys_position(plevel,psalary,position) values (#{plevel},#{psalary},#{position})")
    Boolean insertPosition(Position position);

    @Update({
            "<script>",
            "update sys_position",
            "<set>",
            "updated=now()",
            "<if test='plevel'>, plevel=#{plevel}</if>",
            "<if test='psalary'>, psalary=#{psalary}</if>",
            "<if test='position'>, position=#{position}</if>",
            "</set>",
            "where pid = #{pid}",
            "</script>"
    })
    Boolean updateDepatment(Position position);

    /**
     * 高级条件分页查询
     * @param page
     * @param position
     * @return
     */
    @Select({
            "<script>",
            "select * from sys_position",
            "<where>",
            "<if test='position.plevel'>dname like  concat('%',#{position.plevel},'%')</if>",
            "<if test='position.psalary'>or position like  concat('%',#{position.psalary},'%')</if>",
            "<if test='position.position'>or duty like concat('%',#{position.position},'%')</if>",
            "</where> order by updated desc",
            "</script>"
    })
    IPage<Department> pagePosition(IPage page, @Param("position") Position position);
}
