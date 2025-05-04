package com.example.web;

import com.example.core.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebTest {

    @Test
    void testSub() {
        Web calc = new Web();

        assertEquals(1, calc.sub(3, 2));
    }

}