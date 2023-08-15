package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Procedure;
import com.crow.model.ResultResponse;
import com.crow.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lx
 */
@RestController
@RequestMapping("/product")
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;



    @PostMapping("/insert")
    public ResultResponse insertProcedure(Procedure procedure){
        Boolean aBoolean = procedureService.insertProcedure(procedure);
        if (aBoolean) {
          return new ResultResponse(true);
        }else{
          return   new ResultResponse(300,"添加失败");
        }

    }

    @PostMapping("/deleteById")
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



    @PostMapping("/update")
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
    @PostMapping("/updateprocedurefinishtagById")
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



    @PostMapping("/selectAll")
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

    @PostMapping("/selectById")
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




}
