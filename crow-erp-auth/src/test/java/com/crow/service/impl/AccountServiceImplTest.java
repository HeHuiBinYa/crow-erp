package com.crow.service.impl;

import com.crow.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @Test
    void test(){
        System.out.println(accountService.queryAccountUsernameByPassword("admin", "000000"));
    }
}