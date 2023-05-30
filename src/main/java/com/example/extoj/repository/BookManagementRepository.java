package com.example.extoj.repository;


import com.example.exojt.models.BookBorrowingManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookManagementRepository extends MongoRepository<BookBorrowingManagement, String> {
}
