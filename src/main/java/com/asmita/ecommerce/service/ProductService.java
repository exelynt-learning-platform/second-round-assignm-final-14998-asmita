package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.Product;
import com.asmita.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        if (product.getPrice() <= 0 || product.getStock() < 0) {
            throw new RuntimeException("Invalid product data");
        }
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}