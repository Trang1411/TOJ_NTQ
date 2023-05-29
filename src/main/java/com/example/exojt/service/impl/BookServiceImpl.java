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
    public List<Book> findByIdOrBookName(String keySearch, int page, int size) {
        bookRepository.findByIdOrBookName(keySearch, page, size);
        return null;
    }
}
