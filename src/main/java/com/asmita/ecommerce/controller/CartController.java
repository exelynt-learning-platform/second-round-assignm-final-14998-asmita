package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.entity.Cart;
import com.asmita.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // ✅ Add to cart
    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    // ✅ Get all cart items
    @GetMapping
    public List<Cart> getCart() {
        return cartService.getAllCart();
    }

    // ✅ Delete cart item
    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id) {
        cartService.deleteCartById(id);
        return "Cart item deleted successfully";
    }
}