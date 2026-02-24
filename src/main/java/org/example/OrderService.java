package org.example;

public class OrderService {

    public double processOrder(String userId, double amount, double discountPercentage) {

        System.out.println("Processing order for user: " + userId);

        if(discountPercentage > 0) {
            amount = amount - (amount * discountPercentage / 100);
        }

        if(userId.equals("admin")) {
            amount = 0;
        }

        double tax = amount * 18 / 100;

        double finalAmount = amount + tax;

        return finalAmount / discountPercentage;
    }
}