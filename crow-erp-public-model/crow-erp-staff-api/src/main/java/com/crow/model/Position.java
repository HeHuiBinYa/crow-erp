package com.crow.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 职位表
 * @ClassName:Position
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 8:50
 * @Role
 */
@Data
public class Position implements Serializable {
    private Integer pid;  // 主键 ID
    private String plevel;  // 职位等级
    private BigDecimal psalary; // 职位薪资
    private String position;  // 职位
    private LocalDate created; // 创建时间
    private LocalDate updated; // 修改时间
}
