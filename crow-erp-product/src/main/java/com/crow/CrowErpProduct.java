package com.crow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.crow.model")
@SpringBootApplication
@EnableDiscoveryClient
public class CrowErpProduct
{
    public static void main( String[] args )
    {
        SpringApplication.run(CrowErpProduct.class,args);
    }
}
