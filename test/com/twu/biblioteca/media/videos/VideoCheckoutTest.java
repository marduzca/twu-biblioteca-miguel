package com.twu.biblioteca.media.videos;

import com.twu.biblioteca.accounts.LoginManager;
import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import sun.rmi.log.LogInputStream;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class VideoCheckoutTest {

    private static BibliotecaApp bibApp;
    private static VideoCheckout videoCheckout;
    private static VideoManager videoManager;
    private static LoginManager loginManager;

    @BeforeClass
    public static void initialize() {
        bibApp = new BibliotecaApp();
        loginManager = new LoginManager(bibApp.console);
        bibApp.currentAccount = loginManager.getAccountsList().get(0);
        videoManager = new VideoManager();
        videoCheckout = new VideoCheckout(bibApp, videoManager, bibApp.console);
    }

    @Test
    public void checkoutVideoTest_shouldReturnToMainMenu_WhenCheckoutSuccessful() {
        videoManager.getAvailableVideos().get(0).setAvailability(true);
        videoManager.updateAvailableVideosList();

        assertEquals(AppState.MAIN_MENU, videoCheckout.checkoutVideo(101));
    }

    @Test
    public void videoShouldBeUnavailable_WhenCheckoutSuccessful(){
        videoManager.getAvailableVideos().get(0).setAvailability(true);
        videoManager.updateAvailableVideosList();
        videoCheckout.checkoutVideo(101);

        assertEquals(false, videoManager.getVideoList().get(0).isAvailable());
    }

    @Test
    public void checkoutVideoTest_shouldStayInCheckoutVideoMenu_WhenCheckoutUnsuccessful() {
        videoManager.getAvailableVideos().get(0).setAvailability(false);
        videoManager.updateAvailableVideosList();

        assertEquals(AppState.CHEKOUT_VIDEO_MENU, videoCheckout.checkoutVideo(101));
    }
}