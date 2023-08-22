package com.crow.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Scheduling
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/17 9:30
 * @Role
 */
@Data
public class Scheduling implements Serializable {
    private Integer scid;
    private String scproductid;
    private String scproductname;
    private String scproductdescribe;
    private Double scamount;
    private Double scamountunit;
    private Double sccostprice;
    private Double scubtotal;
    private Double scgatheredamount;
    private String scgathertag;
    private Integer waid;

    private List<Dispatch> dispatchs;
}
