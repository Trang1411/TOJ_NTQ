package com.example.exojt.repository;

import com.example.exojt.models.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private MongoTemplate mongoTemplate;

    @Override
    public List<Book> findByIdOrBookName(String search, int page, int size) {
        Query searchQuery = new Query();
        if (search != null || !search.isEmpty()) {
            Criteria orCriteria = new Criteria().orOperator(
                    Criteria.where(Book.ID_FIELD).regex(search),
                    Criteria.where(Book.BOOK_NAME).regex(search)
            );
            searchQuery.addCriteria(orCriteria);
        }
        searchQuery.with(Sort.by(Sort.Direction.DESC, String.valueOf(Arrays.asList(Book.PUBLICATION_DATE, Book.PRICE))));
        searchQuery.with(PageRequest.of(page, size));
        return mongoTemplate.find(searchQuery, Book.class);
    }
}
