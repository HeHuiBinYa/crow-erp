package com.crow.service.impl;

import com.crow.mapper.ManufactureMapper;
import com.crow.model.Manufacture;
import com.crow.model.Procedure;
import com.crow.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lx
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {
    @Autowired
    ManufactureMapper manufactureMapper;


    @Override
    public Boolean insertManufacture(Manufacture manufacture) {
        return manufactureMapper.insertManufacture(manufacture);
    }

    @Override
    public Boolean updateManufacture(Manufacture manufacture) {
        return manufactureMapper.updateManufacture(manufacture);
    }

    @Override
    public Boolean deleteManufactureById(Integer id) {
        return manufactureMapper.deleteManufactureById(id);
    }

    @Override
    public List<Manufacture> selectAllManufacture() {
        return manufactureMapper.selectAllManufacture();
    }

    @Override
    public Manufacture selectManufactureById(Integer id) {
        return manufactureMapper.selectManufactureById(id);
    }

    @Override
    public Manufacture selectAllManufactureByMapId(String id) {
        return manufactureMapper.selectAllManufactureByMapId(id);
    }

    @Override
    public Boolean updatemachecktagById(Integer id, String machecktag) {
        return manufactureMapper.updatemachecktagById(id,machecktag);
    }
}
