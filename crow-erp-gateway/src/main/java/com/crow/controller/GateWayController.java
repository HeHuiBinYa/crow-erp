package com.crow.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class GateWayController {

    @Value("${info.name}")
    private String name;

    @GetMapping("/")
    public String index(){
        return name;
    }
}
