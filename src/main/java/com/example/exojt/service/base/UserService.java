package com.example.exojt.service.base;

import com.example.exojt.models.User;

import java.util.List;

public interface UserService {

    User findByEmail(String email, String password);

    User createAdmin(User user);
    List<User> findAllAdmin();
    void deleteById(String userId);
}
