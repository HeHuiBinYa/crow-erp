package com.crow.service;

import com.crow.model.Manufacture;
import com.crow.model.Procedure;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lx
 */
public interface ManufactureService {
    /**添加
     *
     * @param manufacture
     * @return
     */
    Boolean insertManufacture(Manufacture manufacture);

    /**
     * 修改
     * @param manufacture
     * @return
     */
    Boolean updateManufacture(Manufacture manufacture);

    /**
     * 删除
     * @param id
     * @return
     */
    Boolean deleteManufactureById(@Param("id") Integer id);

    /**
     * 查询
     * @return
     */
    List<Manufacture> selectAllManufacture();

    /**
     * id查询
     * @param id
     * @return
     */
    Manufacture selectManufactureById(@Param("id") Integer id);


    /**通过产品id查询生产总表和工序
     *
     * @param id
     * @return
     */
    Manufacture selectAllManufactureByMapId(String id);

    /**
     * 通过生产总表id修改审核状态
     * @param id
     * @param machecktag
     * @return
     */
    Boolean updatemachecktagById(Integer id, String machecktag);


}
