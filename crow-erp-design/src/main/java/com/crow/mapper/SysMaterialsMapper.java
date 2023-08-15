package com.crow.mapper;

import com.crow.model.SysMaterials;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysMaterialsMapper {
    //增加产品物料组成
    @Insert("insert into sys_materials(design,fid,designer,register,designname,type,munit,amount,price,pricesum,status,created,registertime) "+
            "values(#{design},#{fid},#{designer},#{register},#{designName},#{type},#{munit},#{amount},#{price},#{priceSum},'S001-0',now(),now())")
    Boolean addSysMaterials(SysMaterials sysMaterials);

    //删除产品物料组成
    @Delete("delete from sys_materials where mid=#{mid}")
    Boolean deleteSysMaterialsByMid(Integer mid);

    //修改产品物料组成
    @Update("update sys_materials set design=#{design},fid=#{fid},designer=#{designer}," +
            "register=#{register},registertime=#{registerTime},checker=#{checker}," +
            "status=#{status},designname=#{designName},type=#{type},describer=#{describer}," +
            "munit=#{munit},amount=#{amount},residual=#{residual},price=#{price}," +
            "pricesum=#{priceSum},created=#{created},updated=#{updated} where mid=#{mid}")
    Boolean updateSysMaterials(SysMaterials sysMaterials);

    //根据id查询产品物料组成
    @Select("select * from sys_materials where status='S001-0' and fid=#{fid}")
    List<SysMaterials> selectSysMaterialsByMid(Integer fid);

    //查询所有产品物料组成
    @Select("select * from sys_materials")
    List<SysMaterials> selectSysMaterialsList();
}
