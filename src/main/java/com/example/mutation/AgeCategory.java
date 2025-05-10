package com.example.mutation;

public class AgeCategory {
    public String getCategory(int age) {
        if (age < 13) return "Child";
        else if (age < 20) return "Teen";
        else return "Adult";
    }
}
