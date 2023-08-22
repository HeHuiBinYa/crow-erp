package com.crow.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.ResultResponse;
import com.crow.model.Warehousing;
import com.crow.model.WarehousingVo;
import com.crow.service.WarehousingService;
import com.crow.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/20:38
 * @Description:入库申请管理
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/inventopy")
public class WarehousingController {
    private WarehousingService warehousingService;
    @Value("${odd_numbers.inventopy.wagatherid}")
    private String wagatherid;

    @Autowired
    public WarehousingController(WarehousingService warehousingService) {
        this.warehousingService = warehousingService;
    }

    @GetMapping("/getWagatherid")
    public ResultResponse getWagatherid(){
        return new ResultResponse(200,false,"", StringUtils.odd_numbers(wagatherid));
    }

    @PostMapping("/insertWarehousing")
    public ResultResponse insertWarehousing(Warehousing warehousing){
        System.out.println(warehousing);
        Boolean bool = warehousingService.insertWarehousing(warehousing);

        if (bool){
            return new ResultResponse(warehousing.getWaid());
        }

        return new ResultResponse(warehousing);
    }

    @PostMapping("/wagatheridComplete")
    public ResultResponse wagatheridComplete(Warehousing warehousing){
        Boolean bool = warehousingService.insertWarehousing(warehousing);

        if (bool){
            return new ResultResponse(200,warehousing.getWaid());
        }

        return new ResultResponse();
    }

    @PostMapping("/updateWarehousing")
    public ResultResponse updateWarehousing(Warehousing warehousing){
        Boolean bool = warehousingService.updateWarehousing(warehousing);
        log.info(wagatherid);
        if (bool){
            return new ResultResponse(200,false,"审核完毕",true);
        }

        return new ResultResponse();
    }

    @PostMapping("/examinePageWarehousing")
    public ResultResponse examinePageWarehousing(Integer size,Integer sizePage){
        IPage<Warehousing> page = warehousingService.examinePageWarehousing(size, sizePage);

        if (page != null){
            return new ResultResponse(200,page);
        }

        return new ResultResponse();
    }

    @PostMapping("/queryWarehousingVo")
    public ResultResponse queryWarehousingVo(WarehousingVo warehousingVo){
        if (warehousingVo.getWagatherid().equals("")){
            warehousingVo.setWagatherid(null);
        }
        if (warehousingVo.getWastorer().equals("")){
            warehousingVo.setWastorer(null);
        }
        if (warehousingVo.getWaregister().equals("")){
            warehousingVo.setWaregister(null);
        }
        if (warehousingVo.getWachecker().equals("")){
            warehousingVo.setWachecker(null);
        }
        if (warehousingVo.getWareason().equals("")){
            warehousingVo.setWareason(null);
        }
        if (warehousingVo.getWachecktag().equals("")){
            warehousingVo.setWachecktag(null);
        }

        IPage<Warehousing> warehousingIPage = warehousingService.queryWarehousingVo(warehousingVo);

        return new ResultResponse(warehousingIPage);
    }

    @PostMapping("/updateWarehousingVo")
    public ResultResponse updateWarehousingVo(Warehousing warehousing){
        Boolean bool = warehousingService.updateWarehousingVo(warehousing);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }

    @PostMapping("/updateWachecktag")
    public ResultResponse  updateWachecktag(Warehousing warehousing){
        Boolean bool = warehousingService.updateWachecktag(warehousing);

        if (bool){
            return new ResultResponse(true);
        }

        return new ResultResponse();
    }
}
