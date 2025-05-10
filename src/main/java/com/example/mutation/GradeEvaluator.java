package com.example.mutation;

public class GradeEvaluator {

    public String evaluate(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        return "C";
    }
}
