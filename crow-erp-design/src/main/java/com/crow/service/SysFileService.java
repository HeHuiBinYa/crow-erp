package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysFile;


import java.util.List;

public interface SysFileService {
    //添加产品档案
    Boolean addSysFile(SysFile sysFile);

    //根据fid删除产品档案
    Boolean deleteSysFileByFid(Integer fid);

    //修改产品档案
    Boolean updateSysFile(SysFile sysFile);

    //更据id查询产品档案
    SysFile selectSysFileByFid(Integer fid);

    //查询所有商品档案
    List<SysFile> selectSysFileList();

    // 审核分页
    IPage<SysFile> queryPageSysFile(Integer size,Integer sizePage);

    // 审核提交
    Boolean examineSysFile(SysFile sysFile);
}

