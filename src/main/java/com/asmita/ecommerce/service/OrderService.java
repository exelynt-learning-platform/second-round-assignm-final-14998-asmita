package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.Cart;
import com.asmita.ecommerce.entity.Order;
import com.asmita.ecommerce.repository.CartRepository;
import com.asmita.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository,
                        CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public Order placeOrder(Long cartId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (cart.getProduct() == null) {
            throw new RuntimeException("Cart has no product");
        }

        if (cart.getQuantity() <= 0) {
            throw new RuntimeException("Invalid quantity");
        }

        double total = cart.getProduct().getPrice() * cart.getQuantity();

        Order order = new Order();
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        return orderRepository.save(order);
    }
}