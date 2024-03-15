package com.cgi.praktika.movie.business.user.model;

import com.cgi.praktika.movie.business.movie.model.*;
import lombok.Data;

@Data
public class Movie {

    private int id;
    private int tmdbId;
    private String name;
    private Genre genre;
    private AgeRestriction ageRestriction;
    private Language language;

    public Movie(int id, int tmdbId, String name, Genre genre, AgeRestriction ageRestriction, Language language) {
        this.id = id;
        this.tmdbId = tmdbId;
        this.name = name;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.language = language;
    }
}
