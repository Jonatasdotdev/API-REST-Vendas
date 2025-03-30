package com.example.apirestvendas.repository;

import com.example.apirestvendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByOrderByDateDesc();
}