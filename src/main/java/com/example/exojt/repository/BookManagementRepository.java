package com.example.exojt.repository;

import com.example.exojt.models.BookManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookManagementRepository extends MongoRepository<BookManagement, String> {
}
