package com.springboot.dto;

import com.springboot.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends BaseDTO<UserDTO> {

    private String username;
    private String fullName;
    private String password;
    private int status;

    private List<RoleDTO> roles = new ArrayList<>();

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
