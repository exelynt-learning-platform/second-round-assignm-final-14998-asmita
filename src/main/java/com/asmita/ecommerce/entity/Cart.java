package com.asmita.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)   // ✅ IMPORTANT FIX
    @JoinColumn(name = "product_id")      // ✅ Proper FK column
    private Product product;

    private int quantity;

    // ✅ Default constructor (required)
    public Cart() {}

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}