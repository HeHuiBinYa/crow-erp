package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroB;
import com.crow.model.SysHeroC;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysHeroCMapper {

    //添加三级分类
    @Insert("insert into sys_heroC(bid,cname,created) values(#{bid},#{cName},now())")
    Boolean addSysHeroC(SysHeroC sysHeroC);

    //修改三级分类
    @Update("update sys_heroC set cname=#{cName},updated=now(),bid=#{bid} where cid=#{cid}")
    Boolean updateSysHeroC(SysHeroC sysHeroC);

    //根据编号查询三级分类
    @Select("select * from sys_heroC where bid=#{bid}")
    List<SysHeroC> selectSysHeroCByCid(Integer bid);

    @Select("select * from sys_heroC where cid=#{cid}")
    SysHeroC selectSysHeroCByCidc(Integer cid);

    //删除三级分类
    @Delete("delete from sys_heroC where cid=#{cid}")
    Boolean deleteSysHeroCByCid(Integer cid);

    //查询所有三级分类
    @Select("select * from sys_heroC")
    List<SysHeroC> selectSysHeroCList();

    @Select("select cid,cname,created,updated,bid from sys_heroC c inner join sys_heroB b on c.bid =b.bid inner join sys_heroA a on b.aid=a.aid where a.aid=#{aid}")
    List<SysHeroC> selectSysHeroCUseAid(Integer aid);

    @Select("select cid,cname,created,updated,bid from sys_heroC inner join sys_heroB on c.bid=b.bid where b.bid=#{bid}")
    List<SysHeroC> selectSysHeroCUseBid(Integer bid);

    @Select({
            "<script>",
            "select * from sys_heroC",
            "<where>",
            "<if test='cname'>cname like concat('%',#{cname},'%')</if>",
            "</where>",
            "</script>"
    })
    IPage<SysHeroC> pageSysHeroC(IPage page, @Param("cname") String cname);
}
