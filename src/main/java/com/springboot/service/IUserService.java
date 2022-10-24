package com.springboot.service;

import com.springboot.dto.NewsDTO;
import com.springboot.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService extends UserDetailsService {

    public UserDTO save(UserDTO userDTO);

    public Boolean delete(long[] ids);

    public List<UserDTO> findAll(Pageable pageable);

    int totalItem();
}
