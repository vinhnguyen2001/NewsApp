package com.springboot.converter;

import com.springboot.dto.RoleDTO;
import com.springboot.dto.UserDTO;
import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class RoleConverter {

    public RoleEntity toEntity(RoleDTO dto, RoleEntity entity) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }

    public RoleDTO toDTO (RoleEntity entity){

        RoleDTO dto = new RoleDTO();

        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }
}
