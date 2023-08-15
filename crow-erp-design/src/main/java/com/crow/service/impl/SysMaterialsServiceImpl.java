package com.crow.service.impl;

import com.crow.mapper.SysMaterialsMapper;
import com.crow.model.SysMaterials;
import com.crow.service.SysMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMaterialsServiceImpl implements SysMaterialsService {
    public SysMaterialsMapper sysMaterialsMapper;
    @Autowired
    private SysMaterialsServiceImpl(SysMaterialsMapper sysMaterialsMapper){
        this.sysMaterialsMapper=sysMaterialsMapper;
    }
    @Override
    public Boolean addSysMaterials(SysMaterials sysMaterials) {
        return sysMaterialsMapper.addSysMaterials(sysMaterials);
    }

    @Override
    public Boolean deleteSysMaterialsByMid(Integer mid) {
        return sysMaterialsMapper.deleteSysMaterialsByMid(mid);
    }

    @Override
    public Boolean updateSysMaterials(SysMaterials sysMaterials) {
        return sysMaterialsMapper.updateSysMaterials(sysMaterials);
    }

    @Override
    public List<SysMaterials> selectSysMaterialsList() {
        return sysMaterialsMapper.selectSysMaterialsList();
    }
}
