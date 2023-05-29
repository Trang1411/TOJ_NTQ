package com.example.exojt.controller;

import com.example.exojt.models.User;
import com.example.exojt.payload.request.LoginRequest;
import com.example.exojt.payload.response.JwtResponse;
import com.example.exojt.security.jwt.JwtUtils;
import com.example.exojt.service.base.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final JwtUtils jwtUtils;
    final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail(), loginRequest.getPassword());
        String token = jwtUtils.generateJwtToken(user);
        JwtResponse jwtResponse = JwtResponse.builder()
                .token(token)
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

//    @GetMapping("/logout")
//    public ResponseEntity logout(HttpServletRequest httpServletRequest){
//
//    }
}
