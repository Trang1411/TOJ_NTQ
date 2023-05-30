package com.example.exojt.service.impl;

import com.example.exojt.models.Book;
import com.example.exojt.repository.BookRepository;
import com.example.exojt.service.base.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findByIdOrBookName(String keySearch, String conditionSort, int page, int size) {
        List<Book> books = bookRepository.findByIdOrBookName(keySearch, conditionSort, page, size);
        return books;
    }
}
