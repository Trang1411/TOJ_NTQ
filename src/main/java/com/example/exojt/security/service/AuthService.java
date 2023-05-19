package com.example.exojt.security.service;

import com.example.exojt.payload.request.LoginRequest;
import com.example.exojt.repository.UserRepository;
import com.example.exojt.security.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils twtUtils;
    private final CacheManager cacheManager;

    public ResponseEntity<?> signIn(LoginRequest signInRequest){
        try{

        }
    }


}
