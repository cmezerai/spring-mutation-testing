package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void testEmptyString() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isEmpty(""));
    }
// Pas de test pour null


}