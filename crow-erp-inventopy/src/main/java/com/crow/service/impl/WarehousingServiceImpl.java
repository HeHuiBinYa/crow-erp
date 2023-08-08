package com.crow.service.impl;

import com.crow.mapper.WarehousingMapper;
import com.crow.service.WarehousingService;
import model.Warehousing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/11:50
 * @Description:入库申请管理
 */
@Service
public class WarehousingServiceImpl implements WarehousingService {
    @Autowired
    private WarehousingMapper warehousingMapper;

    @Override
    public Boolean insertWarehousing(WarehousingMapper warehousing) {
        return warehousingMapper.insertWarehousing(warehousing);
    }

    @Override
    public Boolean deleteWarehousing(Integer waid) {
        return warehousingMapper.deleteWarehousing(waid);
    }

    @Override
    public Boolean updateWarehousing(Warehousing warehousing) {
        return warehousingMapper.updateWarehousing(warehousing);
    }

    @Override
    public List<Warehousing> selectWarehousing() {
        return warehousingMapper.selectWarehousing();
    }

    @Override
    public Warehousing selectOneWarehousing(Integer waid) {
        return warehousingMapper.selectOneWarehousing(waid);
    }
}
