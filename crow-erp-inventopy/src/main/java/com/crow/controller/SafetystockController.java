package com.crow.controller;

import com.crow.service.SafetystockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/9:52
 * @Description:安全库存配置管理
 */
@RestController
@RequestMapping("/inventopy")
public class SafetystockController {
    private SafetystockService safetystockService;

    @Autowired
    public SafetystockController(SafetystockService safetystockService) {
        this.safetystockService = safetystockService;
    }

}
