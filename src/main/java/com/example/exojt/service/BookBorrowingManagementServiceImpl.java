package com.example.exojt.service;

import com.example.exojt.models.BookBorrowingManagement;
import com.example.exojt.repository.BookBorrowingManagementRepository;
import com.example.exojt.repository.BookBorrowingManagementRepositoryImpl;
import com.example.exojt.service.base.BookBorrowingManagementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookBorrowingManagementServiceImpl implements BookBorrowingManagementService {
    private final BookBorrowingManagementRepository bookBorrowingManagementRepository;
    private final BookBorrowingManagementRepositoryImpl repository;


    @Override
    public BookBorrowingManagement findById(String id) {
        Optional<BookBorrowingManagement> optional = bookBorrowingManagementRepository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("NOT FOUND !");
        }
//        long startTime = optional.get().getStartTime();
//        long endTime = optional.get().getEndTime();
//        if (endTime == 0){
//            long now = startTime + 5*60*100; ?????
//        }
//        optional.get().setDuration();
        BookBorrowingManagement bookBorrowingManagement = optional.get();
        return bookBorrowingManagement;
    }

    @Override
    public BookBorrowingManagement save(BookBorrowingManagement borrowingManagement) {
        return bookBorrowingManagementRepository.save(borrowingManagement);
    }

    @Override
    public BookBorrowingManagement update(BookBorrowingManagement bookBorrowingManagement) {
        bookBorrowingManagementRepository.save(bookBorrowingManagement);
        return null;
    }

    @Override
    public List<BookBorrowingManagement> findByUserIdOrUserName(String keySearch, String condition, int page, int size) {
       List<BookBorrowingManagement> managements = repository.findByUserIdOrUserName(keySearch, condition, page, size);
        return managements;
    }
}
