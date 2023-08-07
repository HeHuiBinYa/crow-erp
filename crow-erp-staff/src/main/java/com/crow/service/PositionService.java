package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Department;
import com.crow.model.Position;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:PositionService
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/6 16:29
 * @Role
 */
public interface PositionService {
    Boolean insertPosition(Position position);
    IPage pagePosition(Integer size, Integer pageSize, Position position);
}