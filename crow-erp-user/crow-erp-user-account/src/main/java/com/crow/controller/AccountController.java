package com.crow.controller;

import com.crow.model.user.Account;
import com.crow.response.ResultResponse;
import com.crow.service.AccountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.BindException;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AccountController
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 21:37
 * @Role
 */

@RestController
@RequestMapping("/user/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResultResponse login(String username,String password){
        System.out.println(username);
        System.out.println(password);
        Account acc = accountService.queryAccountUsernameByPassword(username, password);

        if (acc == null){
            return new ResultResponse("账号或密码错误!");
        }

        return new ResultResponse(acc);
    }

}
