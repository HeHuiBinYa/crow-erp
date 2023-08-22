package com.crow.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/01/11:11
 * @Description:入库申请管理数据库
 */
@Data
public class Warehousing implements Serializable {
    private Integer waid;
    private String wagatherid;
    private String wastorer;
    private String wareason;
    private BigDecimal waamountsum;
    private BigDecimal wacostpricesum;
    private BigDecimal wagatheredamountsum;
    private String waremark;
    private String waregister;
    private LocalDateTime waregistertime;
    private String wachecker;
    private LocalDateTime wacheckertime;
    private String wachecktag;
    private String wastoretag;
    private LocalDateTime created;
    private LocalDateTime updated;

    private List<Scheduling> schedulings;
}
