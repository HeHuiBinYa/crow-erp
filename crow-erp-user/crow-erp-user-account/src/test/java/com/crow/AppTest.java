package com.crow;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@SpringBootTest
public class AppTest 
{
    @Test
    void test(){
        System.out.println(UUID.randomUUID().toString());
        System.out.println(DigestUtils.md5DigestAsHex("000000".getBytes(StandardCharsets.UTF_8)));
    }
}
