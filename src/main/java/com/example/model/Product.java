package com.example.model;
import java.math.BigDecimal;

public class Product{
    private int id;
    private String sku;
    private String name;
    private int quantity;
    private BigDecimal price;
    
    public Product(int id, String sku, String name, int quantity, BigDecimal price) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Product( String sku, String name, int quantity, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", quantity=" + quantity + ", price=" + price
                + "]";
    }
}