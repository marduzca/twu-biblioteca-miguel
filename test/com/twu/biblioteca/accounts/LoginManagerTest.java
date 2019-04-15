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
    public void isValidFormatTest_shouldReturnTrue_When4thCharMinusAndLength8Chars() {
        assertTrue(loginManager.isValidFormat("433-LMJG"));
        assertTrue(loginManager.isValidFormat("ELM-4321"));
    }

    @Test
    public void isValidInputTest_shouldReturnFalse_WhenFormatValidButIdNotExistent() {
        assertFalse(loginManager.isValidInput("433-LMJG"));
        assertFalse(loginManager.isValidInput("ELM-4321"));
    }

    @Test
    public void processInputTest_shouldReturnCorrespondentAccount_WhenValidLibraryID() {
        assertEquals(loginManager.getAccountsList().get(0), loginManager.processInput("001-ADMI"));
        assertEquals(loginManager.getAccountsList().get(1), loginManager.processInput("002-TWOO"));
        assertEquals(loginManager.getAccountsList().get(2), loginManager.processInput("003-JOKE"));
    }

    @Test
    public void loginTest_shouldReturnTrue_WhenPasswordCorrect() {
        assertTrue(loginManager.login("001-ADMI", "admin".toCharArray()));
        assertTrue(loginManager.login("002-TWOO", "bacon".toCharArray()));
        assertTrue(loginManager.login("003-JOKE", "password".toCharArray()));
    }

    @Test
    public void loginTest_shouldReturnFalse_WhenPasswordIncorrect() {
        assertFalse(loginManager.login("001-ADMI", "administrator".toCharArray()));
        assertFalse(loginManager.login("002-TWOO", "awr0ngp4ssw0rd".toCharArray()));
        assertFalse(loginManager.login("003-JOKE", "bruteforce".toCharArray()));
    }
}