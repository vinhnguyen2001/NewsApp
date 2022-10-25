package com.springboot;

import com.springboot.dto.RoleDTO;
import com.springboot.dto.UserDTO;
import com.springboot.service.impl.RoleService;
import com.springboot.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {
	public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

//    @Bean
//    CommandLineRunner run(UserService userService, RoleService roleService){
//        return args -> {
//            RoleDTO roleDTO = new RoleDTO();
//            roleDTO.setCode("admin");
//            roleDTO.setName("ROLE_ADMIN");
//
//            roleService.saveRole(roleDTO);
//            roleDTO.setCode("user");
//            roleDTO.setName("ROLE_USER");
//            roleService.saveRole(roleDTO);
//
//            UserDTO admin = new UserDTO();
//
//            admin.setStatus(1);
//            admin.setUsername("admin");
//            admin.setPassword("1234");
//            admin.setFullName("ADMIN");
//            userService.save(admin);
//
//            roleService.addRoleToUser("admin","ROLE_ADMIN");
//        };
//    }
}

