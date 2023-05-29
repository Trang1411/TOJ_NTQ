package com.example.exojt.controller;

import com.example.exojt.models.ERole;
import com.example.exojt.models.Password;
import com.example.exojt.models.TokenSession;
import com.example.exojt.models.User;
import com.example.exojt.security.jwt.JwtUtils;
import com.example.exojt.service.base.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.CharacterData;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/createAdmin")
    public ResponseEntity<User> createAdmin(@RequestHeader("Authorization") String token, @RequestParam(value = "email") String email) {
        TokenSession session = jwtUtils.parseToken(token);
        if (session.getRole().equals("USER") || session.getRole().equals("ADMIN")){
            throw new RuntimeException("UnAuthorization !");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(Password.generateRandomPassword());
        System.out.println(user.getPassword());
        userService.createAdmin(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllAdmin")
    public ResponseEntity<List> getAllAdmin(@RequestHeader("Authorization") String token) {
        TokenSession session = jwtUtils.parseToken(token);
        if (session.getRole().equals("USER") || session.getRole().equals("ADMIN")) {
            throw new RuntimeException("UnAuthorization !");
        }
        List<User> userList = userService.findAllAdmin();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @DeleteMapping("/deleteAdmin")
    public ResponseEntity<User> deleteAdmin(@RequestHeader("Authorization") String token, @RequestParam(value = "userId") String userId){
        TokenSession session = jwtUtils.parseToken(token);
        if (session.getRole().equals("USER") || session.getRole().equals("ADMIN")){
            throw new RuntimeException("UnAuthorization !");
        }
        userService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
