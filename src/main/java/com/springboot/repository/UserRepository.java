package com.springboot.repository;

import com.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByUserName (String userName);

    UserEntity findUserEntityByUserNameAndStatus (String userName, Integer status);

}
