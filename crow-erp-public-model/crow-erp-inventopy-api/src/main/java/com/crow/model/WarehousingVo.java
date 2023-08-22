package com.crow.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:WarehousingVo
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/21 8:22
 * @Role
 */
@Data
public class WarehousingVo implements Serializable {
    private Integer size;
    private Integer sizePage;
    private String wagatherid;
    private String wastorer;
    private String waregister;
    private String wachecker;
    private Integer startWaamountsum;
    private Integer endWaamountsum;
    private Integer startWacostpricesum;
    private Integer endWacostpricesum;
    private Integer startWagatheredamountSum;
    private Integer endWagatheredamountSum;
    private String wareason;
    private String wachecktag;
}
