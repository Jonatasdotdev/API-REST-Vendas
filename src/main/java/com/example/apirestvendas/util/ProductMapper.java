package com.example.apirestvendas.util;

import com.example.apirestvendas.dto.ProductCreateDto;
import com.example.apirestvendas.dto.ProductResponseDto;
import com.example.apirestvendas.model.Product;

public class ProductMapper {
    public static Product toEntity(ProductCreateDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        return product;
    }

    public static ProductResponseDto toDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());
        return dto;
    }
}