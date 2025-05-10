package com.example.mutation;

public class DiscountService {
    public double applyDiscount(double price, boolean isMember) {
        if (isMember) {
            return price * 0.9;
        }
        return price;
    }
}
