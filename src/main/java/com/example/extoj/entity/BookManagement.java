package com.example.extoj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book_management")
public class BookManagement {
    @Id
    private String id;
    @Field("user_id")
    private String userId;
    @Field("book_id")
    private String bookId;
    @Field("start_time")
    private long startTime;
    @Field("end_time")
    private long endTime;
}
