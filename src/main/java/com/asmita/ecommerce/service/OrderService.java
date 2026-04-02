package com.asmita.ecommerce.service;

import com.asmita.ecommerce.entity.Order;
import com.asmita.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order placeOrder(Long userId, Double amount) {
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(amount);
        order.setStatus("SUCCESS"); // fake payment
        return repo.save(order);
    }

    public List<Order> getOrders(Long userId) {
        return repo.findByUserId(userId);
    }
}