package com.crow.service.impl;

import com.crow.mapper.AccountMapper;
import com.crow.model.Account;
import com.crow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AccountService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 21:33
 * @Role
 */
@Service
public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Account queryAccountUsernameByPassword(String username, String password) {
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        return accountMapper.queryAccountUsernameByPassword(username,password);
    }

    @Override
    public Account queryAccountTok(String tok) {
        return accountMapper.queryAccountTok(tok);
    }

    @Override
    public Boolean insertAccount(String username, String password) {
        return accountMapper.insertAccount(username,password);
    }
}
