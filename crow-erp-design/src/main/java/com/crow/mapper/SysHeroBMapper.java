package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroB;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysHeroBMapper {

    //添加二级分类
    @Insert("insert into sys_heroB(aid,bname,created) values(#{aid},#{bName},now())")
    Boolean addSysHeroB(SysHeroB sysHeroB);

    //修改二级分类
    @Update("update sys_heroB set bname=#{bName},updated=now(),aid=#{aid} where bid=#{bid}")
    Boolean updateSysHeroB(SysHeroB sysHeroB);

    //根据编号查询二级分类
    @Select("select * from sys_heroB where aid=#{aid}")
    List<SysHeroB> selectSysHeroBByBid(Integer aid);

    @Select("select * from sys_heroB where bid=#{bid}")
    List<SysHeroB> selectSysHeroBByBidb(Integer bid);

    //删除二级分类
    @Delete("delete from sys_heroB where bid=#{bid}")
    Boolean deleteSysHeroBByBid(Integer bid);

    //查询所有二级分类
    @Select("select * from sys_heroB")
    List<SysHeroB> selectSysHeroBList();

    @Select("select bid,bname,created,updated,aid from sys_heroB b inner join sys_heroA on b.aid=a.aid where a.aid=#{aid}")
    List<SysHeroB> selectSysHeroBUseAid(Integer aid);

    @Select({
            "<script>",
            "select * from sys_heroB",
            "<where>",
            "<if test='bname'>bname like concat('%',#{bname},'%')</if>",
            "</where>",
            "</script>"
    })
    IPage<SysHeroB> pageSysHeroB(IPage page, @Param("bname") String bname);
}
