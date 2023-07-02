package com.doddanna.ProductService.services;

import com.doddanna.ProductService.dtos.ProductDto;
import com.doddanna.ProductService.exceptions.BadRequestException;
import com.doddanna.ProductService.models.ProductRequest;
import com.doddanna.ProductService.models.ProductResponse;
import com.doddanna.ProductService.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDto> saveProduct(ProductRequest productRequest) {
        log.info("Saving the product : "+productRequest);
        ProductDto productDto=ProductDto
                .builder()
                .name(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .productSku(productRequest.getProductSku())
                .build();
        Optional<ProductDto> byProductSku = productRepository.findByProductSku(productRequest.getProductSku());
        if(byProductSku.isPresent())
            throw new BadRequestException("Product already exist with "+productRequest.getProductSku());
        ProductDto save = productRepository.save(productDto);
        log.info("Product saved : "+save.getId());
        return Optional.of(save);
    }

    @Override
    public Optional<ProductResponse> findById(long id) {
        log.info("Fetching product : "+id);
        Optional<ProductDto> byId = productRepository.findById(id);
        if(byId.isEmpty())
            throw new BadRequestException("Product not found by "+id);
        log.info("Product found for : "+id);
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(byId.get(),productResponse);
        return Optional.of(productResponse);
    }

    @Override
    public Optional<List<ProductResponse>> findAllProducts() {
        log.info("Get all products ");
        List<ProductDto> all = productRepository.findAll();
        List<ProductResponse> collect = all.stream().map(productDto -> {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(productDto, productResponse);
            return productResponse;
        }).collect(Collectors.toList());
        log.info("Returning all products");
        return Optional.of(collect);
    }

    @Override
    public Optional<ProductResponse> reduceQuantity(long productId, long quantity) {
        log.info("Reducing quantity for product "+productId+" of quantity : "+quantity);
        Optional<ProductDto> byId = productRepository.findById(productId);
        if(byId.isEmpty())
            throw new BadRequestException("Invalid product id");
        ProductDto productDto = byId.get();
        if(productDto.getQuantity()<quantity)
            throw new BadRequestException("Insufficient quantity available");
        productDto.setQuantity(productDto.getQuantity()-quantity);
        ProductDto save = productRepository.save(productDto);
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(save,productResponse );
        return Optional.of(productResponse);
    }
}
