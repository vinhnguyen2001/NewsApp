package com.springboot.service;

import com.springboot.dto.RoleDTO;


public interface IRoleService {


    public RoleDTO saveRole(RoleDTO role);
    public void addRoleToUser(String username, String rolename);

    public void removeRoleFromUser(String username, String rolename);
}
