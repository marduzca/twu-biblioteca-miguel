package com.twu.biblioteca.accounts;

import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginManager {

    private List<Account> accountsList = new ArrayList<>();

    public LoginManager() {
        accountsList.add(new Account(new User("Kermit the Frog", "kermit99@muppet.com",690562845l), "001-ADMI", "admin".toCharArray()));
        accountsList.add(new Account(new User("Annie Sue Pig", "mspiggie@muppet.com",012022501140l), "002-ROFL", "piggie".toCharArray()));
        accountsList.add(new Account(new User("Fozzie Bear", "fozzie@muppet.com",70693146l), "003-JOKE", "password".toCharArray()));
    }

    public Account processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.outputln("That is not a valid library ID");
            Console.output(AppState.LOGIN_USER.getText() + "\nEnter your library ID in xxx-xxxx format.\nLibrary ID: ");
            userInput = Console.getUserInput();
        }

        Account currentAccount = new Account();

        for(Account a : accountsList) {
            if(userInput.equals(a.getLibraryID())) {
                currentAccount = a;
                break;
            }
        }

        return currentAccount;
    }

    public boolean isValidInput(String userInput) {
        return  isValidFormat(userInput) && libraryIdExists(userInput);
    }

    private boolean isValidFormat(String userInput) {
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
        for(Account a : accountsList) {
            if(libraryID.equals(a.getLibraryID())) {
                if(Arrays.equals(a.getPassword(), userPassword)) {
                    Console.outputln("Welcome back to your Biblioteca, " + a.getAccountOwner().getName() + "!");
                    return true;
                }
            }
        }

        return false;
    }
}
