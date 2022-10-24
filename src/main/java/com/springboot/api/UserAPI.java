package com.springboot.api;



import com.springboot.api.output.BaseOutput;
import com.springboot.dto.UserDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class UserAPI {

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


    @PostMapping(value="/user")
    public UserDTO createUser(@RequestBody UserDTO model) {

        return userService.save(model);
    }

    @PutMapping(value="/user/{id}")
    public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") Long id) {
        model.setId(id);
        return userService.save(model);
    }

    @DeleteMapping(value="/user")
    public Map<String,String> deleteUser(@RequestBody long[] ids){
        Map<String, String> tokens = new HashMap<>();

        if( userService.delete(ids) == true) {
            tokens.put("status", "success");
        }
        else{
            tokens.put("status", "fail");
        }
        return tokens;
    }
}
