package com.springboot.api;


import com.springboot.dto.RoleDTO;
import com.springboot.service.IRoleService;
import com.springboot.utils.RoleToUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoleAPI {

    @Autowired
    private IRoleService iRoleService;

    @PostMapping("/role")
    public RoleDTO createRole(@RequestBody RoleDTO role) {


        iRoleService.saveRole(role);
        return role;
    }

    @PostMapping("/role/assign-role")
    public Map<String,String> addRoleToUser(@RequestBody RoleToUserForm form) {
        Map<String, String> tokens = new HashMap<>();

        try {
            iRoleService.addRoleToUser(form.getUsername(), form.getRoleName());

            tokens.put("status", "success");
        }
        catch(Exception err){
            tokens.put("status", "fail");
        }

        return tokens;
    }

    @PutMapping("/role/assign-role")
    public Map<String,String> RemoveRoleFromUser(@RequestBody RoleToUserForm form) {
        Map<String, String> tokens = new HashMap<>();

        try {
            iRoleService.removeRoleFromUser(form.getUsername(), form.getRoleName());

            tokens.put("status", "success");
        }
        catch(Exception err){
            tokens.put("status", "fail");
        }

        return tokens;
    }
}
