package com.crow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Manufacture;
import com.crow.model.vo.ManufactureVo;
import org.apache.ibatis.annotations.*;

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
    @Insert("insert into sys_manufacture (mafid,manufactureid,maproductid,maproductname," +
            "maamount,madesigner,mamodulecostpricesum,malabourcostpricesum,maproductdescribe,maregistertime,machecktag,manufacturepriceduretag) " +
            "values (#{mafid},#{manufactureid},#{maproductid},#{maproductname},#{maamount},#{madesigner},#{mamodulecostpricesum}," +
            "#{malabourcostpricesum},#{maproductdescribe},now(),'S001-0','S002-0')")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty ="maid",before = false,resultType = Integer.class)
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
            "<if test='manufactureid!=null'>manufactureid=#{manufactureid}</if>",
            "<if test='maproductid!=null'>,maproductid=#{maproductid}</if>",
            "<if test='maproductname!=null'>,maproductname=#{maproductname}</if>",
            "<if test='matesteramount!=null'>,matesteramount=#{matesteramount}</if>",
            "<if test='maproductdescribe!=null'>,maproductdescribe=#{maproductdescribe}</if>",
            "<if test='mamodulecostpricesum!=null'>,mamodulecostpricesum=#{mamodulecostpricesum}</if>",
            "<if test='marealmodulecostpricesum!=null'>,marealmodulecostpricesum=#{marealmodulecostpricesum}</if>",
            "<if test='malabourcostpricesum!=null'>,malabourcostpricesum=#{malabourcostpricesum}</if>",
            "<if test='mareallabourcostpricesum!=null'>,mareallabourcostpricesum=#{mareallabourcostpricesum}</if>",
            "<if test='madesigner!=null'>,madesigner=#{madesigner}</if>",
            "<if test='machecker!=null'>,machecker=#{machecker}</if>",
            "<if test='machecktime!=null'>,machecktime=#{machecktime}</if>",
            "<if test='maremapk!=null'>,maremapk=#{maremapk}</if>",
            "<if test='machecktag!=null'>,machecktag=#{machecktag}</if>",
            "<if test='manufacturepriceduretag!=null'>,manufacturepriceduretag=#{manufacturepriceduretag}</if>",
            "<if test='maamount!=null'>,maamount=#{maamount}</if>",
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

    /**
     * 生产分页审核
     * @param iPage
     * @return
     */
    @Select("select * from sys_manufacture where machecktag='S001-0'")
    @Results(id = "queryPageManufactureMap",value = {
            @Result(id = true,property = "maid",column ="maid"),
            @Result(property = "procedures",column = "maid",many = @Many(select = "com.crow.mapper.ProcedureMapper.selectByMaid"))})
    Page<Manufacture> queryPageManufacture(IPage iPage);

    /**
     * 审核 失败 通过
     * @param manufacture
     * @return
     */
    @Update("update sys_manufacture set machecktag=#{machecktag},machecker=#{machecker},machecktime=now(),manufacturepriceduretag='S002-1' where maid=#{maid}")
    Boolean updateExamine(Manufacture manufacture);

    /**
     * 生产分页审核
     * @param iPage
     * @return
     */
    @Select("select * from sys_manufacture where machecktag='S001-1' and manufacturepriceduretag='S002-1'")
    Page<Manufacture> queryPageManufactureFinished(IPage iPage);

    /**
     * 完工
     * @param manufacture
     * @return
     */
    @Update("update sys_manufacture set matesteramount=#{matesteramount},marealmodulecostpricesum=#{marealmodulecostpricesum},mareallabourcostpricesum=#{mareallabourcostpricesum},maremapk=#{maremapk},manufacturepriceduretag='S002-2' where maid=#{maid}")
    Boolean manufactureComplete(Manufacture manufacture);

    @Select({
            "<script>",
              "select * from sys_manufacture",
               "<where>",
                 "<if test='manufactureVo.manufactureid'>manufactureid like concat('%',#{manufactureVo.manufactureid},'%')</if>",
                 "<if test='manufactureVo.maproductid'>or maproductid like concat('%',#{manufactureVo.maproductid},'%')</if>",
                 "<if test='manufactureVo.maproductname'>or maproductname like concat('%',#{manufactureVo.maproductname},'%')</if>",
                 "<if test='manufactureVo.madesigner'>or madesigner like concat('%',#{manufactureVo.madesigner},'%')</if>",
                 "<if test='manufactureVo.machecker'>or machecker like concat('%',#{manufactureVo.machecker},'%')</if>",

                 "<if test='manufactureVo.startMaamount != null and manufactureVo.endMaamount == null'>and maamount &gt;= #{manufactureVo.startMaamount}</if>",
                 "<if test='manufactureVo.startMaamount == null and manufactureVo.endMaamount != null'>and maamount &lt;= #{manufactureVo.endMaamount}</if>",
                 "<if test='manufactureVo.startMaamount != null and manufactureVo.endMaamount != null'>and maamount &gt;= #{manufactureVo.startMaamount} and maamount &lt;= #{manufactureVo.endMaamount}</if>",

                 "<if test='manufactureVo.startMatesteramount != null and manufactureVo.endMatesteramount == null'>and matesteramount &gt;= #{manufactureVo.startMatesteramount}</if>",
                 "<if test='manufactureVo.startMatesteramount == null and manufactureVo.endMatesteramount != null'>and matesteramount &lt;= #{manufactureVo.endMatesteramount}</if>",
                 "<if test='manufactureVo.startMatesteramount != null and manufactureVo.endMatesteramount != null'>and matesteramount &gt;= #{manufactureVo.startMatesteramount} and matesteramount &lt;= #{manufactureVo.endMatesteramount}</if>",

                 "<if test='manufactureVo.machecktag'>and machecktag = #{manufactureVo.machecktag}</if>",
                 "<if test='manufactureVo.manufacturepriceduretag'>and manufacturepriceduretag = #{manufactureVo.manufacturepriceduretag}</if>",
               "</where>",
            "</script>"
    })
    @Results(id = "queryManufactureVoMap",value = {
            @Result(property = "maid",column = "maid"),
            @Result(property = "procedures",column = "maid",many = @Many(select = "com.crow.mapper.ProcedureMapper.selectByMaid"))
    })
    IPage<Manufacture> queryManufactureVo(IPage iPage,@Param("manufactureVo") ManufactureVo manufactureVo);
}
