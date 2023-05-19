package com.example.extoj.dto;

import lombok.Data;

@Data
public class LoanBookDTO {
    private String userId;
    private String bookId;
    private String bookName;
    private long loanDate;
    private String creator;
}
