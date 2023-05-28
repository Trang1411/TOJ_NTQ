package com.example.exojt.repository;

import com.example.exojt.models.ERole;
import com.example.exojt.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
