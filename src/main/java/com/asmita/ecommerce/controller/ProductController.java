package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.entity.Product;
import com.asmita.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product add(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}