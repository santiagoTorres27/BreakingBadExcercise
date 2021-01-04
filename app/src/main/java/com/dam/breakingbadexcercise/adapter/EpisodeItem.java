package com.dam.breakingbadexcercise.adapter;

public class EpisodeItem {

    private String season;
    private String title;
    private String airDate;

    public EpisodeItem(String season, String title, String airDate) {
        this.season = season;
        this.title = title;
        this.airDate = airDate;
    }

    public String getSeason() {
        return season;
    }

    public String getTitle() {
        return title;
    }

    public String getAirDate() {
        return airDate;
    }
}
