package com.twu.biblioteca.media.videos;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.userInterface.Console;
import com.twu.biblioteca.util.AppState;

public class VideoCheckout {

    private BibliotecaApp bibApp;
    private VideoManager videoManager;
    private Console console;

    public VideoCheckout(BibliotecaApp bibApp, VideoManager videoManager, Console console) {
        this.bibApp = bibApp;
        this.videoManager = videoManager;
        this.console = console;
    }

    public AppState processInput(String userInput) {
        while(!isValidInput(userInput)) {
            console.outputln("Please select a valid option!");
            userInput = console.getUserInput();
        }

        if(Integer.valueOf(userInput) == (videoManager.getAvailableVideos().size() + 1)) {
            return AppState.MAIN_MENU;
        }
        else {
            return checkoutVideo(videoManager.getAvailableVideos().get((Integer.valueOf(userInput)) - 1).getId());
        }
    }

    public boolean isValidInput(String input) {
        try {
            int inputInt = Integer.parseInt(input);
            if (inputInt > (videoManager.getAvailableVideos().size() + 1) || inputInt < 1) {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }

    public AppState checkoutVideo(int id) {
        for(Video v : videoManager.getAvailableVideos()) {
            if(v.getId() == id) {
                v.setAvailability(false);
                videoManager.updateAvailableVideosList();
                bibApp.currentAccount.assignRentedVideo(v);
                console.outputln("You just rented the video with ID " + id + "\nThank you! Enjoy it");
                return AppState.MAIN_MENU;
            }
        }

        console.outputln("Sorry, that video is not available");
        return AppState.CHEKOUT_VIDEO_MENU;
    }
}
