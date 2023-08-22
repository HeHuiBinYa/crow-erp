package com.crow.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.ProcedureMapper;
import com.crow.model.Procedure;
import com.crow.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lx
 */
@Service
public class ProcedureServiceImpl implements ProcedureService {
    ProcedureMapper procedureMapper;


    @Autowired
    public ProcedureServiceImpl(ProcedureMapper procedureMapper) {
        this.procedureMapper = procedureMapper;
    }



    @Override
    public Boolean insertProcedure(Procedure procedure) {
        return procedureMapper.insertProcedure(procedure);
    }

    @Override
    public Boolean updateProcedure(Procedure procedure) {
        return procedureMapper.updateProcedure(procedure);
    }

    @Override
    public Boolean deleteProcedureById(Integer id) {
        return procedureMapper.deleteProcedureById(id);
    }

    @Override
    public IPage pageProcedure(Integer size, Integer pageSize) {
        if (size <= 0){
            size = 1;
        }
        if (pageSize <= 0){
            pageSize = 1;
        }
        Page<Procedure> page = new Page<>(size,pageSize);
        IPage iPage= procedureMapper.selectAllProcedureByPage(page);
        return iPage;
    }


    @Override
    public Procedure selectProcedureById(Integer id) {
        return procedureMapper.selectProcedureById(id);
    }

    @Override
    public List<Procedure> selectLikeProcedureName(String procedurename) {
        if (procedurename!=null){procedurename="%"+procedurename+"%";}
        return procedureMapper.selectLikeProcedureName(procedurename);
    }

    @Override
    public IPage<Procedure> selectByPage(IPage<Procedure> page, Wrapper<Procedure> queryWrapper) {
        return null;
    }

    @Override
    public Boolean updateprocedurefinishtagById(Integer prid, String procedurefinishtag) {
        return procedureMapper.updateprocedurefinishtagById(prid,procedurefinishtag);
    }

    @Override
    public Boolean insertNowProcedure(Procedure procedure) {
        return procedureMapper.insertNowProcedure(procedure);
    }
}
