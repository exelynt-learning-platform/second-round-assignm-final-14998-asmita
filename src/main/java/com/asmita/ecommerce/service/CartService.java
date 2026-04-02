package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.Cart;
import com.asmita.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    // Add to cart
    public Cart addToCart(Cart cart) {
        return repo.save(cart);
    }

    // Get cart by user
    public List<Cart> getCartByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    // Remove item
    public void removeFromCart(Long id) {
        repo.deleteById(id);
    }
}