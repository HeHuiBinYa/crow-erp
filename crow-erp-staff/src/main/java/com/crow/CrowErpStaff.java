package com.crow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.crow.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
public class CrowErpStaff
{
    public static void main( String[] args )
    {
        SpringApplication.run(CrowErpStaff.class,args);
    }
}
