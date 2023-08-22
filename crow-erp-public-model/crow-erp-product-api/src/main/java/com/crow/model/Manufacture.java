package com.crow.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 */
@Data
public class Manufacture implements Serializable {
    private Integer maid;

    @NotEmpty(message = "工序序号不能为空")
    private String manufactureid;

    @NotEmpty(message = "产品编号不能为空")
    private String maproductid;

    @NotEmpty(message = "产品名称不能为空")
    private String maproductname;

    @Min(value = 0,message = "产品名称不能为空")
    private Integer maamount;

    @Min(value = 0,message = "投产数量不能为空")
    private Integer matesteramount;

    private String  maproductdescribe;

    @Min(value = 0,message = "设计物料总成本不能为空")
    private Integer mamodulecostpricesum;

    private Integer marealmodulecostpricesum;

    @Min(value = 0,message = "设计工时总成本不能为空")
    private Integer malabourcostpricesum;

    private Integer mareallabourcostpricesum;

    @NotEmpty(message = "工单制定人不能为空")
    private String madesigner;

    private String machecker;
    private LocalDate maregistertime;
    private LocalDate machecktime;
    private String  maremapk;
    private String machecktag;
    private String manufacturepriceduretag;
    private Integer mafid;

    private List<Procedure> procedures;
}
