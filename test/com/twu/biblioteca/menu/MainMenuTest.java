package com.twu.biblioteca.menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void showMainMenuOptions() {
        MainMenu menu = new MainMenu();
        assertEquals("1. List of books", menu.showMainMenu());
    }

}