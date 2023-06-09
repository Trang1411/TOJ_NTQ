package com.example.exojt.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rolse")
@Data
public class Role {
    @Id
    private String id;

    private ERole name;

}
