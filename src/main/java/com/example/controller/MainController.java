package com.example.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.example.model.Product;
import com.example.service.OrderService;
import com.example.service.ProductService;

public class MainController {
    private static Scanner sc  = new Scanner(System.in);

    private static final ProductService productService = new ProductService();
    private static final OrderService orderService =  new OrderService();

    public static void main(String[] args) {
        boolean running = true;

        while(running){
            System.out.println("\n=========================================");
            System.out.println("   HE THONG QUAN LY KHO STOCKPILOT");
            System.out.println("=========================================");
            System.out.println("1. Them san pham moi vao kho");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Dat hang");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang (1-4): ");

            try{
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addNewProduct();
                        break;
                    case 2:
                        showAllProduct();
                        break;  
                    case 4:
                        running = false;
                        System.out.println("Da thoat chuong trinh");
                        break;  
                    case 3:
                        showAllProduct();
                        break;
                    default:
                        throw new AssertionError();
                }


            }catch(NumberFormatException e) {
                System.out.println(" Vui long nhap so nguyen trong khoang 1 - 3");
            }
        }
    }

    private static void showAllProduct() {
        // TODO Auto-generated method stub
        List<Product> list = productService.getAllProduct();
        System.out.println("Tat ca san pham: ");
        if(list.size()==0){
            System.out.println("Kho dang trong!");
        }else{
            list.forEach(p->System.out.println(p.toString()));
        }
    }

    private static void addNewProduct() {
        // TODO Auto-generated method stub
        System.out.println("Nhap thong tin san pham them moi: ");
        try {
            System.out.print("Nhap ma san pham: ");
            String sku =  sc.nextLine();
            System.out.print("Nhap ten san pham: ");
            String name =  sc.nextLine();
            System.out.print("Nhap so luong san pham: ");
            int quantity = sc.nextInt();
            System.out.print("Nhap gia san pham: ");
            BigDecimal price = sc.nextBigDecimal();

            Product p = new Product(sku, name, quantity, price);

            boolean isSuccess = productService.addProduct(p);
            if(isSuccess){
                System.out.println("Them san pham thanh cong.");
            }else{
                System.out.println("San pham chua duoc them.");
            }
        } catch (Exception e) {
            System.out.println("Loi nhap lieu!");
        }    
    }

}
