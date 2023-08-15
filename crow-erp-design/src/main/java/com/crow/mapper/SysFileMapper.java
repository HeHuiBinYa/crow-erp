package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysFileMapper {

    //添加产品档案
    @Insert("insert into sys_file(pid,register,name,aid,bid,cid,type,unit,grou,checktag,costprice,listprice,descr,created) " +
            "values(#{pid},#{register},#{name},#{aid},#{bid},#{cid}," +
            "#{type},#{unit},#{grou},#{checkTag},#{costPrice},#{listPrice},#{descr},now())")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty = "fid",before = false,resultType = Integer.class)
    Boolean addSysFile(SysFile sysFile);

    //根据fid删除产品档案
    @Delete("delete from sys_file where fid=#{fid}")
    Boolean deleteSysFileByFid(Integer fid);

    //修改产品档案
    @Update("update sys_file set pid=#{pid},name=#{name},descr=#{descr}," +
            "aid=#{aid},bid=#{bid},cid=#{cid},type=#{type},unit=#{unit}," +
            "grou=#{grou},costprice=#{costPrice},listprice=#{listPrice}," +
            "register=#{register},checker=#{checker},checktime=#{checkTime}," +
            "checktag=#{checkTag},created=#{created},updated=#{updated} where" +
            "fid=#{fid}")
    Boolean updateSysFile(SysFile sysFile);

    //更据id查询产品档案
    @Select("select * from sys_file where fid=#{fid}")
    SysFile selectSysFileByFid(Integer fid);

    //查询所有商品档案
    @Select("select * from sys_file")
    List<SysFile> selectSysFileList();

    /**
     * 审核分页
     * @param iPage
     * @return
     */
    @Select("select * from sys_file where checktag='S001-0'")
    @Results(id = "sysFileOnSysMaterialsMap",value = {
            @Result(property = "fid",column = "fid"),
            @Result(property = "materials",column = "fid",many = @Many(select = "com.crow.mapper.SysMaterialsMapper.selectSysMaterialsByMid"))
    })
    IPage<SysFile> queryPageSysFile(IPage iPage);

    @Update("update sys_file set checker=#{checker},checktime=now(),checktag=#{checkTag},updated=now() where fid=#{fid}")
    Boolean examineSysFile(SysFile sysFile);
}
