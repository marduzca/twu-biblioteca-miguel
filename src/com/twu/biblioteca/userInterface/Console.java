package com.twu.biblioteca.userInterface;

import java.util.Scanner;

public class Console {

    private static Scanner inputReader;

    public Console() {
        inputReader = new Scanner(System.in);
    }


    public static void outputln(String output) {
        System.out.println("\n" + output);
    }

    public static void output(String output) {
        System.out.print("\n" + output);
    }

    public static String getUserInput() {
        System.out.print("> ");
        String userInput = inputReader.nextLine();
        return userInput;
    }

    public static String getLoginInput() {
        String userInput = inputReader.nextLine();
        return userInput;
    }
}