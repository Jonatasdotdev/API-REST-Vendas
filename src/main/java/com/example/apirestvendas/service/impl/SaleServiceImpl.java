package com.example.apirestvendas.service.impl;

import com.example.apirestvendas.model.Product;
import com.example.apirestvendas.model.Sale;
import com.example.apirestvendas.repository.ProductRepository;
import com.example.apirestvendas.repository.SaleRepository;
import com.example.apirestvendas.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Sale createSale(Sale sale) {
        // Verify product exists and has enough stock
        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStockQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        if (sale.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        // Update stock
        product.setStockQuantity(product.getStockQuantity() - sale.getQuantity());
        productRepository.save(product);

        // Set sale date and save
        sale.setDate(LocalDateTime.now());
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAllByOrderByDateDesc();
    }
}