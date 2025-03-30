package com.example.apirestvendas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private LocalDateTime date;


    public Sale() {
    }


    public Sale(Long id, Product product, Long quantity, LocalDateTime date) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    // Método toString() para facilitar a depuração
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }

    // Métodos equals() e hashCode() para comparação de objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id.equals(sale.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}