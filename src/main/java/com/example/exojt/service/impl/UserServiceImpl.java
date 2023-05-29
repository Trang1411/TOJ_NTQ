package com.example.exojt.service.impl;

import com.example.exojt.config.AccountRoot;
import com.example.exojt.models.User;
import com.example.exojt.repository.UserRepository;
import com.example.exojt.service.base.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final AccountRoot accountRoot;

    @Override
    public User findByEmail(String email, String password) {
        User root = accountRoot.getAccountRoot();
        if (root == null) {
            System.out.println("============= ACCOUNT ROOT NOT FOUND ==========");
            throw new RuntimeException("User not found !");
        }
        if (root.getEmail().equals(email)) {
            if (root.getPassword().equals(password)) {
                return root;
            } else {
                throw new RuntimeException("=========== ACCOUNT ROOT INVALID PASSWORD OR ACCOUNT ===========");
            }
        }
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            System.out.println("============= ACCOUNT ADMIN NOT FOUND ==========");
            throw new RuntimeException("User not found !");
        }
        User user = optionalUser.get();
        if (user.getPassword().equals(password)) {
            return user;
        }
        System.out.println("============= INVALID PASSWORD OR EMAIL ==========");
        throw new RuntimeException("USER NOT FOUND !");
    }

    @Override
    public User createAdmin(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("ACCOUNT EXISTS");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllAdmin() {
        List<User> users = userRepository.findByRole("ADMIN");
        return users;
    }

    @Override
    public void deleteById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("USER NOT FOUND !");
        }
        userRepository.deleteById(userId);
    }

}
