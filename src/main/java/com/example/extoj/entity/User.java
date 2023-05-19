package com.example.extoj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.beans.factory.annotation.Value;

@Data
@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class User {
    @Id
    private String id;

    @Field("user_name")
//    @Value("${user.name}")
    private String name;

    @Field("email")
//    @Value("${user.email}")
    public String email;

    @Field("password")
//    @Value("${user.password}")
    private String password;

    @Field("role")
//    @Value("${user.role}")
    private Role role;


}
