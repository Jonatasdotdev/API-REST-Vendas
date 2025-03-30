package com.example.apirestvendas.dto;

import java.math.BigDecimal;

public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long stockQuantity;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getStockQuantity() {
        return stockQuantity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}