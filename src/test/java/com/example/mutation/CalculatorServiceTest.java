package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, service.add(2, 3));
    }

    @Test
    void testIsPositive() {
        assertTrue(service.isPositive(10));
        assertFalse(service.isPositive(-1));
        assertFalse(service.isPositive(0));
        assertFalse(service.isPair(1));
        assertTrue(service.isPair(2));

    }
}
