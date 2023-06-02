package com.example.exojt.payload.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LogsResponse {
    private String nameMethod;
    private String url;
    private String method;
    private long processTime;
}
