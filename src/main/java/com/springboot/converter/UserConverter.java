package com.springboot.converter;

import com.springboot.dto.RoleDTO;
import com.springboot.dto.UserDTO;
import com.springboot.entity.NewsEntity;
import com.springboot.entity.RoleEntity;
import com.springboot.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {

    public UserEntity toEntity(UserDTO dto, UserEntity entity) {

        if(dto.getUsername() != null){
            entity.setUserName(dto.getUsername());
        }
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public UserDTO toDTO (UserEntity entity){

        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setUsername(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setStatus(entity.getStatus());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());

        for(RoleEntity elm:entity.getRoles()){
            dto.getRoles().add(elm.getName());
        }
        return dto;
    }
}
