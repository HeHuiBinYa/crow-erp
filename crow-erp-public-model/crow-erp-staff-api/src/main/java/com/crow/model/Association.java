package com.crow.model;

import jakarta.validation.Valid;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Association
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 8:53
 * @Role
 */
@Data
public class Association implements Serializable {
    @Valid
    private Employee employee;
    private Position position;
    private Department department;
}
