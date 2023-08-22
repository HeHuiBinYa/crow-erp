package com.crow.service.impl;

import com.crow.mapper.DispatchMapper;
import com.crow.model.Dispatch;
import com.crow.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:DispatchServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/21 17:55
 * @Role
 */
@Service
public class DispatchServiceImpl implements DispatchService {
    private DispatchMapper dispatchMapper;

    @Autowired
    public DispatchServiceImpl(DispatchMapper dispatchMapper) {
        this.dispatchMapper = dispatchMapper;
    }

    @Override
    public Boolean insertDispatch(Dispatch dispatch) {
        return dispatchMapper.insertDispatch(dispatch);
    }
}
