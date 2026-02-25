package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AccountService {

    public double calculateBalance(String userId, double amount, double feePercentage) {

        // 1️⃣ Null pointer risk
        if (userId.equals("admin")) {
            amount = 0;
        }

        // 2️⃣ Magic number (tax)
        double tax = amount * 18 / 100;

        // 3️⃣ Possible division by zero
        double fee = amount * feePercentage / 100;

        double finalAmount = amount - fee + tax;

        try {
            // 4️⃣ Hardcoded credentials
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank",
                    "root",
                    "root123"
            );

            Statement stmt = con.createStatement();

            // 5️⃣ SQL Injection vulnerability
            String query = "INSERT INTO accounts VALUES ('" + userId + "', " + finalAmount + ")";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            // 6️⃣ Swallowed exception (bad practice)
        }

        // 7️⃣ Logic bug: dividing by feePercentage instead of something meaningful
        return finalAmount / feePercentage;
    }
}