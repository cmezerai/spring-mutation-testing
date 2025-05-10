package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    public void testGreenToYellow() {
        TrafficLight light = new TrafficLight();
        assertEquals("Yellow", light.next("Green"));
    }
// Pas de test pour Red, Yellow ou valeur inconnue


}