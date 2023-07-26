package com.crow.service.impl;

import com.crow.model.Role;
import com.crow.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test
    void role(){
        List<Role> roles = roleService.selectRoleList();

        roles.forEach(System.out::println);
    }

    @Test
    void uuid(){
        System.out.println(UUID.randomUUID());
    }
}