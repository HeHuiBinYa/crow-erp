package com.crow.mapper;

import com.crow.model.Dispatch;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DispatchMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/21 17:46
 * @Role
 */
@Mapper
public interface DispatchMapper {
    @Select("select * from sys_dispatch where scid=#{scid}")
    List<Dispatch> selectDispatch(Integer scid);

    @Insert("insert into sys_dispatch(dname,number,tag,operator,scid) values (#{dname},#{number},#{tag},#{operator},#{scid})")
    Boolean insertDispatch(Dispatch dispatch);
}
