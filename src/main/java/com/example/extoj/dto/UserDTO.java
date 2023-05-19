package com.example.extoj.dto;

import com.example.extoj.entity.Role;
import com.example.extoj.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
@Data
public class UserDTO {

//    @Value("${user.name}")
    private String name;

//    @Value("${user.email}")
    private String email;

//    @Value("${user.password}")
    private String password;

//    @Value("${user.role}")
    private Role role;


//    @Bean
//    public void info() {
//        User user = new User();
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setRole(role);
//        System.out.println(user);
//    }
}
