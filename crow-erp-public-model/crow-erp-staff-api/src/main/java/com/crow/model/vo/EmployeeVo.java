package com.crow.model.vo;

import com.crow.annotations.Cid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 员工表
 * @ClassName:EmpLoyee
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 8:52
 * @Role
 */
@Data
public class EmployeeVo implements Serializable {
    private String ename;  // 员工姓名
    private String sex;  // 员工性别
    private String tel;  // 员工电话
    private String place;  // 出生地址
    private Integer pid;  // 主键 ID
    private Integer did;  // 主键 ID
    private String state; // 在职状态
    private Integer tartingAge; // 年龄查询
    private Integer endAge;
    private LocalDate initialDateOfBirth; // 出生日期查询
    private LocalDate endDateOfBirth;
    private LocalDate startDateOfEmployment;  // 入职时间查询
    private LocalDate endOfEmploymentDate;
    private LocalDate departureDate;   // 离职时间查询
    private LocalDate terminationDate;
    private Integer size;
    private Integer sizePage;
}
