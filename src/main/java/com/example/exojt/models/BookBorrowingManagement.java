package com.example.exojt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book_borrowing_management")
public class BookBorrowingManagement {
    public static final String ID_FIELD = "_id";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String EMAIL = "email";
    public static final String BOOK_NAME = "book_name";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";
    public static final String DURATION = "duration";
    public static final String STATUS = "status";

    @Id
    private String id;
    @Field(USER_ID)
    private String userId;
    @Field(USER_NAME)
    private String userName;
    @Field(EMAIL)
    private String email;
    @Field(BOOK_NAME)
    private String bookName;
    @Field(START_TIME)
    private long startTime;
    @Field(END_TIME)
    private long endTime;
    @Field(DURATION)
    @Max(10)
    private long duration;
    @Field(STATUS)
    private String status;
}
