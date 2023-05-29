package com.example.exojt.repository;

import com.example.exojt.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findByIdOrBookName(String search, int page, int size);
}
