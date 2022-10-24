package com.springboot.api.user;



import com.springboot.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserAccountAPI {

    @Autowired
    private IUserService userService;


    @PostMapping(value="/user")
    public Map<String,String> createUser(@RequestBody UserDTO model) {

        Map<String, String> tokens = new HashMap<>();
        try {

            if (!userService.isExist(model.getUsername())) {
                UserDTO userDTO = userService.save(model);
                tokens.put("success_message","register account succeed");
            }
            else {
                tokens.put("error_message","username is exist");
            }
            return tokens;
        }
        catch (Exception err){
            tokens.put("error_message","register account fail");
            return tokens;
        }


    }

    @PutMapping(value="/user/{id}")
    public Map<String,String>  updateUser(@RequestBody UserDTO model, @PathVariable("id") Long id) {

        Map<String, String> tokens = new HashMap<>();
        try {

            if (!userService.isExist(model.getUsername())) {
                model.setId(id);
                UserDTO userDTO = userService.save(model);
                tokens.put("success_message","update account succeed");
            }
            else {
                tokens.put("error_message","username is exist");
            }
            return tokens;
        }
        catch (Exception err){
            tokens.put("error_message","update account fail");
            return tokens;
        }

    }


}
