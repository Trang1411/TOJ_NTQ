package com.example.exojt.payload.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Length(min = 8)
    private String password;
}
