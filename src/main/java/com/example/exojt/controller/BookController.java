package com.example.exojt.controller;

import com.example.MappingCustom.AuthorizationAPI;
import com.example.exojt.models.Book;
import com.example.exojt.security.jwt.JwtUtils;
import com.example.exojt.service.base.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final JwtUtils jwtUtils;

    @GetMapping("/search")
    @AuthorizationAPI(roles = {"ROOT","ADMIN"})
    public ResponseEntity<List> searchBook(@RequestParam(value = "keySearch", required = false, defaultValue = "") String keySearch,
                                           @RequestParam(value = "conditionSort", defaultValue = "PRICE") String conditionSort,
                                           @RequestParam(value = "page")int page, @RequestParam(value = "size") int size){
        List<Book> books = bookService.findByIdOrBookName(keySearch, conditionSort, page, size);
        return  ResponseEntity.status(HttpStatus.OK).body(books);
    }

}
