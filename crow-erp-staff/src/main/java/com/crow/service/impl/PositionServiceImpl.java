package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.PositionMapper;
import com.crow.model.Department;
import com.crow.model.Position;
import com.crow.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:PositionServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/6 16:29
 * @Role
 */
@Service
public class PositionServiceImpl implements PositionService {
    private PositionMapper positionMapper;

    @Autowired
    public PositionServiceImpl(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    @Override
    public Boolean insertPosition(Position position) {
        return positionMapper.insertPosition(position);
    }

    @Override
    public Boolean updatePosition(Position position) {
        return positionMapper.updateDepatment(position);
    }

    @Override
    public IPage pagePosition(Integer size, Integer pageSize, Position position) {
        if (size <= 0){
            size = 1;
        }
        if (pageSize <= 0){
            pageSize = 1;
        }
        Page<Department> page = new Page<>(size,pageSize);
        IPage iPage = positionMapper.pagePosition(page,position);
        return iPage;
    }
}
