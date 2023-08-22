package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.SysFile;
import com.crow.model.SysFileVo;
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

import java.util.List;
import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
@RequestMapping("/design")
public class SysFileController {
    private SysFileService sysFileService;
    @Value("${odd_numbers.fileId}")
    private String fileId;

    @Autowired
    public SysFileController(SysFileService sysFileService) {
        this.sysFileService = sysFileService;
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


    /**
     * 产品编号
     * @return
     */
    @GetMapping("/obtainAproductNumber")
    public ResultResponse obtainAproductNumber() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return new ResultResponse(200, false,"",StringUtils.odd_numbers(fileId));
    }

    /**
     * 档案审核分页
     * @param size
     * @param sizePage
     * @return
     */
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

    /**
     * 档案审核
     * @param sysFile
     * @return
     */
    @PostMapping("/examineSysFile")
    public ResultResponse examineSysFile(SysFile sysFile){
        System.out.println(sysFile);
        Boolean bool = sysFileService.examineSysFile(sysFile);

        if (bool){
            return new ResultResponse(200, true);
        }

        return new ResultResponse();
    }

    /**
     * 查询所有档案
     * @return
     */
    @PostMapping("/queryFileList")
    public ResultResponse queryFileList(){
        List<SysFile> sysFiles = sysFileService.queryFileList();

        sysFiles.forEach(System.out::println);

        return new ResultResponse(sysFiles);
    }

    @PostMapping("/querySysFileVo")
    public ResultResponse querySysFileVo(SysFileVo sysFileVo){
        if (sysFileVo.getPid() == ""){
            sysFileVo.setPid(null);
        }
        if (sysFileVo.getName() == ""){
            sysFileVo.setName(null);
        }
        if (sysFileVo.getGrou() == ""){
            sysFileVo.setGrou(null);
        }
        if (sysFileVo.getType() == ""){
            sysFileVo.setType(null);
        }
        if (sysFileVo.getUnit() == ""){
            sysFileVo.setUnit(null);
        }
        if (sysFileVo.getRegister() == ""){
            sysFileVo.setRegister(null);
        }
        if (sysFileVo.getChecker() == ""){
            sysFileVo.setChecker(null);
        }
        if (sysFileVo.getChecktag() == ""){
            sysFileVo.setChecktag(null);
        }


        IPage<SysFile> page = sysFileService.querySysFileVo(sysFileVo.getSize(), sysFileVo.getSizePage(), sysFileVo);

        return new ResultResponse(page);
    }

    @PostMapping("/updateFile")
    public ResultResponse updateFile(SysFile sysFile){
        Boolean bool = sysFileService.updateFile(sysFile);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }

    @PostMapping("/updateCheckTag")
    public ResultResponse updateCheckTag(Integer fid){
        Boolean bool = sysFileService.updateCheckTag(fid);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }
}
