package com.example.extoj.config;

import com.example.extoj.entity.Role;
import com.example.extoj.entity.User;
import com.example.extoj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class AccountRoot {
    @Value("${user.name}")
    private String name;

    @Value("${user.email}")
    private String email;

    @Value("${user.password}")
    private String password;

    @Value("${user.role}")
    private Role role;

    private UserRepository userRepository;

    public AccountRoot(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public User AccountRoot() {
        User userRootAdmin = new User();
        userRootAdmin.setName(name);
        userRootAdmin.setEmail(email);
        userRootAdmin.setPassword(password);
        userRootAdmin.setRole(role);
        return userRootAdmin;
    }
}
