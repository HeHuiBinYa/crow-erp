package com.crow.mapper;

import model.Safetystock;
import model.Warehousing;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/01/11:11
 * @Description:安全库存配置管理
 */
@Mapper
public interface SafetystockMapper {
    /*添加*/
    @Insert("insert into sys_safetystock" +
            "(said,saconf,fid,saname,amount,maxamount,register,registertime,checker,checktime,checktag,created,updated) " +
            "values (#{said},#{saconf},#{fid},#{saname},#{amount},#{maxamount},#{register},#{registertime},#{checker},#{checktime},#{checktag},#{created},#{updated})")
    Boolean insertSafetystock(Safetystock safetystock);

    /*根据id删除*/
    @Delete("delete from sys_safetystock where said=#{said}")
    Boolean deleteSafetystock(@Param("said")Integer said);

    /*根据id修改*/
    @Update("update sys_safetystock " +
            "set saconf=#{saconf},fid=#{fid},saname=#{saname},amount=#{amount},maxamount=#{maxamount},register=#{register},registertime=#{registertime},checker=#{checker},checktime=#{checktime},checktag=#{checktag},created=#{created},updated=#{updated} " +
            "where said=#{said}")
    Boolean updateSafetystock(Safetystock safetystock);

    /*查询所有*/
    @Select("select * from sys_safetystock")
    List<Safetystock> SelectSafetystock();

    /*根据id查询*/
    @Select("select * from sys_safetystock where said=#{said}")
    Safetystock selectOneSafetystock(@Param("said")Integer said);

    /*模糊查询*/
   @Select("select * from sys_safetystock " +
            "where saconf like '%${safetystock.saconf}%' and saname like '%${safetystock.saname}%' and amount between ${firstamount} and ${lastamount} " +
            "and maxamount between ${firstmaxamount} and ${lastmaxamount} and checktag like '%${safetystock.checktag}%' and register like '%${safetystock.register}%' and checker like '%${safetystock.checker}%'")
    List<Safetystock> likeSafetystock(Safetystock safetystock,@Param("firstamount")Double firstamount,@Param("lastamount")Double lastamount,@Param("firstmaxamount")Double firstmaxamount,@Param("lastmaxamount")Double lastmaxamount);

}
