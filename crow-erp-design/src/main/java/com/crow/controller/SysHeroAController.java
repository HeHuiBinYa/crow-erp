package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.SysHeroA;
import com.crow.service.SysHeroAService;
import com.crow.service.SysHeroCService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/design")
public class SysHeroAController {
    private SysHeroAService sysHeroAService;
    @Autowired
    public SysHeroAController(SysHeroAService sysHeroAService){
        this.sysHeroAService=sysHeroAService;

    }

    /**
     * 添加一级分类
     * @param sysHeroA
     * @return
     */
    @PostMapping("/addSysHeroA")
    public ResultResponse addSysHeroA(@Valid SysHeroA sysHeroA){
        Boolean bool = sysHeroAService.addSysHeroA(sysHeroA);

        if (bool){
            return new ResultResponse(200,"添加完毕");
        }

        return new ResultResponse();
    }

    /**
     * 修改
     * @param sysHeroA
     * @return
     */
    @PutMapping("/updateSysHeroA")
    public ResultResponse updateSysHeroA(@Valid SysHeroA sysHeroA){
        Boolean bool = sysHeroAService.updateSysHeroA(sysHeroA);
        if (bool){
            return new ResultResponse(200,"修改成功!");
        }

        return new ResultResponse();
    }
    @GetMapping("/selectSysHeroAByAid")
    public ResultResponse selectSysHeroAByAid(Integer aid){
        return new ResultResponse(sysHeroAService.selectSysHeroAByAid(aid));
    }

    @PostMapping("/deleteSysHeroAByAid")
    public ResultResponse deleteSysHeroAByAid(Integer aid){
        return new ResultResponse(sysHeroAService.deleteSysHeroAByAid(aid));
    }

    /**
     * 查询所有一级分类
     * @return
     */
    @GetMapping("/selectSysHeroAList")
    private ResultResponse selectSysHeroAList(){
        return new ResultResponse(sysHeroAService.selectSysHeroAList());
    }

    /**
     * 分页查询一级分类
     * @return
     */
    @PostMapping("/pageSysHeroA")
    private ResultResponse pageSysHeroA(String aname,Integer size,Integer sizePage){
        IPage<SysHeroA> sysHeroAIPage = sysHeroAService.pageSysHeroA(aname,size, sizePage);
        return new ResultResponse(sysHeroAIPage);
    }
}
