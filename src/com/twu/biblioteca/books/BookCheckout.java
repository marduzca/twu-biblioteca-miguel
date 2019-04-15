package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class BookCheckout {

    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.outputln("Please select a valid option!");
            userInput = Console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (BookManager.getAvailableBooks().size() + 1)) {
            BibliotecaApp.currentState = AppState.MAIN_MENU;
        }
        else {
            Console.outputln(checkoutBook(BookManager.getAvailableBooks().get((Integer.valueOf(userInput)) - 1).getId()));
        }
    }

    public boolean isValidInput(String input) {
        try {
            int inputInt = Integer.parseInt(input);
            if (inputInt > (BookManager.getAvailableBooks().size() + 1) || inputInt < 1) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public String checkoutBook(int id) {
        for(Book b : BookManager.getAvailableBooks()) {
            if(b.getId() == id) {
                    b.setAvailability(false);
                    BookManager.updateAvailableBooksList();
                    BibliotecaApp.currentState = AppState.MAIN_MENU;
                    return "You just rented the book with ID " + id + "\nThank you! Enjoy the book";
            }
        }

        return "Sorry, that book is not available";
    }
}
