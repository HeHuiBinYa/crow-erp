package com.crow.mapper;

import com.crow.model.Scheduling;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:SchedulingMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/17 17:17
 * @Role
 */
@Mapper
public interface SchedulingMapper {
    @Insert("insert into sys_scheduling(scproductid,scproductname,scamount,scamountunit,scubtotal,scgatheredamount,sccostprice,waid,scgathertag) " +
            "values (#{scproductid},#{scproductname},#{scamount},#{scamountunit},#{scubtotal},#{scgatheredamount},#{sccostprice},#{waid},'K002-1')")
    Boolean insertScheduling(Scheduling scheduling);

    @Select("select * from sys_scheduling where waid=#{waid}")
    @Results(id = "querySchedulingByIdMap",value = {
            @Result(property = "scid",column = "scid"),
            @Result(property = "dispatchs",column = "scid",many = @Many(select = "com.crow.mapper.DispatchMapper.selectDispatch"))
    })
    List<Scheduling> querySchedulingByID(Integer waid);

    @Update("update sys_scheduling set scamount=(scamount-#{total}) where scid=#{scid}")
    Boolean updateSchedulingByScamount(@Param("total") Integer total,@Param("scid")  Integer scid);
}
