package com.example.exojt.config;

import com.example.exojt.models.Role;
import com.example.exojt.models.User;
import com.example.exojt.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties
public class AccountRoot {
    @Value("${user.username}")
    private String name;

    @Value("${user.email}")
    private String email;

    @Value("${user.password}")
    private String password;

    @Value("${user.role}")
    private String role;

    private UserRepository userRepository;

    public AccountRoot(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public User getAccountRoot() {
        User userRootAdmin = new User();
        userRootAdmin.setId(String.valueOf(new ObjectId()));
        userRootAdmin.setUsername(name);
        userRootAdmin.setEmail(email);
        userRootAdmin.setPassword(password);
        userRootAdmin.setRole(role);
//        userRepository.save(userRootAdmin);
        return userRootAdmin;
    }
}
