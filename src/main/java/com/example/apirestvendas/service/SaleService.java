package com.example.apirestvendas.service;

import com.example.apirestvendas.model.Sale;
import java.util.List;

public interface SaleService {
    Sale createSale(Sale sale);
    List<Sale> getAllSales();
}