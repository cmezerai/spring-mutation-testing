package com.example.mutation;

public class TrafficLight {
    public String next(String current) {

        return switch (current) {
            case "Red" -> "Green";
            case "Green" -> "Yellow";
            case "Yellow" -> "Red";
            default -> "Invalid";
        };
    }
}
