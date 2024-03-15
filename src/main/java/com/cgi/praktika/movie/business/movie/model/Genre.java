package com.cgi.praktika.movie.business.movie.model;

import lombok.Getter;

@Getter
public enum Genre {

    COMEDY(1, "Comedy"),
    DRAMA(2, "Drama"),
    THRILLER(3, "Thriller"),
    HORROR(4, "Horror"),
    ACTION(5, "Action"),
    CARTOON(6, "Cartoon"),
    SCIFI(7, "SciFi"),
    FAMILY(8, "Family");

    private final int id;
    private final String value;

    Genre(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
