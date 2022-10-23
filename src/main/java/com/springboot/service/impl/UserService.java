package com.springboot.service.impl;

import com.springboot.converter.UserConverter;
import com.springboot.dto.UserDTO;
import com.springboot.entity.UserEntity;
import com.springboot.repository.UserRepository;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepo;


    @Autowired
    private UserConverter userConverter ;


    @Override
    public UserDTO save(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        if(userDTO.getId()!=null){

            UserEntity oldUserEntity = userRepo.findOne(userDTO.getId());
            userEntity = userConverter.toEntity(userDTO,oldUserEntity);

        }
        else{
            userEntity =  userConverter.toEntity(userDTO,userEntity);
        }

        userEntity = userRepo.save(userEntity);
        return userConverter.toDTO(userEntity);

    }

    @Override
    public Boolean delete(long[] ids) {

        for(long id:ids){
            UserEntity oldUserEntity = userRepo.findOne(id);
            oldUserEntity.setStatus(0);
            userRepo.save(oldUserEntity);
        }

        return true;
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> entities = userRepo.findAll(pageable).getContent();

        for(UserEntity item: entities) {
            UserDTO userDTO = userConverter.toDTO(item);
            results.add(userDTO);
        }

        return results;
    }

    @Override
    public int totalItem() {
        return (int) userRepo.count();
    }
}
