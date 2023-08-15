package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroA;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysHeroAMapper {
    //添加一级分类
    @Insert("insert into sys_heroA(aname,created) values(#{aName},now())")
    Boolean addSysHeroA(SysHeroA sysHeroA);

    //修改一级分类
    @Update("update sys_heroA set aname=#{aName},updated=now() where aid=#{aid}")
    Boolean updateSysHeroA(SysHeroA sysHeroA);

    //根据编号查询一级分类
    @Select("select * from sys_heroA where aid=#{aid}")
    SysHeroA selectSysHeroAByAid(Integer aid);

    //删除一级分类
    @Delete("delete from sys_heroA where aid=#{aid}")
    Boolean deleteSysHeroAByAid(Integer aid);

    //查询所有一级分类
    @Select("select * from sys_heroA")
    List<SysHeroA> selectSysHeroAList();

    @Select({
            "<script>",
             "select * from sys_heroA",
             "<where>",
              "<if test='aname'>aname like concat('%',#{aname},'%')</if>",
             "</where>",
            "</script>"
    })
    IPage<SysHeroA> pageSysHeroA(IPage page,@Param("aname") String aname);
}
