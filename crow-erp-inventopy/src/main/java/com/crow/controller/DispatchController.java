package com.crow.controller;

import com.crow.model.Dispatch;
import com.crow.model.ResultResponse;
import com.crow.service.DispatchService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DispatchController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/21 17:56
 * @Role
 */
@RefreshScope
@RestController
@RequestMapping("/inventopy")
public class DispatchController {
    private DispatchService dispatchService;

    @Autowired
    public DispatchController(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }

    @PostMapping("/insertDispatch")
    public ResultResponse insertDispatch(Dispatch dispatch){
        Boolean bool = dispatchService.insertDispatch(dispatch);

        if (bool){
            return new ResultResponse(200,false,"操作成功",true);
        }

        return new ResultResponse();
    }
}
