package com.doddanna.ProductService.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "price")
    private long price;
    @Column(name = "quantity")
    private long quantity;
    @Column(name = "product_sku",unique = true)
    private String productSku;
}
