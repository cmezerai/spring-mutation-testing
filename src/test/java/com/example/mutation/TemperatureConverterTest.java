package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureConverterTest {

    @Test
    public void testToFahrenheit() {
        TemperatureConverter conv = new TemperatureConverter();
        assertEquals(98.6, conv.toFahrenheit(37), 0.1);
    }
// Pas de test pour toCelsius


}