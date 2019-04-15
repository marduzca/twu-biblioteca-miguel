package com.twu.biblioteca.media.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class BookReturn {

    private BibliotecaApp bibApp;
    private BookManager bookManager;
    private Console console;

    public BookReturn(BibliotecaApp bibApp, BookManager bookManager, Console console) {
        this.bibApp = bibApp;
        this.bookManager = bookManager;
        this.console = console;
    }

    public AppState processInput(String userInput) {
        while(!isValidInput(userInput)) {
            console.outputln("That is not a valid book to return");
            userInput = console.getUserInput();
        }

        return returnBook(Integer.valueOf(userInput));
    }

    public boolean isValidInput(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public AppState returnBook(int id) {
        for(Book b : bookManager.getBookList()) {
            if(b.getId() == id) {
                if(!b.isAvailable()) {
                    b.setAvailability(true);
                    bibApp.currentAccount.unassignReturnedBook(b);
                    console.outputln("Thank you for returning the book");
                    return AppState.MAIN_MENU;
                }
                else if(b.isAvailable()) {
                    console.outputln("That is not a valid book to return");
                    return AppState.RETURN_BOOK_MENU;
                }
            }
        }

        console.outputln("That is not a valid book to return");
        return AppState.RETURN_BOOK_MENU;
    }
}
