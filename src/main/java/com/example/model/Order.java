package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;

    
    
    public Order(int customerId, int productId, int quantity, BigDecimal totalPrice) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    @Override
    public String toString() {
        return "Order [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity
                + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + "]";
    }
    
}
