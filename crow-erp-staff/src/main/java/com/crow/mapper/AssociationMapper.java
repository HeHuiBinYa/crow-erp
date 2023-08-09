package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Association;
import com.crow.model.Employee;
import com.crow.model.Position;
import com.crow.model.vo.EmployeeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AssociationMapper
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:36
 * @Role
 */
@Mapper
public interface AssociationMapper {
    @Insert("insert into sys_emp_association(eid,did,pid) values (#{association.employee.eid},#{association.position.pid},#{association.department.did})")
    Boolean insertAssociation(@Param("association") Association association);

    @Update({
            "<script>",
              "update sys_emp_association",
                "<set>",
                  "updated=now(),",
                  "<if test='did'>did=#{did},</if>",
                  "<if test='pid'>pid=#{pid},</if>",
                "</set>",
                "where eid=#{eid}",
            "</script>"
    })
    Boolean updatedAssociation(@Param("eid") Integer eid,@Param("pid") Integer pid,@Param("did") Integer did);

    @Select({
            "<script>",
            "select e.*,d.*,d.updated dupdated,d.created dcreated,p.*,p.position pposition,p.created pcreated,p.updated pupdated from sys_employee e\n" +
                    "    inner join sys_emp_association a on e.eid=a.eid\n" +
                    "    inner join sys_department d on a.did=d.did\n" +
                    "    inner join sys_position p on a.pid=p.pid",
            "<where>",
               "<if test='employeeVo.ename'>ename like concat('%',#{employeeVo.ename},'%')</if>", //姓名
               "<if test='employeeVo.sex'>and sex = #{employeeVo.sex}</if>",       //性别

               "<if test='employeeVo.tel'>or tel like concat('%',#{employeeVo.tel},'%')</if>",  // 电话
               "<if test='employeeVo.place'>or place like concat('%',#{employeeVo.place},'%')</if>", // 出生地址
               "<if test='employeeVo.pid'>or p.pid = #{employeeVo.pid}</if>", // 职位
               "<if test='employeeVo.did'> d.did = #{employeeVo.did}</if>", // 部门
               "<if test='employeeVo.state'>and state = #{employeeVo.state}</if>", // 在职状态

               "<if test='employeeVo.tartingAge != null and employeeVo.endAge == null'>or age &gt;= #{employeeVo.tartingAge}</if>",
               "<if test='employeeVo.tartingAge == null and employeeVo.endAge != null'>or age &lt;= #{employeeVo.endAge}</if>",
               "<if test='employeeVo.tartingAge != null and employeeVo.endAge != null'>or age &gt;= #{employeeVo.tartingAge} and age &lt;= #{employeeVo.endAge}</if>",

               "<if test='employeeVo.initialDateOfBirth != null and employeeVo.endDateOfBirth == null'>or birth &gt;= #{employeeVo.initialDateOfBirth}</if>",
               "<if test='employeeVo.initialDateOfBirth == null and employeeVo.endDateOfBirth != null'>or birth &lt;= #{employeeVo.endDateOfBirth}</if>",
               "<if test='employeeVo.initialDateOfBirth != null and employeeVo.endDateOfBirth != null'>or birth &gt;= #{employeeVo.initialDateOfBirth} and birth &lt;= #{employeeVo.endDateOfBirth}</if>",

               "<if test='employeeVo.startDateOfEmployment != null and employeeVo.endOfEmploymentDate == null'>or entrytime &gt;= #{employeeVo.startDateOfEmployment}</if>",
               "<if test='employeeVo.startDateOfEmployment == null and employeeVo.endOfEmploymentDate != null'>or entrytime &lt;= #{employeeVo.endOfEmploymentDate}</if>",
               "<if test='employeeVo.startDateOfEmployment != null and employeeVo.endOfEmploymentDate != null'>or entrytime &gt;= #{employeeVo.startDateOfEmployment} and entrytime &lt;= #{employeeVo.endOfEmploymentDate}</if>",

               "<if test='employeeVo.departureDate != null and employeeVo.terminationDate == null'>or leavetime &gt;= #{employeeVo.departureDate}</if>",
               "<if test='employeeVo.departureDate == null and employeeVo.terminationDate != null'>or leavetime &lt;= #{employeeVo.terminationDate}</if>",
               "<if test='employeeVo.departureDate != null and employeeVo.terminationDate != null'>or leavetime &gt;= #{employeeVo.departureDate} and leavetime &lt;= #{employeeVo.terminationDate}</if>",
            "</where>",
            "</script>"
    })
    @Results(id = "associationMap",value = {
            @Result(property = "employee.eid",column = "eid"),
            @Result(property = "employee.staffid",column = "staffid"),
            @Result(property = "employee.ename",column = "ename"),
            @Result(property = "employee.sex",column = "sex"),
            @Result(property = "employee.birth",column = "birth"),
            @Result(property = "employee.place",column = "place"),
            @Result(property = "employee.age",column = "age"),
            @Result(property = "employee.tel",column = "tel"),
            @Result(property = "employee.card",column = "card"),
            @Result(property = "employee.entrytime",column = "entrytime"),
            @Result(property = "employee.leavetim",column = "leavetim"),
            @Result(property = "employee.state",column = "state"),
            @Result(property = "employee.created",column = "created"),
            @Result(property = "employee.updated",column = "updated"),

            @Result(property = "position.pid",column = "pid"),
            @Result(property = "position.plevel",column = "plevel"),
            @Result(property = "position.psalary",column = "psalary"),
            @Result(property = "position.position",column = "pposition"),
            @Result(property = "position.created",column = "pcreated"),
            @Result(property = "position.updated",column = "pupdated"),

            @Result(property = "department.did",column = "did"),
            @Result(property = "department.dname",column = "dname"),
            @Result(property = "department.position",column = "position"),
            @Result(property = "department.duty",column = "duty"),
            @Result(property = "department.created",column = "dcreated"),
            @Result(property = "department.updated",column = "dupdated"),
    })
    IPage<Association> pageAssociation(IPage iPage,@Param("employeeVo") EmployeeVo employeeVo);
}
