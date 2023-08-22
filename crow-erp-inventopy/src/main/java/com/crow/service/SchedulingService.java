package com.crow.service;

import com.crow.model.Scheduling;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:SchedulingService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/17 17:17
 * @Role
 */
public interface SchedulingService {
    Boolean insertScheduling(Scheduling scheduling);
    List<Scheduling> querySchedulingByID(Integer waid);
    Boolean updateSchedulingByScamount(Integer total, Integer scid);
}
