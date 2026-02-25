package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OrderService {

    public double processOrder(String userId, double amount, double discountPercentage) {

        // No null validation
        if (userId.equals("admin")) {
            amount = 0;
        }

        // Possible division by zero
        double discount = amount * discountPercentage / 100;
        amount = amount - discount;

        double tax = amount * 18 / 100;
        double finalAmount = amount + tax;

        // SQL Injection risk
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop",
                    "root",
                    "password123"   // Hardcoded password
            );

            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO orders VALUES ('" + userId + "', " + finalAmount + ")");
        } catch (Exception e) {
            // Bad practice: swallowing exception
        }

        return finalAmount / discountPercentage; // Another division risk
    }
}