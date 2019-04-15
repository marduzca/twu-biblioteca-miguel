package com.twu.biblioteca.media.videos;

import java.util.ArrayList;
import java.util.List;

public class VideoManager {

    private static List<Video> videoList = new ArrayList<>();
    private static List<Video> availableVideos;

    public VideoManager(){
        videoList.add(new Video(101, "Titanic", 1997, "James Cameron", 8));
        videoList.add(new Video(102,"Ready Player One", 2018, "Steven Spielberg", 5));
        videoList.add(new Video(103, "Batman v Superman", 2016, "Zack Snyder", 7));

        availableVideos = new ArrayList<>(videoList);
    }


    public String showListOfVideos() {
        updateAvailableVideosList();

        StringBuffer videoListAsText = new StringBuffer();

        for(int i = 0; i < availableVideos.size(); i++) {
            videoListAsText.append((i+1) + ". " + availableVideos.get(i).getTitle() + " | " + availableVideos.get(i).getYear() + " | " + availableVideos.get(i).getDirector() + " | " + availableVideos.get(i).getMovieRating() + "/10\n");

        }

        return videoListAsText.toString().trim();
    }

    public static void updateAvailableVideosList() {
        for(Video v : videoList) {
            if(!v.isAvailable() && availableVideos.contains(v)) {
                availableVideos.remove(v);
            }
            else if(v.isAvailable() && !availableVideos.contains(v)) {
                availableVideos.add(v);
            }
        }
    }

    public static List<Video> getVideoList() {
        return videoList;
    }

    public static List<Video> getAvailableVideos() {
        return availableVideos;
    }
}
