package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.entity.Order;
import com.asmita.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestParam Long cartId) {
        return orderService.placeOrder(cartId);
    }
}