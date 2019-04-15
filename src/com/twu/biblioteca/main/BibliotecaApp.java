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

    private static AppState currentState;

    private MainMenu mainMenu;
    private BookCheckout bookCheckout;
    private BookReturn bookReturn;
    private BookManager bookManager;
    private VideoManager videoManager;
    private VideoCheckout videoCheckout;
    private LoginManager loginManager;
    public Console console;
    public Account currentAccount;

    public BibliotecaApp() {
        this.currentState = AppState.INIT;
        this.console = new Console();
        this.loginManager = new LoginManager(console);
        this.mainMenu = new MainMenu(console);
        this.bookManager = new BookManager();
        this.bookCheckout = new BookCheckout(this, bookManager, console);
        this.bookReturn = new BookReturn(this, bookManager, console);
        this.videoManager = new VideoManager();
        this.videoCheckout = new VideoCheckout(this, videoManager, console);
    }

    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp();

        while(!bibApp.currentState.equals(AppState.QUIT)) {
            bibApp.updateState(handleStateProcess(bibApp));
        }

        bibApp.console.outputln("Exiting... Thank you for using Biblioteca!");
    }

    private static AppState handleStateProcess(BibliotecaApp bibApp) {
        switch (currentState) {
            case INIT:
                bibApp.console.outputln(bibApp.showWelcomeMessage());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return AppState.LOGIN_USER;

            case LOGIN_USER:
                bibApp.console.output(AppState.LOGIN_USER.getText() + ":\nEnter your library ID in xxx-xxxx format.\nLibrary ID: ");
                String libraryID = bibApp.console.getLoginInput();
                bibApp.currentAccount = bibApp.loginManager.processInput(libraryID.trim());
                return AppState.LOGIN_PWD;

            case LOGIN_PWD:
                bibApp.console.output("\nPlease enter your password.\nPassword: ");
                if(bibApp.loginManager.login(bibApp.currentAccount.getLibraryID(), bibApp.console.getLoginInput().toCharArray())) {
                    return AppState.MAIN_MENU;
                }
                else {
                    bibApp.console.output("The password was incorrect. Try again.");
                    return AppState.LOGIN_PWD;
                }

            case MAIN_MENU:
                bibApp.console.outputln(AppState.MAIN_MENU.getText() + ":\n" + bibApp.mainMenu.showMainMenu() + "\nSelect the options by number");
                return bibApp.mainMenu.processInput(bibApp.console.getUserInput());

            case CHEKOUT_BOOK_MENU:
                bibApp.console.outputln("Book List:\n" + bibApp.bookManager.showListOfBooks() + "\n" + (bibApp.bookManager.getAvailableBooks().size() + 1) + ". Back\nSelect the book that you want to checkout by number");
                return bibApp.bookCheckout.processInput(bibApp.console.getUserInput());

            case RETURN_BOOK_MENU:
                bibApp.console.outputln("Return a book by entering its ID (You find the ID on the back of the book):");
                return bibApp.bookReturn.processInput(bibApp.console.getUserInput());

            case CHEKOUT_VIDEO_MENU:
                bibApp.console.outputln("Video List:\n" + bibApp.videoManager.showListOfVideos() + "\n" + (bibApp.videoManager.getAvailableVideos().size() + 1) + ". Back\nSelect the video that you want to checkout by number");
                return bibApp.videoCheckout.processInput(bibApp.console.getUserInput());

            case ACCOUNT_INFO:
                bibApp.console.output("Account Information:");
                bibApp.console.outputln(bibApp.currentAccount.toString());
                bibApp.console.outputln("Press Enter to go back");
                bibApp.console.getUserInput();
                return AppState.MAIN_MENU;

            default:
                throw new IllegalStateException("This should not happen");
        }
    }

    private void updateState(AppState newState) {
        currentState = newState;
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
