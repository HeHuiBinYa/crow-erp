package com.crow.controller;

import com.alibaba.nacos.shaded.com.google.common.collect.PeekingIterator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Manufacture;
import com.crow.model.ResultResponse;
import com.crow.model.vo.ManufactureVo;
import com.crow.service.ManufactureService;
import com.crow.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lx
 */
@RestController
@RequestMapping("/product")
public class ManufactureController {
    private ManufactureService manufactureService;
    @Value("${odd_numbers.product.manufactureid}")
    private String manufacture;
    @Value("${odd_numbers.product.maproductid}")
    private String maproduct;

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    /**
     * 生成派工单编号
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/getSerialnumber1")
    public ResultResponse getSerialnumber1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String s = StringUtils.odd_numbers(manufacture);
        return new ResultResponse(200,false,"请求成功",s);
    }

    /**
     * 生成产品编号
     * @return
     * @throws InterruptedException
     */
    @PostMapping("/getSerialnumber2")
    public ResultResponse getSerialnumber2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        String s = StringUtils.odd_numbers(maproduct);
        return new ResultResponse(200,false,"请求成功",s);
    }

    @PostMapping("/insertManufacture")
    public ResultResponse insertManufacture(@Valid Manufacture manufacture){
        if (manufacture!=null){
            Boolean bool = manufactureService.insertManufacture(manufacture);
            if (bool){
                return  new ResultResponse(200,false,"添加成功",manufacture.getMaid());
            }else {
                return new ResultResponse(300,"添加失败！");
            }
        }
        return new ResultResponse(200,"添加成功");
    }

    /**
     * 修改
     * @param manufacture
     * @return
     */
    @PostMapping("/updateManufactureById")
    public ResultResponse updatemachecktagById(Manufacture manufacture){
        Boolean bool = manufactureService.updateManufacture(manufacture);
        if(bool){
            return new ResultResponse(true);
        }

        return new ResultResponse(303,"参数异常!");
    }


    @PostMapping("/deleteManufactureById")
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


    @PostMapping("/selectManufactureAll")
    public ResultResponse selectAll(){
        List<Manufacture> manufactures = manufactureService.selectAllManufacture();
        if (manufactures!=null){
                return  new ResultResponse(manufactures);
            }

        return new ResultResponse("查询失败！");
    }


    /**
     * 审核分页
     * @param size
     * @param sizePage
     * @return
     */
    @PostMapping("/queryPageManufacture")
    public ResultResponse queryPageManufacture(Integer size,Integer sizePage){
        Page<Manufacture> page = manufactureService.queryPageManufacture(size, sizePage);

        return new ResultResponse(page);
    }

    /**
     * 审核
     * @return
     */
    @PostMapping("/manufactureExamine")
    public ResultResponse examine(Manufacture manufacture){
        Boolean bool = manufactureService.updateExamine(manufacture);

        if (bool){
            return new ResultResponse(200,"审核完毕");
        }

        return new ResultResponse();
    }

    /**
     * 审核分页
     * @param size
     * @param sizePage
     * @return
     */
    @PostMapping("/queryPageManufactureFinished")
    public ResultResponse queryPageManufactureFinished(Integer size,Integer sizePage){
        Page<Manufacture> page = manufactureService.queryPageManufactureFinished(size, sizePage);

        return new ResultResponse(page);
    }

    @PostMapping("/manufactureComplete")
    public ResultResponse manufactureComplete(Manufacture manufacture){
        Boolean bool = manufactureService.manufactureComplete(manufacture);

        if (bool){
            return new ResultResponse(200,true);
        }

        return new ResultResponse();
    }

    @PostMapping("/queryManufactureVo")
    public ResultResponse queryManufactureVo(ManufactureVo manufactureVo){
        if (manufactureVo.getManufactureid() == ""){
            manufactureVo.setManufactureid(null);
        }
        if (manufactureVo.getMaproductid().equals("")){
            manufactureVo.setMaproductid(null);
        }
        if (manufactureVo.getMaproductname().equals("")){
            manufactureVo.setMaproductname(null);
        }
        if (manufactureVo.getMadesigner() == ""){
            manufactureVo.setMadesigner(null);
        }
        if (manufactureVo.getMachecker() == ""){
            manufactureVo.setMachecker(null);
        }
        if (manufactureVo.getStartMaamount() == ""){
            manufactureVo.setStartMaamount(null);
        }
        if (manufactureVo.getEndMaamount() == ""){
            manufactureVo.setEndMaamount(null);
        }
        if (manufactureVo.getStartMatesteramount() == ""){
            manufactureVo.setStartMatesteramount(null);
        }
        if (manufactureVo.getEndMatesteramount() == ""){
            manufactureVo.setEndMatesteramount(null);
        }
        if (manufactureVo.getMachecktag() == ""){
            manufactureVo.setMachecktag(null);
        }
        if (manufactureVo.getManufacturepriceduretag() == ""){
            manufactureVo.setManufacturepriceduretag(null);
        }

        IPage<Manufacture> page = manufactureService.queryManufactureVo(manufactureVo);

        return new ResultResponse(page);
    }
}
