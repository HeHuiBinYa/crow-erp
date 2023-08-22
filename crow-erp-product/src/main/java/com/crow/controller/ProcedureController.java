package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Procedure;
import com.crow.model.ResultResponse;
import com.crow.service.ProcedureService;
import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lx
 */
@RefreshScope
@RestController
@RequestMapping("/product")
public class ProcedureController {
    private ProcedureService procedureService;

    @Value("${odd_numbers.product.prdetailsnumber}")
    private String prdetailsnumber;
    @Value("${odd_numbers.product.prprocedureid}")
    private String prprocedureid;

    @Autowired
    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    /**
     * 生成派工序序号
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/getProcedure1")
    public ResultResponse getSerialnumber1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String s = StringUtils.odd_numbers(prdetailsnumber);
        return new ResultResponse(200,false,"请求成功",s);
    }

    /**
     * 生成工序编号
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/getProcedure2")
    public ResultResponse getSerialnumber2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String s = StringUtils.odd_numbers(prprocedureid);
        return new ResultResponse(200,false,"请求成功",s);
    }

    @PostMapping("/insertProcedure")
    public ResultResponse insertProcedure(@Valid Procedure procedure){
        Boolean aBoolean = procedureService.insertProcedure(procedure);
        if (aBoolean) {
          return new ResultResponse(true);
        }else{
          return   new ResultResponse(300,"添加失败");
        }
    }

    @PostMapping("/deleteProcedureById")
    public ResultResponse deleteProcedure(Integer id){
        if (id!=null){
            Boolean aBoolean = procedureService.deleteProcedureById(id);
            if(aBoolean){
                return new ResultResponse(true);
            }else {
                return new ResultResponse(300,"删除失败，请稍后尝试！");
            }
        }
        return new ResultResponse("生产工序编号不能为空!");
    }



    @PostMapping("/updateProcedure")
    public ResultResponse updateProcedure(Procedure procedure){
        if (procedure!=null){
            Boolean aBoolean = procedureService.updateProcedure(procedure);
            if (aBoolean){
                return new ResultResponse(true);
            }else {
                return new ResultResponse(300,"修改失败！");
            }
        }
        return new ResultResponse(300,"修改数据异常!");
    }

    /**
     * 通过id修改生产工序审核状态
     * @param prid
     * @param procedurefinishtag
     * @return
     */
    @PostMapping("/updateProcedurefinishtagById")
    public ResultResponse updateprocedurefinishtagById(Integer prid,String procedurefinishtag){

        if (prid==null){
            return new ResultResponse(303,"编号不能为空");
        }
        if (procedurefinishtag==null){
            return new ResultResponse(303,"审核状态不能为空");
        }
        if(prid!=null&&procedurefinishtag!=null){
            Boolean aBoolean = procedureService.updateprocedurefinishtagById(prid, procedurefinishtag);
            if(aBoolean){
                return new ResultResponse(true);
            }else {
                return new ResultResponse(false);
            }
        }
        return new ResultResponse(303,"参数异常!");
    }



    @PostMapping("/selectProcedureAll")
    public ResultResponse selectAllProcedure(Integer pageNumber){
        if(pageNumber==null){
            pageNumber=1;
        }
        Page page=new Page(pageNumber,3);
        IPage<Procedure> procedures = procedureService.pageProcedure(1,3);

        if (procedures!=null){
                return new ResultResponse(procedures);
        }
        return new ResultResponse(300,"查询失败!");
    }

    @PostMapping("/selectProcedureById")
    public ResultResponse selectProcedureById(Integer id){
        System.out.println("ID:"+id);
        if (id!=null){
            Procedure procedure = procedureService.selectProcedureById(id);
            System.out.println(procedure);
            if(procedure!=null){
                return new ResultResponse(procedure);
            }
        }
        return new ResultResponse("生产工序编号不能为空!");
    }


    @PostMapping("/insertNowProcedure")
    public ResultResponse insertNowProcedure(Procedure procedure){
        Boolean bool = procedureService.insertNowProcedure(procedure);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }


}
