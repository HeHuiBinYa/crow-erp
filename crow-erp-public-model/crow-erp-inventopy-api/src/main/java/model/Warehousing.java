package model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
    private Double waamountsum;
    private Double wacostpricesum;
    private Double wagatheredamountsum;
    private String waremark;
    private String waregister;
    private LocalDate waregistertime;
    private String wachecker;
    private LocalDate wacheckertime;
    private String wachecktag;
    private String wastoretag;
    private LocalDate created;
    private LocalDate updated;
}
