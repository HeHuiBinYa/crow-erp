package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Warehousing;
import com.crow.model.WarehousingVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WarehousingMapperTest {
    @Autowired
    private WarehousingMapper warehousingMapper;

    @Test
    void test(){
        Warehousing warehousing = new Warehousing();
        warehousing.setWareason("R001-6");
        warehousing.setWachecktag("S001-0");
        warehousing.setWastorer("K002-1");
        Boolean aBoolean = warehousingMapper.insertWarehousing(warehousing);
        System.out.println(warehousing.getWaid());
    }

    @Test
    void testPage(){
        IPage<Warehousing> warehousingIPage = warehousingMapper.queryWarehousingVo(new Page(1, 1), new WarehousingVo());

        warehousingIPage.getRecords().forEach(System.out::println);
    }
}