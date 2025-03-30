package com.example.apirestvendas.util;

import com.example.apirestvendas.dto.SaleResponseDto;
import com.example.apirestvendas.model.Sale;
import java.math.BigDecimal;

public class SaleMapper {
    public static SaleResponseDto toDto(Sale sale) {
        SaleResponseDto dto = new SaleResponseDto();
        dto.setId(sale.getId());
        dto.setProductId(sale.getProduct().getId());
        dto.setProductName(sale.getProduct().getName());
        dto.setQuantity(sale.getQuantity());
        dto.setUnitPrice(sale.getProduct().getPrice());

        BigDecimal total = sale.getProduct().getPrice().multiply(BigDecimal.valueOf(sale.getQuantity()));
        BigDecimal discount = calculateDiscount(sale.getQuantity());
        BigDecimal discountAmount = total.multiply(discount);

        dto.setTotalPrice(total.subtract(discountAmount));
        dto.setDiscountApplied(discount);
        dto.setDate(sale.getDate());
        return dto;
    }

    private static BigDecimal calculateDiscount(Long quantity) {
        if (quantity > 20) {
            return new BigDecimal("0.10"); // 10% discount
        } else if (quantity > 10) {
            return new BigDecimal("0.05"); // 5% discount
        }
        return BigDecimal.ZERO;
    }
}