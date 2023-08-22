package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.ManufactureMapper;
import com.crow.model.Manufacture;
import com.crow.model.Procedure;
import com.crow.model.vo.ManufactureVo;
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

    @Override
    public Page<Manufacture> queryPageManufacture(Integer size, Integer sizePage) {
        if (size <= 0){
            size = 1;
        }
        Page<Manufacture> page = new Page<>(size,sizePage);
        return manufactureMapper.queryPageManufacture(page);
    }

    @Override
    public Boolean updateExamine(Manufacture manufacture) {
        return manufactureMapper.updateExamine(manufacture);
    }

    @Override
    public Page<Manufacture> queryPageManufactureFinished(Integer size, Integer sizePage) {
        if (size <= 0){
            size = 1;
        }
        Page page = new Page(size,sizePage);
        return manufactureMapper.queryPageManufactureFinished(page);
    }

    @Override
    public Boolean manufactureComplete(Manufacture manufacture) {
        return manufactureMapper.manufactureComplete(manufacture);
    }

    @Override
    public IPage<Manufacture> queryManufactureVo(ManufactureVo manufactureVo) {
        if (manufactureVo.getSize() <= 0){
            manufactureVo.setSize(1);
        }

        Page page = new Page(manufactureVo.getSize(),manufactureVo.getSizePage());

        IPage<Manufacture> iPage = manufactureMapper.queryManufactureVo(page, manufactureVo);

        return iPage;
    }
}
