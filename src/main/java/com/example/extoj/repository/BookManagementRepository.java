package com.example.extoj.repository;

import com.example.extoj.entity.BookManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookManagementRepository extends MongoRepository<BookManagement, String> {
}
