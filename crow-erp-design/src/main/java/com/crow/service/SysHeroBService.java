package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroB;

import java.util.List;

public interface SysHeroBService {
    //添加二级分类
    Boolean addSysHeroB(SysHeroB sysHeroB);

    //修改二级分类
    Boolean updateSysHeroB(SysHeroB sysHeroB);

    //根据编号查询二级分类
    List<SysHeroB> selectSysHeroBByBid(Integer bid);

    //删除二级分类
    Boolean deleteSysHeroBByBid(Integer bid);

    //查询所有二级分类
    List<SysHeroB> selectSysHeroBList();

    List<SysHeroB> selectSysHeroBUseAid(Integer aid);

    IPage<SysHeroB> pageSysHeroB(String bname, Integer size, Integer sizePage);
}
