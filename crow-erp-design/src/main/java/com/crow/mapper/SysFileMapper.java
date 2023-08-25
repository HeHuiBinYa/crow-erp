package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysFile;
import com.crow.model.SysFileVo;
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
    @Select("select * from sys_file where checktag='S001-1'")
    List<SysFile> queryFileList();

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


    @Select({
            "<script>",
              "select * from sys_file",
               "<where>",
                 "<if test='sysFileVo.pid'> pid like concat('%',#{sysFileVo.pid},'%') </if>",
                 "<if test='sysFileVo.name'>or name like concat('%',#{sysFileVo.name},'%') </if>",
                 "<if test='sysFileVo.grou'>or grou like concat('%',#{sysFileVo.grou},'%') </if>",
                 "<if test='sysFileVo.aid'>and aid = #{sysFileVo.aid} </if>",
                 "<if test='sysFileVo.bid'>and bid = #{sysFileVo.bid} </if>",
                 "<if test='sysFileVo.cid'>and cid = #{sysFileVo.cid} </if>",
                 "<if test='sysFileVo.type'>or type like concat('%',#{sysFileVo.type},'%') </if>",
                 "<if test='sysFileVo.unit'>or unit like concat('%',#{sysFileVo.unit},'%') </if>",
                 "<if test='sysFileVo.register'>or register like concat('%',#{sysFileVo.register},'%') </if>",
                 "<if test='sysFileVo.checker'>or checker like concat('%',#{sysFileVo.checker},'%') </if>",

                 "<if test='sysFileVo.startTime == null and sysFileVo.endTime != null'>or checktime &gt;= #{sysFileVo.startTime}</if>",
                 "<if test='sysFileVo.startTime != null and sysFileVo.endTime == null'>or checktime &lt;= #{sysFileVo.endTime} </if>",
                 "<if test='sysFileVo.startTime != null and sysFileVo.endTime != null'>or checktime #{sysFileVo.startTime} between #{sysFileVo.endTime}</if>",

                 "<if test='sysFileVo.startMoney == null and sysFileVo.endMoney != null'>or costprice &gt;= #{sysFileVo.startMoney}</if>",
                 "<if test='sysFileVo.startMoney != null and sysFileVo.endMoney == null'>or costprice &lt;= #{sysFileVo.endMoney} </if>",
                 "<if test='sysFileVo.startMoney != null and sysFileVo.endMoney != null'>or costprice &gt;= #{sysFileVo.startMoney} and costprice &lt;= #{sysFileVo.endMoney}</if>",

                 "<if test='sysFileVo.startMoneys == null and sysFileVo.endMoneys != null'>or listprice &gt;= #{sysFileVo.startMoneys}</if>",
                 "<if test='sysFileVo.startMoneys != null and sysFileVo.endMoneys == null'>or listprice &lt;= #{sysFileVo.endMoneys} </if>",
                 "<if test='sysFileVo.startMoneys != null and sysFileVo.endMoneys != null'>or listprice &gt;= #{sysFileVo.startMoneys} and listprice &lt;= #{sysFileVo.endMoneys}</if>",

                 "<if test='sysFileVo.checktag'>or checktag = #{sysFileVo.checktag} </if>",
               "</where> order by fid desc",
            "</script>"
    })
    @Results(id = "querySysFileVoMap",value = {
            @Result(property = "fid",column = "fid"),
            @Result(property = "materials",column = "fid",many = @Many(select = "com.crow.mapper.SysMaterialsMapper.selectSysMaterialsByFid")),
            @Result(property = "heroA",column = "aid",many = @Many(select = "com.crow.mapper.SysHeroAMapper.selectSysHeroAByAid")),
            @Result(property = "heroB",column = "bid",many = @Many(select = "com.crow.mapper.SysHeroBMapper.selectSysHeroBByBidb")),
            @Result(property = "heroC",column = "cid",many = @Many(select = "com.crow.mapper.SysHeroCMapper.selectSysHeroCByCidc")),
    })
    IPage<SysFile> querySysFileVo(IPage iPage,@Param("sysFileVo") SysFileVo sysFileVo);

    @Update("update sys_file set register=#{register},name=#{name},aid=#{aid},bid=#{bid},cid=#{cid}," +
            "type=#{type},unit=#{unit},grou=#{grou},costPrice=#{costPrice},listPrice=#{listPrice},descr=#{descr},updated=now() where fid=#{fid}")
    Boolean updateFile(SysFile sysFile);

    @Update("update sys_file set checktag='S001-0' where fid=#{fid}")
    Boolean updateCheckTag(Integer fid);
}
