package com.example.exojt.repository;

import com.example.exojt.models.BookBorrowingManagement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookBorrowingManagementRepositoryImpl {
    private MongoTemplate mongoTemplate;

    public List<BookBorrowingManagement> findByUserIdOrUserName(String search, String condition, int page, int size) {
        Query searchQuery = new Query();
        if (search != null || !search.isEmpty()) {
            Criteria orCriteria = new Criteria().orOperator(
                    Criteria.where(BookBorrowingManagement.USER_ID).regex(search),
                    Criteria.where(BookBorrowingManagement.USER_NAME).regex(search));
            searchQuery.addCriteria(orCriteria);
        }
        if (condition.equals("BOOK_NAME")){
            searchQuery.with(Sort.by(Sort.Direction.ASC, BookBorrowingManagement.BOOK_NAME));
        }else if(condition.equals("START_TIME")){
            searchQuery.with(Sort.by(Sort.Direction.DESC, BookBorrowingManagement.START_TIME));
        }else {
            searchQuery.with(Sort.by(Sort.Direction.ASC, BookBorrowingManagement.DURATION));
        }

        searchQuery.with(PageRequest.of(page, size));
        return mongoTemplate.find(searchQuery, BookBorrowingManagement.class);
    }
}
