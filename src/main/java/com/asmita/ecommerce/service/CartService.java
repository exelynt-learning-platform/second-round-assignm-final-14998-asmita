package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.Cart;
import com.asmita.ecommerce.entity.Product;
import com.asmita.ecommerce.repository.CartRepository;
import com.asmita.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public CartService(CartRepository cartRepo,
                       ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    // ✅ Add to cart (WITH PRODUCT FETCH - FIXED)
    public Cart createCart(Cart cart) {

        Long productId = cart.getProduct().getId();

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.setProduct(product);

        return cartRepo.save(cart);
    }

    // ✅ Get all cart items
    public List<Cart> getAllCart() {
        return cartRepo.findAll();
    }

    // ✅ Delete cart item
    public void deleteCartById(Long id) {
        cartRepo.deleteById(id);
    }
}