package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroB;
import com.crow.model.SysHeroC;

import java.util.List;

public interface SysHeroCService {
    //添加三级分类
    Boolean addSysHeroC(SysHeroC sysHeroC);

    //修改三级分类
    Boolean updateSysHeroC(SysHeroC sysHeroC);

    //根据编号查询三级分类
    List<SysHeroC> selectSysHeroCByCid(Integer cid);

    //删除三级分类
    Boolean deleteSysHeroCByCid(Integer cid);

    //查询所有三级分类
    List<SysHeroC> selectSysHeroCList();

    List<SysHeroC> selectSysHeroCUseAid(Integer aid);

    List<SysHeroC> selectSysHeroCUseBid(Integer bid);

    IPage<SysHeroC> pageSysHeroC(String cname, Integer size, Integer sizePage);
}
