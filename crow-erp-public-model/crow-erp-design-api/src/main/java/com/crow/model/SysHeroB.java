package com.crow.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SysHeroB implements Serializable {
    //主键
    private Integer bid;
    //二级分类名称
    @NotEmpty(message = "二级分类名称不能为空")
    private String bName;
    //记录创建时间
    private LocalDateTime created;
    //记录更新时间
    private LocalDateTime updated;
    //外键, 关联到sys_heroA表的aid字段
    private Integer aid;

}
