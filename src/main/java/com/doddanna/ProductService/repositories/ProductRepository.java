package com.doddanna.ProductService.repositories;

import com.doddanna.ProductService.dtos.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto,Long> {

    public Optional<ProductDto> findByProductSku(String productSku);
}
