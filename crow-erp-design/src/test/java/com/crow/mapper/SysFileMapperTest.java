package com.crow.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.SysFile;
import com.crow.model.SysFileVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysFileMapperTest {
    @Autowired
    private SysFileMapper sysFileMapper;


    @Test
    void test(){
        Page<SysFile> page = new Page<>(1,2);
        IPage<SysFile> sysFileIPage = sysFileMapper.queryPageSysFile(page);
        sysFileIPage.getRecords().forEach(System.out::println);
    }

    @Test
    void page(){
        Page page = new Page(1,2);

        SysFileVo sysFileVo = new SysFileVo();

        IPage<SysFile> fileVo = sysFileMapper.querySysFileVo(page,sysFileVo);

        fileVo.getRecords().forEach(System.out::println);
    }
}