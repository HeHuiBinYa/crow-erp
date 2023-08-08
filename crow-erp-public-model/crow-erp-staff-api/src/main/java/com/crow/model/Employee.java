package com.crow.model;

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
public class Employee implements Serializable {
    private Integer eid;  // 主键 ID
    private String staffid;  // 员工编号

    @NotEmpty(message = "员工姓名不能为空")
    private String ename;  // 员工姓名

    @NotEmpty(message = "员工性别不能为空")
    private String sex;  // 员工性别

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate birth;  // 出生日期

    @NotEmpty(message = "出生地址不能为空")
    private String place;  // 出生地址

    @Min(value = 18,message = "年龄必须大于18岁")
    private Integer age;  // 员工年龄

    @NotEmpty(message = "员工电话不能为空")
    private String tel;  // 员工电话

    @NotEmpty(message = "身份证号码不能为空")
    @Cid
    private String card;  // 身份证号码

    private LocalDate entrytime;  // 入职时间
    private LocalDate leavetim;   // 离职时间
    private String state;  // 在职状态
    private LocalDate created;  // 创建时间
    private LocalDate updated;  // 修改时间
}
