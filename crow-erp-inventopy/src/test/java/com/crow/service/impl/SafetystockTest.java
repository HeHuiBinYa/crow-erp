package com.crow.service.impl;

import com.crow.service.SafetystockService;
import model.Safetystock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706-江盈
 * @Date: 2023/08/02/10:50
 * @Description:安全库存配置管理测试
 */
@SpringBootTest
public class SafetystockTest {
    @Autowired
    private SafetystockService safetystockService;

    /*查询所有*/
    @Test
    void test1(){
        List<Safetystock> list=safetystockService.SelectSafetystock();
        System.out.println(list);
    }
    /*删除*/
    @Test
    void test2(){
        Boolean safet=safetystockService.deleteSafetystock(1);
        System.out.println(safet);
    }
    /*添加*/
    @Test
    void test3(){
        Safetystock safetystock=new Safetystock();
        //1,"001",1,120.00,120.00,120.00,"张三", LocalDate.now(),"王五",LocalDate.now(),"A001-1",LocalDate.now(),LocalDate.now());
        safetystock.setSaid(1);
        safetystock.setSaconf("001");
        safetystock.setFid(1);
        safetystock.setSaname(120.00);
        safetystock.setAmount(120.00);
        safetystock.setMaxamount(120.00);
        safetystock.setRegister("张三");
        safetystock.setRegistertime(LocalDate.now());
        safetystock.setChecker("王五");
        safetystock.setChecktime(LocalDate.now());
        safetystock.setChecktag("A001-1");
        safetystock.setCreated(LocalDate.now());
        safetystock.setUpdated(LocalDate.now());
        System.out.println(safetystock);
        Boolean bool=safetystockService.insertSafetystock(safetystock);
        System.out.println(bool);
    }
    /*修改*/
    @Test
    void test4(){
        //根据id查询
        Safetystock safetystock=safetystockService.selectOneSafetystock(1);
        System.out.println(safetystock);
        //根据id修改
        safetystock.setChecker("小米");
        Boolean bool=safetystockService.updateSafetystock(safetystock);
        System.out.println(bool);
    }
    /*模糊查询*/
    @Test
    void test5(){
        Safetystock safetystock=new Safetystock();
        safetystock.setSaconf("1");
        safetystock.setSaname(120.00);
        safetystock.setChecktag("");
        safetystock.setRegister("");
        safetystock.setChecker("");
        Double amount1=1.00;
        Double amount2=200.00;
        Double maxamount1=1.00;
        Double maxamount2=200.00;
        List<Safetystock> list=safetystockService.likeSafetystock(safetystock,amount1,amount2,maxamount1,maxamount2);
        System.out.println(list);
    }
}
