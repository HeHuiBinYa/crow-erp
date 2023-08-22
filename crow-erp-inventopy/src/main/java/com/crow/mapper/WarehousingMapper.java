package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Warehousing;
import com.crow.model.WarehousingVo;
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
    @Insert("insert into sys_warehousing(wagatherid,wastorer,wareason,waamountsum,wacostpricesum,wagatheredamountsum,waremark,waregister,waregistertime,created,wachecktag,wastoretag) " +
            "values(#{wagatherid},#{wastorer},#{wareason},#{waamountsum},#{wacostpricesum},#{wagatheredamountsum},#{waremark},#{waregister},now(),now(),'S001-0','K002-1')")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty ="waid",before = false,resultType = Integer.class)
    Boolean insertWarehousing(Warehousing warehousing);

    @Update("update sys_warehousing set wastorer=#{wastorer},waamountsum=#{waamountsum},wacostpricesum=#{wacostpricesum}," +
            "wagatheredamountsum=#{wagatheredamountsum},waregister=#{waregister},wachecker=#{wachecker},updated=now()" +
            "where waid=#{waid} ")
    Boolean updateWarehousingVo(Warehousing warehousing);

    @Update("update sys_warehousing set wachecktag='S001-0' where waid=#{waid}")
    Boolean updateWachecktag(Warehousing warehousing);

    @Update("update sys_warehousing set wachecker=#{wachecker},wacheckertime=now(),wachecktag=#{wachecktag},updated=now() where waid=#{waid}")
    Boolean updateWarehousing(Warehousing warehousing);

    @Select("select * from sys_warehousing where wachecktag='S001-0'")
    @Results(
            id = "examinePageWarehousingMap",value = {
                    @Result(property = "waid",column = "waid"),
                    @Result(property = "schedulings",column = "waid",javaType = List.class,many =
                    @Many(select = "com.crow.mapper.SchedulingMapper.querySchedulingByID"))})
    IPage<Warehousing> examinePageWarehousing(IPage iPage);


    @Select({
            "<script>",
              "select * from sys_warehousing",
                "<where>",
                  "<if test='warehousingVo.wagatherid'> wagatherid like concat('%',#{warehousingVo.wagatherid},'%') </if>",
                  "<if test='warehousingVo.wastorer'> wastorer like concat('%',#{warehousingVo.wastorer},'%')</if>",
                  "<if test='warehousingVo.waregister'> waregister like concat('%',#{warehousingVo.waregister},'%') </if>",
                  "<if test='warehousingVo.wachecker'> wachecker like concat('%',#{warehousingVo.wachecker},'%')</if>",

                  "<if test='warehousingVo.startWaamountsum != null and warehousingVo.endWaamountsum == null'>and waamountsum &gt;= #{warehousingVo.startWaamountsum} </if>",
                  "<if test='warehousingVo.startWaamountsum != null and warehousingVo.endWaamountsum == null'>and waamountsum &lt;= #{warehousingVo.endWaamountsum} </if>",
                  "<if test='warehousingVo.startWaamountsum != null and warehousingVo.endWaamountsum == null'>and waamountsum &gt;= #{warehousingVo.wagatherid} and waamountsum &lt;= #{warehousingVo.endWaamountsum} </if>",

                  "<if test='warehousingVo.startWacostpricesum != null and warehousingVo.endWacostpricesum == null'>and wacostpricesum &gt;= #{warehousingVo.startWacostpricesum} </if>",
                  "<if test='warehousingVo.startWacostpricesum != null and warehousingVo.endWacostpricesum == null'>and wacostpricesum &lt;= #{warehousingVo.endWacostpricesum} </if>",
                  "<if test='warehousingVo.startWacostpricesum != null and warehousingVo.endWacostpricesum == null'>and wacostpricesum &gt;= #{warehousingVo.startWacostpricesum} and wacostpricesum &lt;= #{warehousingVo.endWacostpricesum} </if>",

                  "<if test='warehousingVo.startWagatheredamountSum != null and warehousingVo.endWagatheredamountSum == null'>and wagatheredamountsum &gt;= #{warehousingVo.startWagatheredamountSum} </if>",
                  "<if test='warehousingVo.startWagatheredamountSum != null and warehousingVo.endWagatheredamountSum == null'>and wagatheredamountsum &lt;= #{warehousingVo.endWagatheredamountSum} </if>",
                  "<if test='warehousingVo.startWagatheredamountSum != null and warehousingVo.endWagatheredamountSum == null'>and wagatheredamountsum &gt;= #{warehousingVo.startWagatheredamountSum} and wagatheredamountsum &lt;= #{warehousingVo.endWagatheredamountSum} </if>",

                  "<if test='warehousingVo.wareason'> wareason like concat('%',#{warehousingVo.wareason},'%') </if>",
                  "<if test='warehousingVo.wachecktag'> wachecktag like concat('%',#{warehousingVo.wachecktag},'%')</if>",
               "</where>",
            "</script>"
    })
    @ResultMap(value = "examinePageWarehousingMap")
    IPage<Warehousing> queryWarehousingVo(IPage iPage,@Param("warehousingVo") WarehousingVo warehousingVo);
}
