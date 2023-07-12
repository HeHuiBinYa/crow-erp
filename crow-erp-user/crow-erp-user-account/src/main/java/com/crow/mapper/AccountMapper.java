package com.crow.mapper;

import com.crow.model.user.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AccountMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 21:27
 * @Role
 */
@Mapper
public interface AccountMapper {
    /**
     * 查询账户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from account where username=#{username} and password=#{password}")
    Account queryAccountUsernameByPassword(@Param("username") String username,@Param("password") String password);

    /**
     * 添加账户
     * @param username
     * @param password
     * @return
     */
    @Insert("insert into account(username,password) values (#{username},#{password})")
    Boolean insertAccount(@Param("username") String username,@Param("password") String password);
}
