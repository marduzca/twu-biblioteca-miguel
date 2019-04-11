package com.twu.biblioteca.util;

public enum AppState {
    INIT("Starting..."),
    MAIN_MENU("Main menu"),
    BOOK_MENU("Rent a book"),
    RETURN_MENU("Return a book"),
    QUIT("Quit");

    private String text;

    AppState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
