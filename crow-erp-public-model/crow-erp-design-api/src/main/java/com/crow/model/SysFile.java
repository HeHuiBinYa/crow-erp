package com.crow.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class SysFile implements Serializable {
    //主键
    private Integer fid;
    //产品编号
    @NotEmpty(message = "产品编号不能为空")
    private String pid;
    //产品名称
    @NotEmpty(message = "产品名称不能为空")
    private String name;
    //产品描述
    private String descr;
    //外键, 关联到sys_heroA表的aid字段
    @Min(value = 1,message = "一级分类不能为空")
    private Integer aid;
    //外键, 关联到sys_heroB表的bid字段
    @Min(value = 1,message = "二级分类不能为空")
    private Integer bid;
    //外键, 关联到sys_heroC表的cid字段
    @Min(value = 1,message = "三级分类不能为空")
    private Integer cid;
    //用途类型
    @NotEmpty(message = "用途类型不能为空")
    private String type;
    //计量单位
    @NotEmpty(message = "计量单位不能为空")
    private String unit;
    //供应商集合
    @NotEmpty(message = "供应商集合不能为空")
    private String grou;
    //成本单价
    @Min(value = 1,message = "成本单价不能为空")
    private Double costPrice;
    //市场单价
    @Min(value = 1,message = "市场单价不能为空")
    private Double listPrice;
    //设计人
    @NotEmpty(message = "登记人不能为空")
    private String register;
    //复核人
    private String checker;
    //复核时间
    private LocalDateTime checkTime;
    //审核标志
    @NotEmpty(message = "审核标志不能为空")
    private String checkTag;
    //记录创建时间
    private LocalDateTime created;
    //记录更新时间
    private LocalDateTime updated;

    private List<SysMaterials> materials;
    private SysHeroA heroA;
    private SysHeroB heroB;
    private SysHeroC heroC;
}