package com.example.exojt.service.base;

import com.example.exojt.models.User;

public interface UserService {

    User findByEmail(String email, String password);
}
