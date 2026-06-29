package com.example.service;

import java.math.BigDecimal;

import com.example.model.Order;
import com.example.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        this.orderRepository = orderRepository;
    }

    public boolean processOrder(int customerId, int productId, int quantity, BigDecimal productPrice){
        if(quantity <= 0){
            System.out.println("So luong san pham dang nho hon hoac bang 0!");
            return false;
        }

        BigDecimal totalPrice = productPrice.multiply(new BigDecimal(quantity));

        Order newOrder = new Order(customerId,productId,quantity,totalPrice);

        return orderRepository.placeOrder(newOrder);
    }
}
