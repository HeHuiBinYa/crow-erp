package com.crow.service;

import model.Safetystock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Jane706
 * @Date: 2023/08/02/9:45
 * @Description:安全库存配置管理
 */
public interface SafetystockService {
    Boolean insertSafetystock(Safetystock safetystock);
    Boolean deleteSafetystock(Integer said);
    Boolean updateSafetystock(Safetystock safetystock);
    List<Safetystock> SelectSafetystock();
    Safetystock selectOneSafetystock(Integer said);
    List<Safetystock> likeSafetystock(Safetystock safetystock,Double firstamount,Double lastamount,Double firstmaxamount,Double lastmaxamount);


}
