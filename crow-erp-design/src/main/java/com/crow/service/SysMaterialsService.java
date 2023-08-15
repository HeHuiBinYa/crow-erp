package com.crow.service;

import com.crow.model.SysMaterials;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysMaterialsService {
    //增加产品物料组成
    Boolean addSysMaterials(SysMaterials sysMaterials);

    //删除产品物料组成
    Boolean deleteSysMaterialsByMid(Integer mid);

    //修改产品物料组成
    Boolean updateSysMaterials(SysMaterials sysMaterials);


    //查询所有产品物料组成
    List<SysMaterials> selectSysMaterialsList();
}
