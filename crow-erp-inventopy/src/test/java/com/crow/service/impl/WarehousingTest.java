package com.crow.service.impl;

import com.crow.service.SafetystockService;
import com.crow.service.WarehousingService;
import model.Warehousing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706-江盈
 * @Date: 2023/08/03/9:00
 * @Description:入库申请管理测试
 */
@SpringBootTest
public class WarehousingTest {
    @Autowired
    private WarehousingService warehousingService;

    @Test
    void test1(){
        List<Warehousing> list=warehousingService.selectWarehousing();
        System.out.println(list);
    }
    @Test
    void test2(){
        /*根据id查询*/
        Warehousing warehousing=warehousingService.selectOneWarehousing(1);
        System.out.println(warehousing);
        /*修改*/
        warehousing.setWastorer("Mary");
        Boolean bool=warehousingService.updateWarehousing(warehousing);
       System.out.println(bool);

    }
}
