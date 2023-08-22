package com.crow.controller;

import com.crow.mapper.SchedulingMapper;
import com.crow.model.ResultResponse;
import com.crow.model.Scheduling;
import com.crow.service.SchedulingService;
import com.crow.service.WarehousingService;
import com.crow.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:SchedulingServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/17 17:17
 * @Role
 */
@RefreshScope
@RestController
@RequestMapping("/inventopy")
public class SchedulingController {
    private SchedulingService schedulingService;

    @Value("${odd_numbers.inventopy.scproductid}")
    private String scproductid;

    @Autowired
    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @GetMapping("/getScproductid")
    public ResultResponse getWagatherid(){
        return new ResultResponse(200,false,"", StringUtils.odd_numbers(scproductid));
    }

    @PostMapping("/insertScheduling")
    public ResultResponse insertScheduling(Scheduling scheduling){
        System.out.println(scheduling);
        Boolean bool = schedulingService.insertScheduling(scheduling);

        if (bool){
            return new ResultResponse(200,false,scheduling.getScproductname()+"添加完毕!",true);
        }

        return new ResultResponse(scheduling);
    }

    @PostMapping("/schedulingComplete")
    public ResultResponse schedulingComplete(Scheduling scheduling){
        Boolean bool = schedulingService.insertScheduling(scheduling);

        if (bool){
            return new ResultResponse(200,true);
        }

        return new ResultResponse();
    }

    @PostMapping("/updateSchedulingByScamount")
    public ResultResponse updateSchedulingByScamount(Integer total,Integer scid){
        Boolean bool = schedulingService.updateSchedulingByScamount(total, scid);

        if (bool){
            return new ResultResponse(200,true);
        }

        return new ResultResponse();
    }
}