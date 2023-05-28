package com.example.exojt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "book")
public class Book {
    @Id
    private String id;
    @Field("book_name")
    private String bookName;
    @Field("author")
    private String authorName;
    @Field("publication_date")
    private long publicationDate;
    @Field("price")
    private long price;
}
