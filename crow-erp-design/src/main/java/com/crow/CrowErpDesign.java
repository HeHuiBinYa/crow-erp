package com.crow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.crow.mapper")
public class CrowErpDesign
{
    public static void main( String[] args )
    {
        SpringApplication.run(CrowErpDesign.class,args);
    }
}
