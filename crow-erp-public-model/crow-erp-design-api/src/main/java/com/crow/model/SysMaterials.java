package com.crow.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SysMaterials implements Serializable {
    //主键
    private Integer mid;
    //物流组成设计单号
    @NotEmpty(message = "物流单号不能为空")
    private String design;
    //产品编号
    @Min(value = 1,message = "产品编号不能为空")
    private Integer fid;
    //设计人
    @NotEmpty(message = "设计人不能为空")
    private String designer;
    //登记人
    @NotEmpty(message = "登记人不能为空")
    private String register;
    //登记时间 registerime
    private LocalDateTime registerTime;
    //复核人
    private String checker;
    //审核状态
    private String status;
    //物流名称
    @NotEmpty(message = "物流名称不能为空")
    private String designName;
    //用途类型
    @NotEmpty(message = "用途类型不能为空")
    private String type;
    //描述
    private String describer;
    //单位
    @Min(value = 1,message = "单位不能为空")
    private String munit;
    //数量
    @Min(value = 1,message = "数量不能为空")
    private Integer amount;
    //可用数量
    private Integer residual;
    //单价
    @Min(value = 1,message = "单价不能为空")
    private Double price;
    //物流总成本
    @Min(value = 1,message = "物流总成本不能为空")
    private Double priceSum;
    //记录创建时间
    private LocalDateTime created;
    //记录更新时间
    private LocalDateTime updated;


}
