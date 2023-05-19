package com.example.exojt.security.service;

import com.example.exojt.repository.BookManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookmanagementServiceImpl implements BookManagementService {
    private final BookManagementRepository bookManagementRepository;


//    @Override
//    public LoanBookDTO save(LoanBookDTO loanBookDTO) {
//        return bookManagementRepository.save();
//    }
}
