package model;

import lombok.Data;
import org.springframework.data.annotation.Version;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/01/11:11
 * @Description: 安全库存配置管理数据库
 */
@Data
public class Safetystock  implements Serializable {
    private Integer said;
    private String saconf;
    private Integer fid;
    private Double saname;
    private Double amount;
    private Double maxamount;
    private String register;
    private LocalDate registertime;
    private String checker;
    private LocalDate checktime;
    private String checktag;
    private LocalDate created;
    private LocalDate updated;
}
