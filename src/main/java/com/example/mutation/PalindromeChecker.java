package com.example.mutation;

public class PalindromeChecker {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
