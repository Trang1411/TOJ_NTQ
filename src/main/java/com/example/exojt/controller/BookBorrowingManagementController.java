package com.example.exojt.controller;

import com.example.exojt.models.BookBorrowingManagement;
import com.example.exojt.models.TokenSession;
import com.example.exojt.payload.request.BookBorrowingManagementRequest;
import com.example.exojt.payload.response.BookBorrowingManagementResponse;
import com.example.exojt.security.jwt.JwtUtils;
import com.example.exojt.service.base.BookBorrowingManagementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/BookBorrowingManagement")
@AllArgsConstructor
public class BookBorrowingManagementController {
    final private BookBorrowingManagementService bookBorrowingManagementService;

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final JwtUtils jwtUtils;
    private final ModelMapper mapper;

    @PutMapping("/update")
    public ResponseEntity<BookBorrowingManagementResponse> update(@RequestHeader("Authorization") String token, @RequestBody() BookBorrowingManagementRequest request) {
        TokenSession session = jwtUtils.parseToken(token);
        if (session.getRole().equals("USER")) {
            throw new RuntimeException("UnAuthorization !");
        }
        if (request == null) {
            throw new RuntimeException("REQUEST NULL !");
        }

       BookBorrowingManagement management = bookBorrowingManagementService.findById(request.getId());

        management.setBookName(request.getBookName());
        management.setUserName(request.getUserName());
        management.setEmail(request.getEmail());
        management.setStartTime(request.getStartTime());
        management.setEndTime(request.getEndTime());
        management.setDuration(request.getDuration());
        bookBorrowingManagementService.save(management);
        BookBorrowingManagementResponse response = mapper.map(management, BookBorrowingManagementResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/searchUser")
    public ResponseEntity<List> searchUser(@RequestHeader("Authorization") String token,
                                           @RequestParam(value = "keySearch", required = false) String keySearch,
                                           @RequestParam(value = "condition", defaultValue = "BOOK_NAME") String condition,
                                           @RequestParam(value = "page") int page,
                                           @RequestParam(value = "size") int size){
        TokenSession session = jwtUtils.parseToken(token);
        if (session.getRole().equals("USER")){
            throw new RuntimeException("UnAuthorization !");
        }
        List<BookBorrowingManagement> bookBorrowingManagements = bookBorrowingManagementService.findByUserIdOrUserName(keySearch, condition, page, size);
        List<BookBorrowingManagementResponse> responses = bookBorrowingManagements.stream()
                        .map(response -> mapper.map(response, BookBorrowingManagementResponse.class))
                                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

}
