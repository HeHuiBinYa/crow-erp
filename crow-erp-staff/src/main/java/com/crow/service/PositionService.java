package com.crow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crow.model.Columnar;
import com.crow.model.Department;
import com.crow.model.Position;

import java.util.List;

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
    Boolean deletePosition(Integer pid);
    Boolean updatePosition(Position position);
    List<Position> selectPosition();
    IPage pagePosition(Integer size, Integer pageSize, Position position);
    Columnar[] columnarPosition();
}
