package com.example.exojt.payload.response;

import com.example.exojt.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private String role;

    public JwtResponse(String jwt, String id, String username, String email, Role role) {
    }
}
