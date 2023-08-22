package com.crow.service.impl;

import com.crow.mapper.SchedulingMapper;
import com.crow.model.Scheduling;
import com.crow.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:SchedulingServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/17 17:17
 * @Role
 */
@Service
public class SchedulingServiceImpl implements SchedulingService {
    private SchedulingMapper schedulingMapper;

    @Autowired
    public SchedulingServiceImpl(SchedulingMapper schedulingMapper) {
        this.schedulingMapper = schedulingMapper;
    }

    @Override
    public Boolean insertScheduling(Scheduling scheduling) {
        return schedulingMapper.insertScheduling(scheduling);
    }

    @Override
    public List<Scheduling> querySchedulingByID(Integer waid) {
        return schedulingMapper.querySchedulingByID(waid);
    }

    @Override
    public Boolean updateSchedulingByScamount(Integer total, Integer scid) {
        return schedulingMapper.updateSchedulingByScamount(total,scid);
    }
}
