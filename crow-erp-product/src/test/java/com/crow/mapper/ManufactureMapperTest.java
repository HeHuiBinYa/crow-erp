package com.crow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Manufacture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManufactureMapperTest {
    @Autowired
    private ManufactureMapper manufactureMapper;

    @Test
    void test(){
        Page<Manufacture> page = manufactureMapper.queryPageManufactureTask(new Page(1, 1));

        page.getRecords().forEach(System.out::println);
    }
}