package com.example.apirestvendas.controller;

import com.example.apirestvendas.dto.SaleCreateDto;
import com.example.apirestvendas.dto.SaleResponseDto;
import com.example.apirestvendas.model.Product;
import com.example.apirestvendas.model.Sale;
import com.example.apirestvendas.service.ProductService;
import com.example.apirestvendas.service.SaleService;
import com.example.apirestvendas.util.SaleMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleService saleService;
    private final ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDto> createSale(@Valid @RequestBody SaleCreateDto saleCreateDto) {
        Product product = productService.getProductById(saleCreateDto.getProductId());
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(saleCreateDto.getQuantity());

        Sale createdSale = saleService.createSale(sale);
        return ResponseEntity.ok(SaleMapper.toDto(createdSale));
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        List<SaleResponseDto> response = sales.stream()
                .map(SaleMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}