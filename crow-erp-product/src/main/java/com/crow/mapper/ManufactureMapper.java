package com.crow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crow.model.Manufacture;
import com.crow.model.Procedure;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lx
 */
@Mapper
public interface ManufactureMapper extends BaseMapper<Manufacture> {

    /**
     * 添加
     * @param manufacture
     * @return
     */
    @Insert("insert into sys_manufacture (manufactureid,maproductid,maproductname,maamount,matesteramount,maapplyidgroup," +
            "maproductdescribe,mamodulecostpricesum,marealmodulecostpricesum,malabourcostpricesum,mareallabourcostpricesum," +
            "madesigner,maregister,maregistertime,machecker,machecktime,maremapk,machecktag,manufacturepriceduretag) values (#{manufactureid},#{maproductname}," +
            "#{maamount},#{matesteramount},#{maapplyidgroup},#{maproductdescribe},#{mamodulecostpricesum},#{marealmodulecostpricesum}," +
            "#{marealmodulecostpricesum},#{malabourcostpricesum},#{mareallabourcostpricesum},#{madesigner},#{maregister},#{maregistertime}," +
            "#{machecker},#{machecktime},#{maremapk},'S001-0','S002-0')")
    Boolean insertManufacture(Manufacture manufacture);

    /**
     * 动态修改
     *
     * @param manufacture
     * @return
     */
    @Update({"<script>",
            "update sys_manufacture ",
            "<set>",
            "<if test='#{manufactureid}!=null'>manufactureid=#{manufactureid}</if>",
            "<if test='#{maproductid}!=null'>,maproductid=#{maproductid}</if>",
            "<if test='#{maproductname}!=null'>,maproductname=#{maproductname}</if>",
            "<if test='#{matesteramount}!=null'>,matesteramount=#{matesteramount}</if>",
            "<if test='#{maapplyidgroup}!=null'>,maapplyidgroup=#{maapplyidgroup}</if>",

            "<if test='#{maproductdescribe}!=null'>,maproductdescribe=#{maproductdescribe}</if>",
            "<if test='#{mamodulecostpricesum}!=null'>,mamodulecostpricesum=#{mamodulecostpricesum}</if>",
            "<if test='#{marealmodulecostpricesum}!=null'>,marealmodulecostpricesum=#{marealmodulecostpricesum}</if>",
            "<if test='#{malabourcostpricesum}!=null'>,malabourcostpricesum=#{malabourcostpricesum}</if>",
            "<if test='#{mareallabourcostpricesum}!=null'>,mareallabourcostpricesum=#{mareallabourcostpricesum}</if>",

            "<if test='#{madesigner}!=null'>,madesigner=#{madesigner}</if>",
            "<if test='#{maregister}!=null'>,maregister=#{maregister}</if>",
            "<if test='#{maregistertime}!=null'>,maregistertime=#{maregistertime}</if>",
            "<if test='#{machecker}!=null'>,machecker=#{machecker}</if>",
            "<if test='#{machecktime}!=null'>,machecktime=#{machecktime}</if>",

            "<if test='#{maremapk}!=null'>,maremapk=#{maremapk}</if>",
            "<if test='#{machecktag}!=null'>,machecktag=#{machecktag}</if>",
            "<if test='#{manufacturepriceduretag}!=null'>,manufacturepriceduretag=#{manufacturepriceduretag}</if>",
            "<if test='#{maamount}!=null'>,maamount=#{maamount}</if>",
            "</set>",
            "where  maid=#{maid}",
             "</script>"})
    Boolean updateManufacture(Manufacture manufacture);

    /**
     * 通过生产总表id修改审核状态
     * @param id
     * @param machecktag
     * @return
     */
    @Update("update sys_manufacture set machecktag=#{machecktag} where  maid=#{id}")
    Boolean updatemachecktagById(Integer id, String machecktag);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("delete from sys_manufacture where maid=#{id}")
    Boolean deleteManufactureById(@Param("id") Integer id);


    /**
     * 查询
     * @return
     */
    @Select("select * from sys_manufacture ")
    List<Manufacture> selectAllManufacture();

    /**通过产品id查询生产总表和工序
     *
     * @param id
     * @return
     */
    @Select("select * from sys_manufacture where maproductid=#{id}")
    @Results(id = "map",value = {
            @Result(id = true,property = "maid",column ="maid"),
            @Result(property = "procedures",column ="maid",
            many =@Many(select = "com.crow.mapper.ProcedureMapper.selectByMaid")),
    })
    Manufacture selectAllManufactureByMapId(String id);



    /**
     * id查询
     *
     * @param id
     * @return
     */
    @ResultMap("map")
    @Select("select * from sys_manufacture where maid=#{id}")
    Manufacture selectManufactureById(@Param("id") Integer id);




}
