package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    @Test
    public void testApplyDiscountForMember() {
        DiscountService service = new DiscountService();
        assertEquals(90.0, service.applyDiscount(100.0, true), 0.01);
    }
// Pas de test pour non-membre


}