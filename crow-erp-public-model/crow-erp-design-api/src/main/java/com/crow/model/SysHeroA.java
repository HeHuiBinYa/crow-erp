package com.crow.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SysHeroA implements Serializable {
    //主键
    private Integer aid;
    //一级分类名称
    @NotEmpty(message = "一级分类名称不能为空")
    private String aName;
    //记录创建时间
    private LocalDateTime created;
    //记录更新时间
    private LocalDateTime updated;
}
