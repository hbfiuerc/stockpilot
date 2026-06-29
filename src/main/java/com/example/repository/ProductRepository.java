package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Product;

public class ProductRepository {
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=StockPilot;encrypt=true;trustServerCertificate=true;";
    private static String USERNAME = "sa";
    private static String PASSWORD = "123456";

    public boolean saveProduct(Product product){
        String sql = "insert into Products (sku, name, quantity, price) values ( ?, ?, ?, ? )";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,product.getSku());
            pstmt.setString(2,product.getName());
            pstmt.setInt(3,product.getQuantity());
            pstmt.setBigDecimal(4, product.getPrice());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println("Loi khi luu san pham: " + e.getMessage());
            return false;
        }
    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from Products";
        try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
                
            while(rs.next()){
                Product product = new Product(rs.getInt("product_id"),
                                              rs.getString("sku"),
                                              rs.getString("name"),
                                              rs.getInt("quantity"),
                                              rs.getBigDecimal("price"));
                products.add(product);  
            }
            return products;
        }catch(SQLException e){
            System.out.println("Loi khi lay toan bo san pham");
        }
        return products;

    }
}
