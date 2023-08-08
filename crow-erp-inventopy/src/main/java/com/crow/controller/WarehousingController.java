package com.crow.controller;

import com.crow.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/20:38
 * @Description:入库申请管理
 */
@RestController
@RequestMapping("/inventopy")
public class WarehousingController {
    private WarehousingService warehousingService;

    @Autowired
    public WarehousingController(WarehousingService warehousingService) {
        this.warehousingService = warehousingService;
    }
}
