package com.crow.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lx
 */
@Data
public class Procedure implements Serializable {
    private Integer prid; //序号
    @NotEmpty(message = "工序序号不能为空")
    private Integer prdetailsnumber; //工序序号
    @NotEmpty(message = "工序编号不能为空")
    private String prprocedureid;//工序编号
    @NotEmpty(message = "工序名称不能为空")
    private String procedurename;//工序名称
    @Min(value = 1,message = "设计工时数不能为空")
    private Integer prlabourhouramount;//设计工时数
    private Integer prreallabourhouramount;//实际工时数
    @Min(value = 1,message = "设计工时成本不能为空")
    private Integer prsubtotal;//设计工时成本
    private Integer prrealsubtotal;//实际工时成本
    @Min(value = 1,message = "设计物料成本不能为空")
    private Integer prmodulesubtotal;//设计物料成本
    private Integer prrealmodulesubtotal;//实际物料成本
    @Min(value = 1,message = "单位工时成本不能为空")
    private Integer prcostprice;//单位工时成本
    @Min(value = 1,message = "工序投产数量不能为空")
    private Integer prdemandamount;//工序投产数量
    private Integer prrealamount;//工序合格数量
    private String procedurefinishtag;//
    private String proceduretransfertag;//
    private Integer maid;//外键

}
