package com.springboot.repository;

import com.springboot.dto.UserDTO;
import com.springboot.entity.NewsEntity;
import com.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByUserName (String username);
}
