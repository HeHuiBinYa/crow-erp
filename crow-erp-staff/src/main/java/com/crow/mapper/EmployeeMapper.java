package com.crow.mapper;

import com.crow.model.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:EmployeeMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:37
 * @Role
 */
@Mapper
public interface EmployeeMapper {
    @Insert("insert into sys_employee(staffid,ename,sex,birth,place,age,tel,card,entrytime,state,created) values (" +
            "#{staffid},#{ename},#{sex},#{birth},#{place},#{age},#{tel},#{card},now(),'ZZ-01',now())")
    @SelectKey(statement = "select LAST_INSERT_ID()",keyProperty = "eid",before = false,resultType = Integer.class)
    Boolean insertEmployee(Employee employee);

    @Update({
            "<script>",
              "update sys_employee",
                "<set>",
                  "updated=now(),",
                  "<if test='ename'> ename=#{ename} ,</if>",
                  "<if test='sex'> sex=#{sex} ,</if>",
                  "<if test='birth'> birth=#{birth} ,</if>",
                  "<if test='place'> place=#{place} ,</if>",
                  "<if test='age'> age=#{age} ,</if>",
                  "<if test='tel'> tel=#{tel} ,</if>",
                  "<if test='card'> card=#{card} ,</if>",
                "</set> where eid=#{eid}",
            "</script>"
    })
    Boolean updateEmployee(Employee employee);

    @Select("select * from sys_employee emp inner join CROW_ERP_USER.sys_emp_association ass on emp.eid=ass.eid where ass.aid = #{rid}")
    Employee selectEmployeeOne(Integer rid);

    @Select("select se.* from CROW_ERP_USER.SYS_ACCOUNT acc\n" +
            "inner join CROW_ERP_USER.sys_emp_association sea on acc.AID = sea.aid\n" +
            "inner join sys_employee se on sea.eid = se.eid where acc.TOK=#{tok}")
    Employee queryEmployeeTok(@Param("tok") String tok);
}
