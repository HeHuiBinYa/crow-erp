package com.crow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Dispatch
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/21 17:45
 * @Role
 */
@Data
public class Dispatch implements Serializable {
    private Integer did;
    private String dname;
    private Double number;
    private String tag;
    private String operator;
    private Integer scid;
}
