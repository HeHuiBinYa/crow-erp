package com.crow.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.model.Procedure;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lx
 */
public interface ProcedureService {
    /**
     * 添加
     * @param procedure
     * @return
     */
    Boolean insertProcedure(Procedure procedure);

    /**
     * 修改
     * @param procedure
     * @return
     */
    Boolean updateProcedure(Procedure procedure);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean deleteProcedureById(Integer id);

    /**查询
     *
     * @param size
     * @param pageSize
     * @return
     */
    IPage pageProcedure(Integer size, Integer pageSize);

    /**
     * id查询
     * @param id
     * @return
     */
    Procedure selectProcedureById(Integer id);

    /**
     * 生产工序模糊查询
     * @param procedurename
     * @return
     */
    List<Procedure> selectLikeProcedureName(String procedurename);


    /**
     * 条件分页查询
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<Procedure> selectByPage(IPage<Procedure> page, Wrapper<Procedure> queryWrapper);

    /**
     * 通过id修改审核状态
     * @param prid
     * @param procedurefinishtag
     * @return
     */
    Boolean updateprocedurefinishtagById(Integer prid, String procedurefinishtag);

    Boolean insertNowProcedure(Procedure procedure);
}
