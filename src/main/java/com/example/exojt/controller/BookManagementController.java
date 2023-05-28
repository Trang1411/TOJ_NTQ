package com.example.exojt.controller;

import com.example.exojt.service.BookManagementService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bookManagement")
@AllArgsConstructor
@PropertySource("application.properties")
public class BookManagementController {
    final private BookManagementService bookManagementService;

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

//    Response response = new Response();

//    public ResponseEntity<Response> createCardLoan(@RequestHeader("Authorization") String token, @RequestBody LoanBookDTO loanBookDTO) {
//        if (loanBookDTO.getUserId() == null || loanBookDTO.getUserId().isEmpty()) {
//            response.setMessage("userId cannot be null or empty.");
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//        if (loanBookDTO.getBookId() == null || loanBookDTO.getBookId().isEmpty()) {
//            response.setMessage("bookId cannot be null or empty.");
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//        if (loanBookDTO.getBookName() == null || loanBookDTO.getBookName().isEmpty()) {hnay
//            response.setMessage("book name cannot be null or empty.");
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
////        if (loanBookDTO.getCreator()) kiểm tra ctreator có phải ADMIN không (lấy từ token)
//        bookManagementService.save(loanBookDTO);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

}
