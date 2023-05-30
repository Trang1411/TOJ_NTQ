package com.example.exojt.payload.response;

import lombok.Data;

@Data
public class BookBorrowingManagementResponse {
    private String userName;
    private String email;
    private String bookName;
    private long startTime;
    private long endTime;
    private long duration; // không quá 10 ngày (5' = 1d)


}
