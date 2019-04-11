package com.twu.biblioteca.menu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    private MainMenu menu;

    @Before
    public void initialize() {
        menu = new MainMenu();
    }

    @Test
    public void showMainMenuOptions() {
        assertEquals("1. List of books", menu.showMainMenu());
    }

    @Test
    public void isValidInputTest() {
        String input = "1";
        assertEquals(true, menu.isValidInput(input));

        input = "4";
        assertEquals(false, menu.isValidInput(input));
    }
}