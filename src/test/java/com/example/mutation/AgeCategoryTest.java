package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeCategoryTest {
    @Test
    public void testChildCategory() {
        AgeCategory ageCategory = new AgeCategory();
        assertEquals("Child", ageCategory.getCategory(10));
    }
// Pas de test pour Teen ou Adult

}