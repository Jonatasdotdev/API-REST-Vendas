package com.example.apirestvendas.repository;

import com.example.apirestvendas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}