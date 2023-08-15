package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.SysHeroAMapper;
import com.crow.model.SysHeroA;
import com.crow.service.SysHeroAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysHeroAServiceImpl implements SysHeroAService {
    private SysHeroAMapper sysHeroAMapper;
    @Autowired
    public SysHeroAServiceImpl(SysHeroAMapper sysHeroAMapper){
        this.sysHeroAMapper=sysHeroAMapper;
    }
    @Override
    public Boolean addSysHeroA(SysHeroA sysHeroA) {
        return sysHeroAMapper.addSysHeroA(sysHeroA);
    }

    @Override
    public Boolean updateSysHeroA(SysHeroA sysHeroA) {
        return sysHeroAMapper.updateSysHeroA(sysHeroA);
    }

    @Override
    public SysHeroA selectSysHeroAByAid(Integer aid) {
        return sysHeroAMapper.selectSysHeroAByAid(aid);
    }

    @Override
    public Boolean deleteSysHeroAByAid(Integer aid) {
        return sysHeroAMapper.deleteSysHeroAByAid(aid);
    }

    @Override
    public List<SysHeroA> selectSysHeroAList() {
        return sysHeroAMapper.selectSysHeroAList();
    }

    @Override
    public IPage<SysHeroA> pageSysHeroA(String aname,Integer size,Integer sizePage) {
        Page<SysHeroA> page = new Page<>(size,sizePage);
        return sysHeroAMapper.pageSysHeroA(page,aname);
    }
}
