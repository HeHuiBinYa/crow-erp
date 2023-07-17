package com.crow.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Account
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 20:59
 * @Role
 */
@Data
public class Account implements Serializable {
    private Integer aid;
    @Size(min = 6,max = 12,message = "账号")
    private String username;
    @Size(min = 6,max = 12,message = "账号")
    private String password;
    private Byte freeze;
}
