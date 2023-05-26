package com.example.exojt.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection = "user")
@NoArgsConstructor
@Configuration
public class User {
    @Id
    private String id;

    @Field("user_name")
    @NotBlank
    @Size(max = 50)
    private String username;

    @Field("email")
    @NotBlank
    @Size(max = 50)
    public String email;

    @Field("password")
    @NotBlank
    @Size(max = 120)
    private String password;

    //    @DBRef
//    private Set<Role> roles = new HashSet<>();
    @Field("role")
    private String role;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
