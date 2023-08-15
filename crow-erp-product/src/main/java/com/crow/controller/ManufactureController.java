package com.crow.controller;

import com.alibaba.nacos.shaded.com.google.common.collect.PeekingIterator;
import com.crow.model.Manufacture;
import com.crow.model.ResultResponse;
import com.crow.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lx
 */
@RestController
@RequestMapping("/product")
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    @PostMapping("/insert")
    public ResultResponse insert(Manufacture manufacture){
        if (manufacture!=null){
            Boolean aBoolean = manufactureService.insertManufacture(manufacture);
            if (aBoolean){
                return  new ResultResponse(true);
            }else {
                return new ResultResponse(300,"添加失败！");
            }
        }
        return new ResultResponse("添加数据异常！");
    }

    /**
     * 通过id修改审核状态
     * @param maid
     * @param machecktag
     * @return
     */
    @PostMapping("/updatemachecktagById")
    public ResultResponse updatemachecktagById(Integer maid,String machecktag){

        if (maid==null){
            return new ResultResponse(303,"编号不能为空");
        }
        if (machecktag==null){
            return new ResultResponse(303,"审核状态不能为空");
        }
        if(maid!=null&&machecktag!=null){
            Boolean aBoolean = manufactureService.updatemachecktagById(maid, machecktag);
            if(aBoolean){
                return new ResultResponse(true);
            }
        }

        return new ResultResponse(303,"参数异常!");
    }


    @PostMapping("/deleteById")
    public ResultResponse deleteById(Integer id){
        if (id!=null){
            Boolean aBoolean = manufactureService.deleteManufactureById(id);
            if (aBoolean){
                return  new ResultResponse(true);
            }else {
                return new ResultResponse(300,"删除失败！");
            }
        }
        return new ResultResponse("数据异常！");
    }


    @PostMapping("/selectAll")
    public ResultResponse selectAll(){
        List<Manufacture> manufactures = manufactureService.selectAllManufacture();
        if (manufactures!=null){
                return  new ResultResponse(manufactures);
            }

        return new ResultResponse("查询失败！");
    }


}
