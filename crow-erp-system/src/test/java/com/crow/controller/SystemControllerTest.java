package com.crow.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
public class SystemControllerTest {
    @Test
    void test() throws URISyntaxException {
        URI uri = new URI("https://resources.hehuibin.cn/2250496833.jpeg");
        File file = new File(uri);
        System.out.println(uri.isOpaque());
        System.out.println(file.exists());
    }
}