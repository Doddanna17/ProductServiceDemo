package com.doddanna.ProductService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private long id;
    private String name;
    private String productSku;
    private long price;
    private long quantity;

}
