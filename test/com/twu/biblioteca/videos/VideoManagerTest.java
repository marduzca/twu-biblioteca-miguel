package com.twu.biblioteca.videos;

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
        assertEquals("1. Titanic | 1997 | James Cameron | 8\n2. Ready Player One | 2018 | Steven Spielberg | 5\n3. Batman v Superman | 2016 | Zack Snyder | 7", videoManager.showListOfVideos());
    }

    @Test
    public void updateAvailableVideosListTest_ShouldContainOnlyAvailableVideos() {
        for(Video v : VideoManager.availableVideos) {
            assertEquals(true, v.isAvailable());
        }
    }
}