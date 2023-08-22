package com.crow.controller;

import com.crow.model.ResultResponse;
import com.crow.model.SysMaterials;
import com.crow.service.SysMaterialsService;

import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
@RequestMapping("/design")
public class SysMaterialsController {
    private SysMaterialsService sysMaterialsService;
    @Value("${odd_numbers.mater}")
    private String mater;
    @Autowired
    public SysMaterialsController(SysMaterialsService sysMaterialsService){
        this.sysMaterialsService=sysMaterialsService;
    }

    /**
     * 添加物料
     * @param  sysMaterials
     * @return
     */
    @PostMapping("/addSysMaterials")
    public ResultResponse addSysMaterials(SysMaterials  sysMaterials){

        Boolean bool = sysMaterialsService.addSysMaterials(sysMaterials);

        if (bool){
            return new ResultResponse(200,sysMaterials.getDesignName()+"物料添加成功");
        }

        return new ResultResponse();
    }

    @PostMapping("/deleteSysMaterialsByMid")
    public ResultResponse deleteSysMaterialsByMid(Integer mid){
        return new ResultResponse(sysMaterialsService.deleteSysMaterialsByMid(mid));
    }

    @PostMapping("/updateSysMaterials")
    public ResultResponse updateSysMaterials(SysMaterials sysMaterials){
        Boolean bool = sysMaterialsService.updateSysMaterials(sysMaterials);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }

    @GetMapping("/selectSysMaterialsList")
    private ResultResponse selectSysMaterialsList(){
        return new ResultResponse(sysMaterialsService.selectSysMaterialsList());
    }


    /**
     * 物料组成设计单号
     * @return
     */
    @GetMapping("/materialCompositionDesignListNumber")
    public ResultResponse materialCompositionDesignListNumber() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new ResultResponse(200, false,"",StringUtils.odd_numbers(mater));
    }

    /**
     * 根据 fid 查询物料
     * @param fid
     * @return
     */
    @PostMapping("/selectSysMaterialsByFid")
    public ResultResponse selectSysMaterialsByFid(Integer fid) {
        List<SysMaterials> sysMaterials = sysMaterialsService.selectSysMaterialsByFid(fid);
        return new ResultResponse(sysMaterials);
    }
}
