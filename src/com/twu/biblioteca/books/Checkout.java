package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public List<Book> books = new ArrayList<>();

    public Checkout(){
        books.add(new Book(101, "Sherlock Holmes", "Arthur Conan Doyle", 1887));
        books.add(new Book(102,"Ready Player One", "Ernest Cline", 2011));
        books.add(new Book(103,"Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", 1886));
    }

    public String showListOfBooks() {
        StringBuffer bookListAsText = new StringBuffer();

        for(int i = 0; i < books.size(); i++) {
            bookListAsText.append((i+1) + ". " + books.get(i).getTitle() + "\n");
        }

        return bookListAsText.toString().trim();
    }

    public String showListOfBooksWithExtraInfo() {
        StringBuffer bookListWithExtraInfoAsText = new StringBuffer();

        for(int i = 0; i < books.size(); i++) {
            bookListWithExtraInfoAsText.append((i+1) + ". " + books.get(i).getTitle() + " | " + books.get(i).getAuthor() + " | " + books.get(i).getYear() + "\n");
        }

        return bookListWithExtraInfoAsText.toString().trim();
    }

    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.output("Please select a valid option!");
            userInput = Console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (books.size() + 1)) {
            BibliotecaApp.currentState = AppState.MAIN_MENU;
        }
        else {
            Console.output(checkoutBook(books.get((Integer.valueOf(userInput)) - 1).getId()));
        }
    }

    public boolean isValidInput(String input) {
        try {
            if (Integer.parseInt(input) > (books.size() + 1)) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public String checkoutBook(int id) {
        for(Book b : books) {
            if(b.getId() == id) {
                if(b.isAvailable()) {
                    b.setAvailability(false);
                    BibliotecaApp.currentState = AppState.QUIT;
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
