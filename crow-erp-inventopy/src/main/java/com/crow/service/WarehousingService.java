package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Scheduling;
import com.crow.model.Warehousing;
import com.crow.model.WarehousingVo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/11:49
 * @Description:入库申请管理
 */
public interface WarehousingService {
    Boolean insertWarehousing(Warehousing warehousing);
    Boolean updateWarehousingVo(Warehousing warehousing);
    Boolean updateWachecktag(Warehousing warehousing);
    Boolean updateWarehousing(Warehousing warehousing);
    IPage<Warehousing> examinePageWarehousing(Integer size,Integer sizePage);
    IPage<Warehousing> queryWarehousingVo(WarehousingVo warehousingVo);
}
