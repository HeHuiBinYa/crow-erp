package com.crow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:CrowErpUserAccount
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/12 21:25
 * @Role
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.crow.mapper")
public class CrowErpUserAccount {
    public static void main(String[] args) {
        SpringApplication.run(CrowErpUserAccount.class,args);
    }
}
