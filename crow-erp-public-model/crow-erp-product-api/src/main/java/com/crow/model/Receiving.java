package com.crow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Receiving
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/16 10:28
 * @Role
 */
@Data
public class Receiving implements Serializable {
    private Integer rmid;
    private Integer maid;
    private Integer did;
    private Integer eid;
}
