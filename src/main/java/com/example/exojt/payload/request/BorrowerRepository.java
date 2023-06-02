package com.example.exojt.payload.request;

import lombok.Data;

@Data
public class BorrowerRepository {
    private String keySearch;
    private ConditionSort condition;
}
