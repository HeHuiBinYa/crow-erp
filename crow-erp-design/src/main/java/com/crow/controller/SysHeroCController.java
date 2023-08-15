package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.SysHeroB;
import com.crow.model.SysHeroC;
import com.crow.service.SysHeroCService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/design")
public class SysHeroCController {

    private SysHeroCService sysHeroCService;

    @Autowired
    public SysHeroCController(SysHeroCService sysHeroCService){
        this.sysHeroCService=sysHeroCService;
    }

    /**
     * 添加三级分类
     * @param sysHeroC
     * @return
     */
    @PostMapping("/addSysHeroC")
    public ResultResponse addSysHeroC(@Valid SysHeroC sysHeroC){
        System.out.println(sysHeroC);
        Boolean bool = sysHeroCService.addSysHeroC(sysHeroC);

        if (bool){
            return new ResultResponse(200,"添加完毕");
        }

        return new ResultResponse();
    }

    /**
     * 修改
     * @param sysHeroC
     * @return
     */
    @PutMapping("/updateSysHeroC")
    public ResultResponse updateSysHeroC(@Valid SysHeroC sysHeroC){
        Boolean bool = sysHeroCService.updateSysHeroC(sysHeroC);

        if (bool){
            return new ResultResponse(200,"修改成功!");
        }

        return new ResultResponse();
    }

    /**
     * 根据编号查询三级分类
     * @param bid
     * @return
     */
    @PostMapping("/selectSysHeroCByCid")
    public ResultResponse selectSysHeroCByCid(Integer bid){
        return new ResultResponse(sysHeroCService.selectSysHeroCByCid(bid));
    }

    @PostMapping("/deleteSysHeroCByCid")
    public ResultResponse deleteSysHeroCByCid(Integer cid){
        return new ResultResponse(sysHeroCService.deleteSysHeroCByCid(cid));
    }

    @GetMapping("/selectSysHeroCList")
    private ResultResponse selectSysHeroCList(){
        return new ResultResponse(sysHeroCService.selectSysHeroCList());
    }

    @GetMapping("/selectSysHeroCUseAid")
    private ResultResponse selectSysHeroCUseAid(Integer aid){
        return new ResultResponse(sysHeroCService.selectSysHeroCUseAid(aid));
    }

    @GetMapping("/selectSysHeroCUseBid")
    private ResultResponse selectSysHeroCUseBid(Integer bid){
        return new ResultResponse(sysHeroCService.selectSysHeroCUseBid(bid));
    }

    /**
     * 分页查询二级分类
     * @return
     */
    @PostMapping("/pageSysHeroC")
    private ResultResponse pageSysHeroC(String cname,Integer size,Integer sizePage){
        IPage<SysHeroC> sysHeroCIPage = sysHeroCService.pageSysHeroC(cname,size, sizePage);
        return new ResultResponse(sysHeroCIPage);
    }
}
