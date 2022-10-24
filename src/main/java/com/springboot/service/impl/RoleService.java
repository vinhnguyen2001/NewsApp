package com.springboot.service.impl;

import com.springboot.converter.RoleConverter;
import com.springboot.dto.RoleDTO;
import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleConverter roleConverter;

    @Override
    public RoleDTO saveRole(RoleDTO roleDTO) {

        RoleEntity roleEntity = new RoleEntity();
        roleEntity = roleConverter.toEntity(roleDTO,roleEntity);
        roleEntity = roleRepo.save(roleEntity);

        return roleConverter.toDTO(roleEntity);
    }

    @Override
    public void addRoleToUser(String username, String rolename) throws Exception {


        UserEntity userEntity = userRepo.findUserEntityByUserName(username);
        RoleEntity roleEntity = roleRepo.findRoleEntitiesByName(rolename);

        if(userEntity == null || roleEntity == null){
            throw new Exception("Invalid");
        }
        userEntity.getRoles().add(roleEntity);

        userRepo.save(userEntity);

    }

    @Override
    public void removeRoleFromUser(String username, String rolename){
        UserEntity userEntity = userRepo.findUserEntityByUserName(username);
        RoleEntity roleEntity = roleRepo.findRoleEntitiesByName(rolename);
        userEntity.getRoles().remove(roleEntity);

        userRepo.save(userEntity);

    }
}
