package com.twu.biblioteca.media.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class BookCheckout {

    private BibliotecaApp bibApp;
    private BookManager bookManager;
    private Console console;

    public BookCheckout(BibliotecaApp bibApp, BookManager bookManager, Console console) {
        this.bibApp = bibApp;
        this.bookManager = bookManager;
        this.console = console;
    }

    public AppState processInput(String userInput) {
        while(!isValidInput(userInput)) {
            console.outputln("Please select a valid option!");
            userInput = console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (bookManager.getAvailableBooks().size() + 1)) {
            return AppState.MAIN_MENU;
        }
        else {
            return checkoutBook(bookManager.getAvailableBooks().get((Integer.valueOf(userInput)) - 1).getId());
        }
    }

    private boolean isValidInput(String input) {
        try {
            int inputInt = Integer.parseInt(input);
            if (inputInt > (bookManager.getAvailableBooks().size() + 1) || inputInt < 1) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public AppState checkoutBook(int id) {
        for(Book b : bookManager.getAvailableBooks()) {
            if(b.getId() == id) {
                    b.setAvailability(false);
                    bookManager.updateAvailableBooksList();
                    bibApp.currentAccount.assignRentedBook(b);
                    console.outputln("You just rented the book with ID " + id + "\nThank you! Enjoy the book");
                    return AppState.MAIN_MENU;
            }
        }

        console.outputln("Sorry, that book is not available");
        return AppState.CHEKOUT_BOOK_MENU;
    }
}
