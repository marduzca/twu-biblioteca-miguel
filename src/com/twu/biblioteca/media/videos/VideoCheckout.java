package com.twu.biblioteca.media.videos;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class VideoCheckout {

    private BibliotecaApp bibApp;

    public VideoCheckout(BibliotecaApp bibApp) {
        this.bibApp = bibApp;
    }

    public void processInput(String userInput) {
        while(!isValidInput(userInput)) {
            Console.outputln("Please select a valid option!");
            userInput = Console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (VideoManager.getAvailableVideos().size() + 1)) {
            BibliotecaApp.currentState = AppState.MAIN_MENU;
        }
        else {
            Console.outputln(checkoutVideo(VideoManager.getAvailableVideos().get((Integer.valueOf(userInput)) - 1).getId()));
        }
    }

    public boolean isValidInput(String input) {
        try {
            int inputInt = Integer.parseInt(input);
            if (inputInt > (VideoManager.getAvailableVideos().size() + 1) || inputInt < 1) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public String checkoutVideo(int id) {
        for(Video v : VideoManager.getAvailableVideos()) {
            if(v.getId() == id) {
                v.setAvailability(false);
                VideoManager.updateAvailableVideosList();
                bibApp.currentAccount.assignRentedVideo(v);
                BibliotecaApp.currentState = AppState.MAIN_MENU;
                return "You just rented the video with ID " + id + "\nThank you! Enjoy it";
            }
        }

        return "Sorry, that video is not available";
    }
}
