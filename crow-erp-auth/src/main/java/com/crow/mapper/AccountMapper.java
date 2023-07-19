package com.crow.mapper;

import com.crow.model.Account;
import org.apache.ibatis.annotations.*;

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
    @Select("select A.*,SR.* from SYS_ACCOUNT A\n" +
            "inner join ACCOUNT_ROLE AR on A.AID = AR.AID\n" +
            "inner join SYS_ROLE SR on AR.RID = SR.RID where USERNAME=#{username} and PASSWORD=#{password}")
    @Results(id = "account_roleMap",value = {
            @Result(property = "role.rid",column = "RID"),
            @Result(property = "role.role",column = "ROLE"),
            @Result(property = "role.rdes",column = "RDES"),
    })
    Account queryAccountUsernameByPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 添加账户
     * @param username
     * @param password
     * @return
     */
    @Insert("insert into account(username,password) values (#{username},#{password})")
    Boolean insertAccount(@Param("username") String username, @Param("password") String password);
}
