package com.example.extoj.service;

import com.example.extoj.dto.LoanBookDTO;
import com.example.extoj.repository.BookManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookmanagementServiceImpl implements BookManagementService{
    private final BookManagementRepository bookManagementRepository;


//    @Override
//    public LoanBookDTO save(LoanBookDTO loanBookDTO) {
//        return bookManagementRepository.save();
//    }
}
