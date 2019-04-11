package com.twu.biblioteca.userInterface;

import java.util.Scanner;

public class Console {

    private static Scanner inputReader = new Scanner(System.in);


    public static void output(String output) {
        System.out.println(output);
    }

    public static String getUserInput() {
        System.out.print("> ");
        String userInput = inputReader.nextLine();
        return userInput;
    }
}