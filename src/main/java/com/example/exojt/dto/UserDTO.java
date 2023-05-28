package com.example.exojt.dto;

import com.example.exojt.models.Role;
import lombok.Data;

@Data
public class UserDTO {

    private String name;

    private String email;

    private String password;

    private Role role;


}
