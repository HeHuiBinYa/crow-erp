package com.crow.model;

import lombok.Data;

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
public class EmpLoyee implements Serializable {
    private Integer eid;  // 主键 ID
    private String staffid;  // 员工编号
    private String ename;  // 员工姓名
    private String sex;  // 员工性别
    private LocalDate birth;  // 出生日期
    private String place;  // 出生地址
    private Integer age;  // 员工年龄
    private String tel;  // 员工电话
    private String card;  // 身份证号码
    private LocalDate entrytime;  // 入职时间
    private LocalDate leavetim;   // 离职时间
    private String state;  // 在职状态
    private LocalDate created;  // 创建时间
    private LocalDate updated;  // 修改时间
}
