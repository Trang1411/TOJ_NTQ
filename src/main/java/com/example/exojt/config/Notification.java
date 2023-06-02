package com.example.exojt.config;

import com.example.exojt.models.BookBorrowingManagement;
import com.example.exojt.repository.BookBorrowingManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Notification {
    private final BookBorrowingManagementRepository bookBorrowingManagementRepository;

    @Scheduled(initialDelay = 1000*60*5, fixedRate = 1000*60*10)
    public void run() {
        System.out.println("============== RUNNING ===============");
        long now = System.currentTimeMillis();
        List<BookBorrowingManagement> borrowingManagementList =bookBorrowingManagementRepository.findAll();
        for (BookBorrowingManagement list : borrowingManagementList) {
            long duration = now - list.getStartTime();
            list.setDuration(duration);
            long max = 10*5*60*1000; //(đơn vị ms)
            if (duration > max) {
                System.out.printf("User có ID %d, tên %s, sách %s, Đã hết thời lượng mượn.", list.getUserId(), list.getUserName(), list.getBookName());
                list.setStatus("EXPIRES");
                System.out.println();
            }else {
                long remain = (max - duration)/(1000*60*5);
                System.out.printf("User có ID %d, tên %s, sách %s, còn lại %d ngày mượn.", list.getUserId(), list.getUserName(), list.getBookName(), remain);
                list.setStatus("...");
                System.out.println();
            }

        }
    }
}
