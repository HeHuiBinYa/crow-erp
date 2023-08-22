package com.crow.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class SysFileVo implements Serializable {
    private Integer size;
    private Integer sizePage;
    private String pid;
    private String name;
    private String grou;
    private Integer aid;
    private Integer bid;
    private Integer cid;
    private String type;
    private String unit;
    private String register;
    private String checker;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double startMoney;
    private Double endMoney;
    private Double startMoneys;
    private Double endMoneys;
    private String checktag;
}
