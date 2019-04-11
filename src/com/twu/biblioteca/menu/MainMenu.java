package com.twu.biblioteca.menu;

import com.twu.biblioteca.books.Book;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<String> optionsList;

    public MainMenu() {
        optionsList = new ArrayList<>();
        optionsList.add("List of books");
    }

    public String showMainMenu() {
        StringBuffer optionsListAsText = new StringBuffer();

        for(int i = 0; i < optionsList.size(); i++) {
            optionsListAsText.append((i+1) + ". " + optionsList.get(i) + "\n");
        }

        return optionsListAsText.toString().trim();
    }
}