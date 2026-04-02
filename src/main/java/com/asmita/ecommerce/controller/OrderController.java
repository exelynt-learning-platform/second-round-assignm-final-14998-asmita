package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.entity.Order;
import com.asmita.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long userId,
                            @RequestParam Double amount) {
        return service.placeOrder(userId, amount);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return service.getOrders(userId);
    }
}