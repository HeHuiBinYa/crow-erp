package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.SysHeroBMapper;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroB;
import com.crow.service.SysHeroBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysHeroBServiceImpl implements SysHeroBService {
    public SysHeroBMapper sysHeroBMapper;
    @Autowired
    public SysHeroBServiceImpl(SysHeroBMapper sysHeroBMapper){
        this.sysHeroBMapper=sysHeroBMapper;
    }
    @Override
    public Boolean addSysHeroB(SysHeroB sysHeroB) {
        return sysHeroBMapper.addSysHeroB(sysHeroB);
    }

    @Override
    public Boolean updateSysHeroB(SysHeroB sysHeroB) {
        return sysHeroBMapper.updateSysHeroB(sysHeroB);
    }

    @Override
    public List<SysHeroB> selectSysHeroBByBid(Integer bid) {
        return sysHeroBMapper.selectSysHeroBByBid(bid);
    }

    @Override
    public Boolean deleteSysHeroBByBid(Integer bid) {
        return sysHeroBMapper.deleteSysHeroBByBid(bid);
    }

    @Override
    public List<SysHeroB> selectSysHeroBList() {
        return sysHeroBMapper.selectSysHeroBList();
    }

    @Override
    public List<SysHeroB> selectSysHeroBUseAid(Integer aid) {
        return sysHeroBMapper.selectSysHeroBUseAid(aid);
    }

    @Override
    public IPage<SysHeroB> pageSysHeroB(String bname, Integer size, Integer sizePage) {
        Page<SysHeroA> page = new Page<>(size,sizePage);
        return sysHeroBMapper.pageSysHeroB(page,bname);
    }
}
