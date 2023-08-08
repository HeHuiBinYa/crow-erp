package com.crow.mapper;

import model.Warehousing;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/11:23
 * @Description:入库申请管理
 */
@Mapper
public interface WarehousingMapper {
    /*添加*/
    @Insert("insert into sys_warehousing" +
            "(waid,wagatherid,wastorer,wareason,waamountsum,wacostpricesum,wagatheredamountsum,waremark,waregister,waregistertime,wachecker,wacheckertime,wachecktag,wastoretag,created,updated) " +
            "values" +
            "(#{waid},#{wagatherid},#{wastorer},#{wareason},#{waamountsum},#{wacostpricesum},#{wagatheredamountsum},#{waremark},#{waregister},#{waregistertime},#{wachecker},#{wacheckertime},#{wachecktag},#{wastoretag},#{created},#{updated})")
    Boolean insertWarehousing(WarehousingMapper warehousing);

    /*根据id删除*/
    @Delete("delete from sys_warehousing where waid=#{waid}")
    Boolean deleteWarehousing(@Param("waid")Integer waid);

    /*根据id修改*/
    @Update("update sys_warehousing " +
            "set wagatherid=#{wagatherid},wastorer=#{wastorer},wareason=#{wareason},waamountsum=#{waamountsum},wacostpricesum=#{wacostpricesum},wagatheredamountsum=#{wagatheredamountsum},waremark=#{waremark},waregister=#{waregister},waregistertime=#{waregistertime},wachecker=#{wachecker},wacheckertime=#{wacheckertime},wachecktag=#{wachecktag},wastoretag=#{wastoretag},created=#{created},updated=#{updated} " +
            "where waid=#{waid}")
    Boolean updateWarehousing(Warehousing warehousing);

    /*查询所有*/
    @Select("select * from sys_warehousing")
    List<Warehousing> selectWarehousing();

    /*根据id查询*/
    @Select("select * from sys_warehousing where waid=#{waid}")
    Warehousing selectOneWarehousing(@Param("waid")Integer waid);

}
