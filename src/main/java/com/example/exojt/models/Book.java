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
    public static final String COLLECTION_NAME = "book";
    public static final String ID_FIELD = "_id";
    public static final String BOOK_NAME = "book_name";
    public static final String AUTHOR = "author";
    public static final String PUBLICATION_DATE = "publication_date";
    public static final long PRICE = Long.parseLong("price");
    @Id
    private String id;
    @Field(BOOK_NAME)
    private String bookName;
    @Field(AUTHOR)
    private String authorName;
    @Field(PUBLICATION_DATE)
    private long publicationDate;
    @Field("price")
    private long price;
}
