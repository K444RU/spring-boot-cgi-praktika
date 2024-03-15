package com.cgi.praktika.movie.business.movie.model;

import lombok.Data;

@Data
public class MovieSchedule {

    private int id;
    private int movieId;
    private StartTime startTime;
    private WeekDay weekDay;
    private String imageUrl;

    public MovieSchedule(int id, int movieId, StartTime startTime, WeekDay weekDay, String imageUrl) {
        this.id = id;
        this.movieId = movieId;
        this.startTime = startTime;
        this.weekDay = weekDay;
        this.imageUrl = imageUrl;
    }
}
