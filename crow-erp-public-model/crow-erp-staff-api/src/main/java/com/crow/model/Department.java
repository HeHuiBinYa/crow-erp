package com.crow.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 部门表
 * @ClassName:Depattment
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 8:47
 * @Role
 */
@Data
public class Department implements Serializable {
    private Integer did;  // 主键 ID
    private String dname;  // 部门名称
    private String position;  // 部门职务
    private String duty; // 部门职责
    private LocalDate created; // 创建时间
    private LocalDate updated; // 修改时间
}
