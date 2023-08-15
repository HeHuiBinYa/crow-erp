package com.crow.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Procedure;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lx
 */
@Mapper
public interface ProcedureMapper extends BaseMapper<Procedure> {
    /**
     * 添加
     * @param procedure
     * @return
     */
    @Insert(value = "insert into sys_procedure (prdetailsnumber," +
            "prprocedureid,procedurename,prlabourhouramount," +
            "prreallabourhouramount,prsubtotal,prrealsubtotal," +
            "prmodulesubtotal,prrealmodulesubtotal,prcostprice," +
            "prdemandamount,prrealamount,procedurefinishtag," +
            "proceduretransfertag) " +
            "values (#{prdetailsnumber},#{prprocedureid}," +
            "#{procedurename},#{prlabourhouramount}," +
            "#{prreallabourhouramount},#{prsubtotal}," +
            "#{prrealsubtotal},#{prmodulesubtotal}," +
            "#{prrealmodulesubtotal},#{prcostprice}," +
            "#{prdemandamount},#{prrealamount}," +
            "#{procedurefinishtag},#{proceduretransfertag})")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty ="maid",before = false,resultType = Integer.class)
    Boolean insertProcedure(Procedure procedure);



    /**
     * 修改
     * @param procedure
     * @return
     */
    @Update({"<script>",
            "update sys_procedure ",
            "<set>",
            "<if test='#{prdetailsnumber}!=null'>prdetailsnumber=#{prdetailsnumber}</if>",
            "<if test='#{prprocedureid}!=null'>,prprocedureid=#{prprocedureid}</if>",
            "<if test='#{procedurename}!=null'>,procedurename=#{procedurename}</if>",
            "<if test='#{prlabourhouramount}!=null'>,prlabourhouramount=#{prlabourhouramount}</if>",
            "<if test='#{prreallabourhouramount}!=null'>,prreallabourhouramount=#{prreallabourhouramount}</if>",

            "<if test='#{prsubtotal}!=null'>,prsubtotal=#{prsubtotal}</if>",
            "<if test='#{prrealsubtotal}!=null'>,prrealsubtotal=#{prrealsubtotal}</if>",
            "<if test='#{prmodulesubtotal}!=null'>,prmodulesubtotal=#{prmodulesubtotal}</if>",
            "<if test='#{prrealmodulesubtotal}!=null'>,prrealmodulesubtotal=#{prrealmodulesubtotal}</if>",
            "<if test='#{prcostprice}!=null'>,prcostprice=#{prcostprice}</if>",

            "<if test='#{prdemandamount}!=null'>,prdemandamount=#{prdemandamount}</if>",
            "<if test='#{prrealamount}!=null'>,prrealamount=#{prrealamount}</if>",
            "<if test='#{procedurefinishtag}!=null'>,procedurefinishtag=#{procedurefinishtag}</if>",
            "<if test='#{proceduretransfertag}!=null'>,proceduretransfertag=#{proceduretransfertag}</if>",
            "<if test='#{maid}!=null'>,maid=#{maid}</if>",

            "</set>",
            "where  prid=#{prid}",
            "</script>"})
    Boolean updateProcedure(Procedure procedure);

    /**
     * 通过id修改审核状态
     * @param prid
     * @param procedurefinishtag
     * @return
     */
    @Update("updat sys_procedure set procedurefinishtag=#{procedurefinishtag} where prid=#{prid} ")
    Boolean updateprocedurefinishtagById(Integer prid, String procedurefinishtag);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from  where prid=#{id}")
    Boolean deleteProcedureById(@Param("id") Integer id);

    /**分页查询
     *
     * @param page
     * @return
     */
    @Select("select * from sys_procedure order by prid desc")
    IPage<Procedure> selectAllProcedureByPage(IPage page);

    /**
     * id查询
     * @param id
     * @return
     */
    @Select("select * from sys_procedure where prid=#{id}")
    Procedure selectProcedureById(@Param("id") Integer id);

    /**
     * 生产工序模糊查询
     * @param procedurename
     * @return
     */
    @Select({"<script>",
            "select * from  sys_procedure where  1=1",
            "<if test='procedurename!=null'>and procedurename like #{procedurename}</if>",
            "</script>"})
    List<Procedure> selectLikeProcedureName(String procedurename);

    /**
     * 通过maid查询当前maid下面的所有生产工序
     * @param id
     * @return
     */
    @Select("select * from sys_procedure where maid=#{id}")
    List<Procedure> selectByMaid(@Param("id") Integer id);

}
