package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.entity.Cart;
import com.asmita.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    // Get cart by user
    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }

    // Remove item
    @DeleteMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "Item removed from cart";
    }
}