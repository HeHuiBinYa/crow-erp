package com.crow.model.vo;

import com.crow.model.Procedure;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author lx
 */
@Data
public class ManufactureVo implements Serializable {
    private Integer size;
    private Integer sizePage;
    private String manufactureid;
    private String maproductid;
    private String maproductname;
    private String madesigner;
    private String machecker;
    private String startMaamount;
    private String endMaamount;
    private String startMatesteramount;
    private String endMatesteramount;
    private String machecktag;
    private String manufacturepriceduretag;
}
