package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.WarehousingMapper;
import com.crow.model.Warehousing;
import com.crow.model.WarehousingVo;
import com.crow.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/11:50
 * @Description:入库申请管理
 */
@Service
public class WarehousingServiceImpl implements WarehousingService {
    private WarehousingMapper warehousingMapper;

    @Autowired
    public WarehousingServiceImpl(WarehousingMapper warehousingMapper) {
        this.warehousingMapper = warehousingMapper;
    }

    @Override
    public Boolean insertWarehousing(Warehousing warehousing) {
        return warehousingMapper.insertWarehousing(warehousing);
    }

    @Override
    public Boolean updateWarehousingVo(Warehousing warehousing) {
        return warehousingMapper.updateWarehousingVo(warehousing);
    }

    @Override
    public Boolean updateWachecktag(Warehousing warehousing) {
        return warehousingMapper.updateWachecktag(warehousing);
    }

    @Override
    public Boolean updateWarehousing(Warehousing warehousing) {
        return warehousingMapper.updateWarehousing(warehousing);
    }

    @Override
    public IPage<Warehousing> examinePageWarehousing(Integer size, Integer sizePage) {
        if (size <= 0){
            size = 1;
        }
        Page page = new Page<>(size,sizePage);
        return warehousingMapper.examinePageWarehousing(page);
    }

    @Override
    public IPage<Warehousing> queryWarehousingVo(WarehousingVo warehousingVo) {
        if (warehousingVo.getSize() <= 0){
            warehousingVo.setSize(1);
        }

        Page page = new Page(warehousingVo.getSize(),warehousingVo.getSizePage());

        IPage<Warehousing> iPage = warehousingMapper.queryWarehousingVo(page,warehousingVo);

        return iPage;
    }
}
