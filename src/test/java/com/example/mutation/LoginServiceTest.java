package com.example.mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    public void testValidLogin() {
        LoginService service = new LoginService();
        assertTrue(service.authenticate("admin", "secret"));
    }
// Pas de test avec valeurs null


}