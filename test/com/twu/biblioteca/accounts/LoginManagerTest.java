package com.twu.biblioteca.accounts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginManagerTest {

    private LoginManager loginManager;

    @Before
    public void initialize() {
        loginManager = new LoginManager();
    }

    @Test
    public void isValidInputTest_shouldReturnFalse_WhenInputHasNotExactly8Chars() {
        assertFalse(loginManager.isValidInput("Inp-utWith12"));
        assertFalse(loginManager.isValidInput("Inp-ut7"));
    }

    @Test
    public void isValidInputTest_shouldReturnFalse_When4thCharIsNotMinus() {
        assertFalse(loginManager.isValidInput("InptWit8"));
        assertFalse(loginManager.isValidInput("ThisMyID"));
    }

    @Test
    public void isValidInputTest_shouldReturnTrue_When4thCharMinusAndLength8Chars() {
        assertTrue(loginManager.isValidInput("433-LMJG"));
        assertTrue(loginManager.isValidInput("ELM-4321        "));
    }
}