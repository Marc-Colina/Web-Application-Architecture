package com.example.waa_lab_5.service.impl;

import com.example.waa_lab_5.entity.Role;
import com.example.waa_lab_5.repo.IRoleRepo;
import com.example.waa_lab_5.service.spec.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepo iRoleRepo;

    public RoleServiceImpl(IRoleRepo iRoleRepo) {
        this.iRoleRepo = iRoleRepo;
    }

    @Override
    public List<Role> findAll() {
        return iRoleRepo.findAll();
    }
}
