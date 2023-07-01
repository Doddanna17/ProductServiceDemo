package com.doddanna.ProductService.models;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;
    private String productSku;
}
