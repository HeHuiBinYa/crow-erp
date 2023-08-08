package com.crow.service.impl;

import com.crow.mapper.SafetystockMapper;
import com.crow.service.SafetystockService;
import model.Safetystock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/9:48
 * @Description:安全库存配置管理
 */
@Service
public class SafetystockServiceImpl implements SafetystockService {
    @Autowired
    private SafetystockMapper safetystockMapper;

    @Override
    public Boolean insertSafetystock(Safetystock safetystock) {
        return safetystockMapper.insertSafetystock(safetystock);
    }

    @Override
    public Boolean deleteSafetystock(Integer said) {
        return safetystockMapper.deleteSafetystock(said);
    }

    @Override
    public Boolean updateSafetystock(Safetystock safetystock) {
        return safetystockMapper.updateSafetystock(safetystock);
    }

    @Override
    public List<Safetystock> SelectSafetystock() {
        return safetystockMapper.SelectSafetystock();
    }

    @Override
    public Safetystock selectOneSafetystock(Integer said) {
        return safetystockMapper.selectOneSafetystock(said);
    }

    @Override
    public List<Safetystock> likeSafetystock(Safetystock safetystock, Double firstamount, Double lastamount, Double firstmaxamount, Double lastmaxamount) {
        return safetystockMapper.likeSafetystock(safetystock,firstamount,lastamount,firstmaxamount,lastmaxamount);
    }


}
