package com.crow.service;

import com.crow.mapper.WarehousingMapper;
import model.Warehousing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/11:49
 * @Description:入库申请管理
 */
public interface WarehousingService {
    Boolean insertWarehousing(WarehousingMapper warehousing);
    Boolean deleteWarehousing(Integer waid);
    Boolean updateWarehousing(Warehousing warehousing);
    List<Warehousing> selectWarehousing();
    Warehousing selectOneWarehousing(Integer waid);


}
