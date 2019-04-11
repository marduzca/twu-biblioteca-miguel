package com.twu.biblioteca.main;

import com.twu.biblioteca.books.Checkout;
import com.twu.biblioteca.menu.MainMenu;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class BibliotecaApp {

    private boolean RUN;
    public static AppState currentState;

    private MainMenu mainMenu;
    private Checkout bookCheckout;

    public BibliotecaApp() {
        this.currentState = AppState.INIT;
        this.bookCheckout = new Checkout();
        this.mainMenu = new MainMenu();
    }

    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp();

        while(!bibApp.currentState.equals(AppState.QUIT)) {
            switch (bibApp.currentState) {
                case INIT:
                    Console.output(showWelcomeMessage());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    bibApp.changeStateTo(AppState.MAIN_MENU);
                    break;

                case MAIN_MENU:
                    Console.output("Main Menu:\n" + bibApp.mainMenu.showMainMenu() + "\nSelect the options by number");
                    bibApp.mainMenu.processInput(Console.getUserInput());
                    break;

                case BOOK_MENU:
                    Console.output("Book List:\n" + bibApp.bookCheckout.showListOfBooksWithExtraInfo() + "\n" + (bibApp.bookCheckout.books.size() + 1) + ". Back\nSelect the book that you want to checkout by number");
                    bibApp.bookCheckout.processInput(Console.getUserInput());
                    break;

                case RETURN_MENU:
                    Console.output("Return a book by entering its ID");

                    break;

                default:
                    //How to deal with this?
                    break;
            }
        }

        Console.output("Exiting... Thank you for using Biblioteca!");
    }

    private void changeStateTo(AppState newState) {
        currentState = newState;
    }

    public static String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
