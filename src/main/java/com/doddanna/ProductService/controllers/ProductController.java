package com.doddanna.ProductService.controllers;

import com.doddanna.ProductService.dtos.ProductDto;
import com.doddanna.ProductService.models.ProductRequest;
import com.doddanna.ProductService.models.ProductResponse;
import com.doddanna.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> saveProduct(@RequestBody ProductRequest productRequest){
        Optional<ProductDto> productDto = productService.saveProduct(productRequest);
        return new ResponseEntity<>(productDto.get().getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id){
        Optional<ProductResponse> product=productService.findById(id);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        Optional<List<ProductResponse>> products=productService.findAllProducts();
        return new ResponseEntity<>(products.get(), HttpStatus.OK);
    }

}
