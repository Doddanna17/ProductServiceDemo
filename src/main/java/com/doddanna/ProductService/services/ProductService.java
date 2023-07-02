package com.doddanna.ProductService.services;

import com.doddanna.ProductService.dtos.ProductDto;
import com.doddanna.ProductService.models.ProductRequest;
import com.doddanna.ProductService.models.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService{

    Optional<ProductDto> saveProduct(ProductRequest productRequest);

    Optional<ProductResponse> findById(long id);

    Optional<List<ProductResponse>> findAllProducts();

    Optional<ProductResponse> reduceQuantity(long productId, long quantity);
}
