package com.crow.service;

import com.crow.model.Account;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AccountService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 21:33
 * @Role
 */
public interface AccountService {
    Account queryAccountUsernameByPassword(String username, String password);
    Account queryAccountTok(String tok);
    Boolean insertAccount(String username, String password);
}
