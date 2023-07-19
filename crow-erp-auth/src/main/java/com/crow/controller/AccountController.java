package com.crow.controller;

import com.crow.model.Account;
import com.crow.model.ResultResponse;
import com.crow.service.AccountService;
import com.crow.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

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
@RequestMapping("/auth")
public class AccountController {
    private AccountService accountService;
    private RedisUtils redisUtils;

    @Autowired
    public AccountController(AccountService accountService, RedisUtils redisUtils) {
        this.accountService = accountService;
        this.redisUtils = redisUtils;
    }

    @PostMapping("/login")
    public ResultResponse login(String username, String password,String role){
        if ("".equals(username) || "".equals(password)){
            return new ResultResponse(444,"账号或密码不能为空!");
        }
        if ("".equals(role)){
            return new ResultResponse(444,"登录权限请选择!");
        }

        System.out.println(username+"  "+password+" "+role);
        // 判断redis是否存在这个key
        Boolean bool = redisUtils.exists("auth_"+username);

        Account acc = null;

        // 如果等于true就数据信息
        if (bool){
            acc = (Account) redisUtils.getKey("auth_"+username);
        }else {
            acc = accountService.queryAccountUsernameByPassword(username, password);

            if (acc == null){
                return new ResultResponse("账号或密码错误!");
            }
        }

        if (!acc.getRole().getRole().equals(role)){
            return new ResultResponse(333,"登录权限不足!");
        }

        if (!bool){
            redisUtils.seTex("auth_"+username,acc,15L);
            redisUtils.seTex(acc.getTok(),acc.getTok(),15L);
        }

        return new ResultResponse(acc);
    }

    @PostMapping("/quit")
    public ResultResponse quit(String tok){
        if (tok != null){
            if (redisUtils.deleteKey(tok)) {
                return new ResultResponse(true);
            }
        }

        return new ResultResponse(222,"系统异常!");
    }
}
