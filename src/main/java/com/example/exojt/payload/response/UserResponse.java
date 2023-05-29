package com.example.exojt.payload.response;

import com.example.exojt.models.Role;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String userName;
    private String email;
    private Role role;
}
