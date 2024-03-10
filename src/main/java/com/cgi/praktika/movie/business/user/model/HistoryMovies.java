package com.cgi.praktika.movie.business.user.model;

import com.cgi.praktika.movie.business.movie.model.AgeRestriction;
import com.cgi.praktika.movie.business.movie.model.Genre;
import com.cgi.praktika.movie.business.movie.model.Language;
import com.cgi.praktika.movie.business.movie.model.StartTime;
import lombok.Data;

@Data
public class HistoryMovies {
    private int id;
    private String name;
    private Genre genre;
    private AgeRestriction ageRestriction;
    private Language language;
    private StartTime startTime;

    public HistoryMovies(int id, String name, Genre genre, AgeRestriction ageRestriction, Language language, StartTime startTime) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.language = language;
        this.startTime = startTime;
    }

}