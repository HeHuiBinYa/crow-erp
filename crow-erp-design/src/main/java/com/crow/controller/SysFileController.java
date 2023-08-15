package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.SysFile;
import com.crow.service.SysFileService;
import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
@RequestMapping("/design")
public class SysFileController {
    private SysFileService sysFileService;
    @Value("${odd_numbers.fileId}")
    private String fileId;

    @Autowired
    public SysFileController(SysFileService sysFileService){
        this.sysFileService=sysFileService;
    }

    /**
     * 添加产品档案
     * @param sysFile
     * @return
     */
    @PostMapping("/addSysFile")
    public ResultResponse addSysFile(@Valid SysFile sysFile){
        Boolean bool = sysFileService.addSysFile(sysFile);

        if (bool){
            return new ResultResponse(sysFile.getFid());
        }

        return new ResultResponse();
    }

    @PostMapping("/deleteSysFileByFid")
    public ResultResponse deleteSysFileByFid(Integer fid){
        return new ResultResponse(sysFileService.deleteSysFileByFid(fid));
    }
    @PostMapping("/updateSysFile")
    private ResultResponse updateSysFile(SysFile sysFile){
        return new ResultResponse(sysFileService.updateSysFile(sysFile));
    }
    @GetMapping("/selectSysFileByFid")
    private ResultResponse selectSysFileByFid(Integer fid){
        return new ResultResponse(sysFileService.selectSysFileByFid(fid));
    }
    @GetMapping("/selectSysFileList")
    private ResultResponse selectSysFileList(){
        return new ResultResponse(sysFileService.selectSysFileList());
    }

    /**
     * 产品编号
     * @return
     */
    @GetMapping("/obtainAproductNumber")
    public ResultResponse obtainAproductNumber() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new ResultResponse(200, false,"",StringUtils.odd_numbers(fileId));
    }

    @PostMapping("/queryPageSysFile")
    public ResultResponse queryPageSysFile(Integer size,Integer sizePage){
        if (size <= 0){
            size = 1;
        }
        IPage<SysFile> sysFileIPage = sysFileService.queryPageSysFile(size, sizePage);
        if (sysFileIPage != null){
            return new ResultResponse(sysFileIPage);
        }
        return new ResultResponse();
    }

    @PostMapping("/examineSysFile")
    public ResultResponse examineSysFile(SysFile sysFile){
        System.out.println(sysFile);
        Boolean bool = sysFileService.examineSysFile(sysFile);

        if (bool){
            return new ResultResponse(200, true);
        }

        return new ResultResponse();
    }
}
