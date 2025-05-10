package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenOddCheckerTest {
    @Test
    public void testEven() {
        EvenOddChecker checker = new EvenOddChecker();
        assertTrue(checker.isEven(4));
    }
// Pas de test pour impair

}