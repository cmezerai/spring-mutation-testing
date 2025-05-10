package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeEvaluatorTest {
    @Test
    public void testGradeA() {
        GradeEvaluator evaluator = new GradeEvaluator();
        assertEquals("A", evaluator.evaluate(95));
    }
// Pas de test pour "B" ni "C"

}