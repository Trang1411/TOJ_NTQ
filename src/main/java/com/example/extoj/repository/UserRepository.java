package com.example.extoj.repository;

import com.example.extoj.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
