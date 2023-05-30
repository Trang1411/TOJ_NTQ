package com.example.exojt.service.base;

import com.example.exojt.models.BookBorrowingManagement;

import java.util.List;

public interface BookBorrowingManagementService {
    BookBorrowingManagement findById(String id);

    BookBorrowingManagement save(BookBorrowingManagement borrowingManagement);

    BookBorrowingManagement update(BookBorrowingManagement bookBorrowingManagement);

    List<BookBorrowingManagement> findByUserIdOrUserName(String keySearch, String condition, int page, int size);
}
