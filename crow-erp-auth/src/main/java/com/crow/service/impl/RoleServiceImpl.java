package com.crow.service.impl;

import com.crow.mapper.RoleMapper;
import com.crow.model.Role;
import com.crow.service.RoleService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:RoleServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/7/18 15:11
 * @Role
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> selectRoleList() {
        return roleMapper.selectRoleList();
    }
}
