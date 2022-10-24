package com.springboot.api.admin;


import com.springboot.api.output.BaseOutput;
import com.springboot.dto.UserDTO;
import com.springboot.service.IRoleService;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/")
public class AdminAccountAPI {

    @Autowired
    private IUserService userService;



    @GetMapping(value="/users")
    public BaseOutput createNews(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit,
                                 @RequestParam("sort") String sort) {


        BaseOutput<UserDTO> result = new BaseOutput();
        result.setPage(page);
        Pageable pageable  = new PageRequest(page - 1, limit, Sort.Direction.DESC, sort);
        result.setListResults(userService.findAll(pageable));
        result.setTotalPage((int)Math.ceil((double) userService.totalItem() / limit));

        return result;
    }


    @DeleteMapping(value="/user")
    public Map<String,String> deleteUser(@RequestBody long[] ids){


        Map<String, String> tokens = new HashMap<>();

        try {
            if (userService.delete(ids) == true) {
                tokens.put("success_message", "delete account succeed");
            } else {
                tokens.put("error_message", "delete account fail");
            }
            return tokens;
        }
        catch(Exception err){
            tokens.put("error_message", "delete account fail");
            return tokens;
        }
    }

}
