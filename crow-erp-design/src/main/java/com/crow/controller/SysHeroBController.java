package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroB;
import com.crow.service.SysHeroAService;
import com.crow.service.SysHeroBService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/design")
public class SysHeroBController {

    private SysHeroBService sysHeroBService;
    @Autowired
    public SysHeroBController(SysHeroBService sysHeroBService){
        this.sysHeroBService=sysHeroBService;
    }

    @PostMapping("/addSysHeroB")
    public ResultResponse addSysHeroB(@Valid SysHeroB sysHeroB){
        Boolean bool = sysHeroBService.addSysHeroB(sysHeroB);

        if (bool){
            return new ResultResponse(200,"添加完毕");
        }

        return new ResultResponse();
    }

    /**
     * 修改
     * @param sysHeroB
     * @return
     */
    @PutMapping("/updateSysHeroB")
    public ResultResponse updateSysHeroB(@Valid SysHeroB sysHeroB){
        Boolean bool = sysHeroBService.updateSysHeroB(sysHeroB);
        if (bool){
            return new ResultResponse(200,"修改成功!");
        }

        return new ResultResponse();
    }

    /**
     * 查询所有二级分类
     * @return
     */
    @PostMapping("/selectSysHeroBByBid")
    public ResultResponse selectSysHeroBByBid(Integer aid){
        return new ResultResponse(sysHeroBService.selectSysHeroBByBid(aid));
    }

    @PostMapping("/deleteSysHeroBByBid")
    public ResultResponse deleteSysHeroBByBid(Integer bid){
        return new ResultResponse(sysHeroBService.deleteSysHeroBByBid(bid));
    }

    @GetMapping("/selectSysHeroBList")
    private ResultResponse selectSysHeroBList(){
        return new ResultResponse(sysHeroBService.selectSysHeroBList());
    }

    @GetMapping("/selectSysHeroBUseAid")
    private ResultResponse selectSysHeroBUseAid(Integer aid){
        return new ResultResponse(sysHeroBService.selectSysHeroBUseAid(aid));
    }

    /**
     * 分页查询二级分类
     * @return
     */
    @PostMapping("/pageSysHeroB")
    private ResultResponse pageSysHeroA(String bname,Integer size,Integer sizePage){
        IPage<SysHeroB> sysHeroBIPage = sysHeroBService.pageSysHeroB(bname,size, sizePage);
        return new ResultResponse(sysHeroBIPage);
    }
}
