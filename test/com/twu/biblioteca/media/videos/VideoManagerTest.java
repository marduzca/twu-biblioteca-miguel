package com.twu.biblioteca.media.videos;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VideoManagerTest {

    private VideoManager videoManager;

    @Before
    public void initialize() {
        videoManager = new VideoManager();
    }

    @Test
    public void showListOfBooksWithExtraInfoTest() {
        assertEquals("1. Titanic | 1997 | James Cameron | 8/10\n2. Ready Player One | 2018 | Steven Spielberg | 5/10\n3. Batman v Superman | 2016 | Zack Snyder | 7/10", videoManager.showListOfVideos());
    }

    @Test
    public void updateAvailableVideosListTest_ShouldContainOnlyAvailableVideos() {
        for(Video v : videoManager.getAvailableVideos()) {
            assertEquals(true, v.isAvailable());
        }
    }
}