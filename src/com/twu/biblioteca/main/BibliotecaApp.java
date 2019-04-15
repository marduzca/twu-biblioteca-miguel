package com.twu.biblioteca.main;

import com.twu.biblioteca.accounts.Account;
import com.twu.biblioteca.accounts.LoginManager;
import com.twu.biblioteca.media.books.BookManager;
import com.twu.biblioteca.media.books.BookCheckout;
import com.twu.biblioteca.media.books.BookReturn;
import com.twu.biblioteca.menu.MainMenu;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;
import com.twu.biblioteca.media.videos.VideoCheckout;
import com.twu.biblioteca.media.videos.VideoManager;

public class BibliotecaApp {

    public static AppState currentState;

    private MainMenu mainMenu;
    private BookCheckout bookCheckout;
    private BookReturn bookReturn;
    private BookManager bookManager;
    private VideoManager videoManager;
    private VideoCheckout videoCheckout;
    private LoginManager loginManager;
    private Console console;
    public Account currentAccount;

    public BibliotecaApp() {
        this.currentState = AppState.INIT;
        this.bookCheckout = new BookCheckout(this);
        this.mainMenu = new MainMenu();
        this.bookReturn = new BookReturn(this);
        this.bookManager = new BookManager();
        this.videoManager = new VideoManager();
        this.videoCheckout = new VideoCheckout(this);
        this.loginManager = new LoginManager();
        this.console = new Console();
    }

    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp();

        while(!bibApp.currentState.equals(AppState.QUIT)) {
            switch (bibApp.currentState) {
                case INIT:
                    Console.outputln(showWelcomeMessage());

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    bibApp.changeStateTo(AppState.LOGIN_USER);
                    break;

                case LOGIN_USER:
                    Console.output(AppState.LOGIN_USER.getText() + ":\nEnter your library ID in xxx-xxxx format.\nLibrary ID: ");
                    String libraryID = Console.getLoginInput();
                    bibApp.currentAccount = bibApp.loginManager.processInput(libraryID.trim());
                    bibApp.changeStateTo(AppState.LOGIN_PWD);
                    break;

                case LOGIN_PWD:
                    Console.output("\nPlease enter your password.\nPassword: ");
                    if(bibApp.loginManager.login(bibApp.currentAccount.getLibraryID(), Console.getLoginInput().toCharArray())) {
                        bibApp.changeStateTo(AppState.MAIN_MENU);
                    }
                    else {
                        Console.output("The password was incorrect. Try again.");
                    }
                    break;

                case MAIN_MENU:
                    Console.outputln(AppState.MAIN_MENU.getText() + ":\n" + bibApp.mainMenu.showMainMenu() + "\nSelect the options by number");
                    bibApp.mainMenu.processInput(Console.getUserInput());
                    break;

                case CHEKOUT_BOOK_MENU:
                    Console.outputln("Book List:\n" + bibApp.bookManager.showListOfBooks() + "\n" + (BookManager.getAvailableBooks().size() + 1) + ". Back\nSelect the book that you want to checkout by number");
                    bibApp.bookCheckout.processInput(Console.getUserInput());
                    break;

                case RETURN_BOOK_MENU:
                    Console.outputln("Return a book by entering its ID (You find the ID on the back of the book):");
                    bibApp.bookReturn.processInput(Console.getUserInput());
                    break;

                case CHEKOUT_VIDEO_MENU:
                    Console.outputln("Video List:\n" + bibApp.videoManager.showListOfVideos() + "\n" + (VideoManager.getAvailableVideos().size() + 1) + ". Back\nSelect the video that you want to checkout by number");
                    bibApp.videoCheckout.processInput(Console.getUserInput());
                    break;

                case ACCOUNT_INFO:
                    Console.output("Account Information:");
                    Console.outputln(bibApp.currentAccount.toString());
                    Console.outputln("Press Enter to go back");
                    Console.getUserInput();
                    bibApp.changeStateTo(AppState.MAIN_MENU);
                    break;

                default:
                    throw new IllegalStateException("This should not happen");
            }
        }

        Console.outputln("Exiting... Thank you for using Biblioteca!");
    }

    private void changeStateTo(AppState newState) {
        currentState = newState;
    }

    public static String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
