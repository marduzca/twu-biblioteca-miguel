package com.twu.biblioteca.menu;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<AppState> optionsList;

    public MainMenu() {
        optionsList = new ArrayList<>();
        optionsList.add(AppState.CHEKOUT_BOOK_MENU);
        optionsList.add(AppState.RETURN_BOOK_MENU);
        optionsList.add(AppState.CHEKOUT_VIDEO_MENU);
        optionsList.add(AppState.QUIT);
    }

    public String showMainMenu() {
        StringBuffer optionsListAsText = new StringBuffer();

        for(int i = 0; i < optionsList.size();       i++) {
            optionsListAsText.append((i+1) + ". " + optionsList.get(i).getText() + "\n");
        }

        return optionsListAsText.toString().trim();
    }

    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.outputln("Please select a valid option!");
            userInput = Console.getUserInput();
        }

        BibliotecaApp.currentState = optionsList.get(Integer.valueOf(userInput) - 1);
    }

    public boolean isValidInput(String input) {
        try {
            if (Integer.parseInt(input) > optionsList.size()) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}