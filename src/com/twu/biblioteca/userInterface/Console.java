package com.twu.biblioteca.userInterface;

import java.util.Scanner;

public class Console {

    private Scanner inputReader;

    public Console() {
        inputReader = new Scanner(System.in);
    }


    public void outputln(String output) {
        System.out.println("\n" + output);
    }

    public void output(String output) {
        System.out.print("\n" + output);
    }

    public String getUserInput() {
        System.out.print("> ");
        String userInput = inputReader.nextLine();
        return userInput;
    }

    public String getLoginInput() {
        String userInput = inputReader.nextLine();
        return userInput;
    }
}