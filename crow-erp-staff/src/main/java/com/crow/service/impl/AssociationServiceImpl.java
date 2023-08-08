package com.crow.service.impl;

import com.crow.mapper.AssociationMapper;
import com.crow.model.Association;
import com.crow.service.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:AssociationServiceImpl
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/8 8:48
 * @Role
 */
@Service
@Transactional
public class AssociationServiceImpl implements AssociationService {
    private AssociationMapper associationMapper;

    @Autowired
    public AssociationServiceImpl(AssociationMapper associationMapper) {
        this.associationMapper = associationMapper;
    }

    @Override
    public Boolean insertAssociation(Association association) {
        return associationMapper.insertAssociation(association);
    }
}
