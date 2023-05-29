package com.example.exojt.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TokenSession {
    private String userId;
    private String email;
    private String role;
}
