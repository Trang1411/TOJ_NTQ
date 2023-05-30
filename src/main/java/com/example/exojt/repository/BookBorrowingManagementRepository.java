package com.example.exojt.repository;

import com.example.exojt.models.BookBorrowingManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookBorrowingManagementRepository extends MongoRepository<BookBorrowingManagement, String> {
    BookBorrowingManagement findByEmail(String email);
}
