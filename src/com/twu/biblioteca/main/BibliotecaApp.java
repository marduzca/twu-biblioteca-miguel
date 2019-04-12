package com.twu.biblioteca.main;

import com.twu.biblioteca.books.BookManager;
import com.twu.biblioteca.books.BookCheckout;
import com.twu.biblioteca.books.BookReturn;
import com.twu.biblioteca.menu.MainMenu;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;
import com.twu.biblioteca.videos.VideoManager;

public class BibliotecaApp {

    public static AppState currentState;

    private MainMenu mainMenu;
    private BookCheckout bookCheckout;
    private BookReturn bookReturn;
    private BookManager bookManager;
    private VideoManager videoManager;

    public BibliotecaApp() {
        this.currentState = AppState.INIT;
        this.bookCheckout = new BookCheckout();
        this.mainMenu = new MainMenu();
        this.bookReturn = new BookReturn();
        this.bookManager = new BookManager();
        this.videoManager = new VideoManager();
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

                case CHEKOUT_BOOK_MENU:
                    Console.output("Book List:\n" + bibApp.bookManager.showListOfBooks() + "\n" + (BookManager.availableBooks.size() + 1) + ". Back\nSelect the book that you want to checkout by number");
                    bibApp.bookCheckout.processInput(Console.getUserInput());
                    break;

                case RETURN_BOOK_MENU:
                    Console.output("BookReturn a book by entering its ID (You find the ID on the back of the book):");
                    bibApp.bookReturn.processInput(Console.getUserInput());
                    break;

                case CHEKOUT_VIDEO_MENU:
                    Console.output("Video List:\n" + bibApp.videoManager.showListOfVideos() + "\n" + (VideoManager.availableVideos.size() + 1) + ". Back\nSelect the video that you want to checkout by number");
                    break;

                default:
                    //TODO: How to deal with this?
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
