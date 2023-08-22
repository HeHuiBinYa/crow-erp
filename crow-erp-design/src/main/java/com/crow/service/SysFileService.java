package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysFile;
import com.crow.model.SysFileVo;
import org.apache.ibatis.annotations.Param;


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

    // 审核分页
    IPage<SysFile> queryPageSysFile(Integer size,Integer sizePage);

    // 审核提交
    Boolean examineSysFile(SysFile sysFile);

    /**
     * 查询所有档案
     * @return
     */
    List<SysFile> queryFileList();

    IPage<SysFile> querySysFileVo(Integer size,Integer sizePage,SysFileVo sysFileVo);
    Boolean updateFile(SysFile sysFile);
    Boolean updateCheckTag(Integer fid);
}

