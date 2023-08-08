package com.crow.utils;

import com.crow.model.ResultResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootConfiguration
public class StringUtilsTest {
    @Test
    void ValidationNull_Test() throws Exception {
        String name = "AEC";
        System.out.println(StringUtils.odd_numbers(name));
    }
}