package com.twu.biblioteca.media.videos;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class VideoCheckoutTest {

    private static BibliotecaApp bibApp;
    private static VideoCheckout videoCheckout;
    private static VideoManager videoManager;

    @BeforeClass
    public static void initialize() {
        bibApp = new BibliotecaApp();
        videoCheckout = new VideoCheckout(bibApp);
        videoManager = new VideoManager();
    }

    @Test
    public void checkoutVideoTest_shouldGiveSuccessMsg_WhenVideoAvailable() {
        VideoManager.getAvailableVideos().get(0).setAvailability(true);
        VideoManager.updateAvailableVideosList();

        assertEquals("You just rented the video with ID 101\nThank you! Enjoy it", videoCheckout.checkoutVideo(101));
    }

    @Test
    public void videoShouldBeUnavailable_WhenCheckoutSuccessful(){
        VideoManager.getAvailableVideos().get(0).setAvailability(true);
        VideoManager.updateAvailableVideosList();
        videoCheckout.checkoutVideo(101);

        assertEquals(false, VideoManager.getVideoList().get(0).isAvailable());
    }

    @Test
    public void checkoutVideoTest_shouldGiveErrorMsg_WhenVideoUnavailable() {
        VideoManager.getAvailableVideos().get(0).setAvailability(false);
        VideoManager.updateAvailableVideosList();

        assertEquals("Sorry, that video is not available", videoCheckout.checkoutVideo(101));
    }

    @Test
    public void checkoutBookTest_shouldGoBackToMainMenu_WhenCheckoutSuccessful() {
        VideoManager.getVideoList().get(0).setAvailability(true);
        videoCheckout.checkoutVideo(101);

        assertEquals(AppState.MAIN_MENU, BibliotecaApp.currentState);
    }
}