package com.crow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Role
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/18 12:43
 * @Role
 */
@Data
public class Role implements Serializable {
    private Integer rid;
    private String role;
    private String rdes;
}
