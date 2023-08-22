package com.crow.mapper;

import com.crow.model.SysMaterials;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysMaterialsMapper {
    //增加产品物料组成
    @Insert("insert into sys_materials(design,fid,register,designname,type,munit,amount,price,pricesum,status,created,registertime,residual) "+
            "values(#{design},#{fid},#{register},#{designName},#{type},#{munit},#{amount},#{price},#{priceSum},'S001-0',now(),now(),#{amount})")
    Boolean addSysMaterials(SysMaterials sysMaterials);

    //删除产品物料组成
    @Delete("delete from sys_materials where mid=#{mid}")
    Boolean deleteSysMaterialsByMid(Integer mid);

    //修改产品物料组成
    @Update("update sys_materials set design=#{design},designname=#{designName},describer=#{describer}," +
            "type=#{type},pricesum=#{priceSum},amount=#{amount},munit=#{munit},price=#{price} where mid=#{mid}")
    Boolean updateSysMaterials(SysMaterials sysMaterials);

    //根据id查询产品物料组成
    @Select("select * from sys_materials where status='S001-0' and fid=#{fid}")
    List<SysMaterials> selectSysMaterialsByMid(Integer fid);

    //查询所有产品物料组成
    @Select("select * from sys_materials")
    List<SysMaterials> selectSysMaterialsList();

    //根据 fid 查询物料
    @Select("select * from sys_materials where fid=#{fid}")
    List<SysMaterials> selectSysMaterialsByFid(Integer fid);
}
