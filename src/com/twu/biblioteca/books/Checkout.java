package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class Checkout {
    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.output("Please select a valid option!");
            userInput = Console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (BookManager.bookList.size() + 1)) {
            BibliotecaApp.currentState = AppState.MAIN_MENU;
        }
        else {
            Console.output(checkoutBook(BookManager.bookList.get((Integer.valueOf(userInput)) - 1).getId()));
        }
    }

    public boolean isValidInput(String input) {
        try {
            if (Integer.parseInt(input) > (BookManager.bookList.size() + 1)) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public String checkoutBook(int id) {
        for(Book b : BookManager.bookList) {
            if(b.getId() == id) {
                if(b.isAvailable()) {
                    b.setAvailability(false);
                    BibliotecaApp.currentState = AppState.MAIN_MENU;
                    return "Thank you! Enjoy the book";
                }
                else if(!b.isAvailable()) {
                    return "Sorry, that book is not available";
                }
            }
        }

        return "ID nonexistent";
    }
}
