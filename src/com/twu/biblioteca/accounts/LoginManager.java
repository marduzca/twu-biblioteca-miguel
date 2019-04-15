package com.twu.biblioteca.accounts;

import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginManager {

    private List<Account> accountsList = new ArrayList<>();
    private Console console;

    public LoginManager(Console console) {
        this.console = console;
        accountsList.add(new Account(new User("Kermit The Frog", "kermit99@muppet.com",690562845l), "001-ADMI", "admin".toCharArray()));
        accountsList.add(new Account(new User("Annie Sue Pig", "mspiggie@muppet.com",012022501140l), "002-TWOO", "bacon".toCharArray()));
        accountsList.add(new Account(new User("Fozzie Bear", "fozzie@muppet.com",70693146l), "003-JOKE", "password".toCharArray()));
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public Account processInput(String userInput) {
        while(!isValidInput(userInput)) {
            console.outputln("That is not a valid library ID");
            console.output(AppState.LOGIN_USER.getText() + "\nEnter your library ID in xxx-xxxx format.\nLibrary ID: ");
            userInput = console.getUserInput();
        }

        return assignAccount(userInput);
    }

    private Account assignAccount(String libraryID) {
        Account currentAccount = new Account();

        for(Account a : accountsList) {
            if(libraryID.equals(a.getLibraryID())) {
                currentAccount = a;
                break;
            }
        }

        return currentAccount;
    }

    public boolean isValidInput(String userInput) {
        return  isValidFormat(userInput) && libraryIdExists(userInput);
    }

    public boolean isValidFormat(String userInput) {
        return userInput.length() == 8 && userInput.charAt(3) == '-';
    }

    private boolean libraryIdExists(String userInput) {
        for(Account a : accountsList) {
            if(userInput.equals(a.getLibraryID())) {
                return true;
            }
        }

        return false;
    }

    public boolean login(String libraryID, char[] userPassword) {

        Account currentAccount = assignAccount(libraryID);

        if(Arrays.equals(currentAccount.getPassword(), userPassword)) {
            console.outputln("Welcome back to your Biblioteca, " + currentAccount.getAccountOwner().getName() + "!");
            return true;
        }

        return false;
    }
}
