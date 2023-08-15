package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroA;


import java.util.List;

public interface SysHeroAService {
    //添加一级分类
    Boolean addSysHeroA(SysHeroA sysHeroA);

    //修改一级分类
    Boolean updateSysHeroA(SysHeroA sysHeroA);

    //根据编号查询一级分类
    SysHeroA selectSysHeroAByAid(Integer aid);

    //删除一级分类
    Boolean deleteSysHeroAByAid(Integer aid);

    //查询所有一级分类
    List<SysHeroA> selectSysHeroAList();

    IPage<SysHeroA> pageSysHeroA(String aname,Integer size,Integer sizePage);
}
