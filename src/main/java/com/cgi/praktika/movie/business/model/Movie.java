package com.cgi.praktika.movie.business.model;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String name;
    private StartTime time;
    private Genre genre;
    private AgeRestriction ageRestriction;
    private Language language;
    private WeekDay weekDay;

    public Movie(int id, String name, StartTime time, Genre genre, AgeRestriction ageRestriction, Language language, WeekDay weekDay) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.language = language;
        this.weekDay = weekDay;
    }

    public StartTime getStartTime() {
        return time;
    }
}
