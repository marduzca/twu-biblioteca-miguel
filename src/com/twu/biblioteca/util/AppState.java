package com.twu.biblioteca.util;

public enum AppState {
    INIT("Starting..."),
    MAIN_MENU("Main menu"),
    CHEKOUT_BOOK_MENU("Rent a book"),
    RETURN_BOOK_MENU("BookReturn a book"),
    CHEKOUT_VIDEO_MENU("Rent a video"),
    QUIT("Quit");

    private String text;

    AppState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
