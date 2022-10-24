package com.springboot.repository;

import com.springboot.dto.UserDTO;
import com.springboot.entity.NewsEntity;
import com.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByUserName (String userName);

    UserEntity findUserEntityByUserNameAndStatus (String userName, Integer status);

}
