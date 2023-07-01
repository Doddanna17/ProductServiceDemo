package com.doddanna.ProductService.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ResponseModel<T> {
    private Object data;
    private String message;
    private HttpStatus status;

}
