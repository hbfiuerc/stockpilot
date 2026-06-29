package com.example.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.model.Product;
import com.example.repository.ProductRepository;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(){
        this.productRepository = new ProductRepository();
    }

    public boolean addProduct(Product p){
        if(p.getSku() == null || p.getSku().trim().isEmpty()){
            System.out.println("Ma san pham khong duoc de trong");
            return false;
        }
        if(p.getQuantity() < 0){
            System.out.println("So luong khong the nho hon 0");
            return false;
        }
        if(p.getPrice() == null || p.getPrice().compareTo(BigDecimal.ZERO) <=0){
            System.out.println("Gia ban phai lon hon 0");
            return false;
        }
        return productRepository.saveProduct(p);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
