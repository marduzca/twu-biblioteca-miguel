package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class BookReturn {
    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.output("That is not a valid book to return");
            userInput = Console.getUserInput();
        }

        Console.output(returnBook(Integer.valueOf(userInput)));
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

    public String returnBook(int id) {
        for(Book b : BookManager.bookList) {
            if(b.getId() == id) {
                if(!b.isAvailable()) {
                    b.setAvailability(true);
                    BibliotecaApp.currentState = AppState.MAIN_MENU;
                    return "Thank you for returning the book";
                }
                else if(b.isAvailable()) {
                    return "That is not a valid book to return";
                }
            }
        }

        return "That is not a valid book to return";
    }
}
