package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.model.Order;

public class OrderRepository {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=StockPilot;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    public boolean placeOrder(Order order){
        String insertOrderSql = "Insert into Orders (customer_id, product_id,quantity ,total_price) values (?, ?, ?, ?)"; 
        String updateQuantitySql = "Update Products set quantity = quantity -? where product_id = ? and quantity >=?";

        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD)){
            conn.setAutoCommit(false);

            try(PreparedStatement insertOrderPstmt = conn.prepareStatement(insertOrderSql);
                PreparedStatement updateQuantityPstmt = conn.prepareStatement(updateQuantitySql)){
                
                updateQuantityPstmt.setInt(1, order.getQuantity());
                updateQuantityPstmt.setInt(2,order.getProductId());
                updateQuantityPstmt.setInt(3,order.getQuantity());

                int updateRows = updateQuantityPstmt.executeUpdate();
                if(updateRows == 0){
                    conn.rollback();
                    System.out.println("Tu choi! Don hang co so luong to kho khong du");
                    return false;
                }

                insertOrderPstmt.setInt(1, order.getCustomerId());
                insertOrderPstmt.setInt(2, order.getProductId());
                insertOrderPstmt.setInt(3, order.getQuantity());
                insertOrderPstmt.setBigDecimal(4, order.getTotalPrice());

                insertOrderPstmt.executeUpdate();

                conn.commit();
                return true;
            }catch(SQLException e){
                conn.rollback();
                System.out.println("Loi giao dich! Rollbacck thanh cong. "+ e.getMessage());
                return false;
            }finally{
                conn.setAutoCommit(true);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
