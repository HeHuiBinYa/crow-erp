package com.crow.controller;

import com.crow.model.Account;
import com.crow.model.ResultResponse;
import com.crow.service.AccountService;
import com.crow.utils.RedisUtils;
import com.crow.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

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

        Account acc = null;
        // 判断redis是否存在这个key
        Boolean bool = redisUtils.exists("auth_"+username);

        System.out.println("缓存"+bool);

        // 如果等于true就放回缓存的数据信息
        if (bool){
            String s = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            acc = (Account) redisUtils.getKey("auth_"+username);

            System.out.println("验证"+StringUtils.verify(s,acc.getPassword()));
            System.out.println(s);
            System.out.println(acc.getPassword());
            if (StringUtils.verify(s,acc.getPassword()) == false){
                return new ResultResponse(331,"账号或密码错误!");
            }
        }else {
            acc = accountService.queryAccountUsernameByPassword(username, password);
        }

        if (acc == null){
            return new ResultResponse(332,"账号或密码错误!");
        } else if (!acc.getRole().getRole().equals(role)){
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
            Account account = accountService.queryAccountTok(tok);

            if (account != null){
                if (redisUtils.deleteKey(tok) && redisUtils.deleteKey("auth_"+account.getUsername())){
                    return new ResultResponse(true);
                }
            }
        }
        return new ResultResponse(222,"系统异常!");
    }
}
