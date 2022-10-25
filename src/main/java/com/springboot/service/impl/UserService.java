package com.springboot.service.impl;

import com.springboot.converter.UserConverter;
import com.springboot.dto.UserDTO;
import com.springboot.entity.UserEntity;
import com.springboot.repository.UserRepository;
import com.springboot.service.IRoleService;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepo;


    @Autowired
    private UserConverter userConverter;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService roleService;
    @Override
    public UserDTO save(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        // occur when user update info
        if (userDTO.getId() != null) {
            UserEntity oldUserEntity = userRepo.findOne(userDTO.getId());
            userEntity = userConverter.toEntity(userDTO, oldUserEntity);
        } else {
            userEntity = userConverter.toEntity(userDTO, userEntity);
        }

        userEntity.setStatus(1);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity = userRepo.save(userEntity);

        try {
            // set ROLE_USER for account is user
            roleService.addRoleToUser(userEntity.getUserName(),"ROLE_USER");

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return userConverter.toDTO(userRepo.findOne(userEntity.getId()));

    }

    @Override
    public Boolean delete(long[] ids) {

        for (long id : ids) {
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

        for (UserEntity item : entities) {
            UserDTO userDTO = userConverter.toDTO(item);
            results.add(userDTO);
        }

        return results;
    }

    @Override
    public Long findOneByUsername(String username) {
        return userRepo.findUserEntityByUserName(username).getId();
    }

    @Override
    public Boolean isExist(String username) {

        UserEntity userEntity = userRepo.findUserEntityByUserName(username);

        return userEntity != null;
    }

    @Override
    public int totalItem() {
        return (int) userRepo.count();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findUserEntityByUserNameAndStatus(username,1);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found in the database");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(userEntity.getUserName(),
                userEntity.getPassword(),authorities);

    }
}
