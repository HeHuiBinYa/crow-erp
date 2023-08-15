package com.crow.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SysHeroC implements Serializable {
    //主键
    private Integer cid;
    //三级分类名称
    @NotEmpty(message = "三级分类名称不能为空")
    private String cName;
    //记录创建时间
    private LocalDateTime created;
    //记录更新时间
    private LocalDateTime updated;
    //外键, 关联到sys_heroB表的bid字段
    private Integer bid;
}
