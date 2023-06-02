package com.example.exojt.payload.request;

import lombok.Data;

@Data
public class BookBorrowingManagementRequest {
    private String id;
    private String userName;
    private String email;
    private String bookName;
    private long startTime;
    private long endTime;
    private long duration;
}
