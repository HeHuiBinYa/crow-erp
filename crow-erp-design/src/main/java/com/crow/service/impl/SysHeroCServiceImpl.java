package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.SysHeroCMapper;
import com.crow.model.SysHeroA;
import com.crow.model.SysHeroC;
import com.crow.service.SysHeroCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysHeroCServiceImpl implements SysHeroCService {
    public SysHeroCMapper sysHeroCMapper;
    @Autowired
    private SysHeroCServiceImpl(SysHeroCMapper sysHeroCMapper){
        this.sysHeroCMapper=sysHeroCMapper;
    }
    @Override
    public Boolean addSysHeroC(SysHeroC sysHeroC) {
        return sysHeroCMapper.addSysHeroC(sysHeroC);
    }

    @Override
    public Boolean updateSysHeroC(SysHeroC sysHeroC) {
        return sysHeroCMapper.updateSysHeroC(sysHeroC);
    }

    @Override
    public  List<SysHeroC> selectSysHeroCByCid(Integer cid) {
        return sysHeroCMapper.selectSysHeroCByCid(cid);
    }

    @Override
    public Boolean deleteSysHeroCByCid(Integer cid) {
        return sysHeroCMapper.deleteSysHeroCByCid(cid);
    }

    @Override
    public List<SysHeroC> selectSysHeroCList() {
        return sysHeroCMapper.selectSysHeroCList();
    }

    @Override
    public List<SysHeroC> selectSysHeroCUseAid(Integer aid) {
        return sysHeroCMapper.selectSysHeroCUseAid(aid);
    }

    @Override
    public List<SysHeroC> selectSysHeroCUseBid(Integer bid) {
        return sysHeroCMapper.selectSysHeroCUseBid(bid);
    }

    @Override
    public IPage<SysHeroC> pageSysHeroC(String cname, Integer size, Integer sizePage) {
        Page<SysHeroC> page = new Page<>(size,sizePage);
        return sysHeroCMapper.pageSysHeroC(page,cname);
    }
}
