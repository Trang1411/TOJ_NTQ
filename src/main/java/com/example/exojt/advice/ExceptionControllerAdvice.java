package com.example.exojt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        System.out.println("=========== USER SENT A BAD REQUEST ==================");
        exception.printStackTrace();
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}
