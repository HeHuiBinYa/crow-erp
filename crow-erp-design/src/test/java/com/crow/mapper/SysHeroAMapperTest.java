package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.SysHeroA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysHeroAMapperTest {
    @Autowired
    private SysHeroAMapper sysHeroAMapper;

    @Test
    void test(){
        Page page = new Page(1, 3);
        IPage<SysHeroA> sysHeroAIPage = sysHeroAMapper.pageSysHeroA(page,"2");
        System.out.println(sysHeroAIPage.getRecords());
    }
}