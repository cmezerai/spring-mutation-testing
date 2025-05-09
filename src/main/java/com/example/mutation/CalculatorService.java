package com.example.mutation;


public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public boolean isPositive(int a) {
        return a > 0;
    }

    public boolean isPair(int a) {
        return a % 2 == 0;
    }
}
