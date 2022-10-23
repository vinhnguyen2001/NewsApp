package com.springboot.dto;

import com.springboot.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends BaseDTO<RoleDTO> {

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
