package com.springboot.service;

import com.springboot.dto.RoleDTO;


public interface IRoleService {


    public RoleDTO saveRole(RoleDTO role);
    public void addRoleToUser(String username, String rolename) throws Exception;

    public void removeRoleFromUser(String username, String rolename);
}
