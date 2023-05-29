package com.example.exojt.service.base;

import com.example.exojt.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findByIdOrBookName(String search, int page, int size);
}
