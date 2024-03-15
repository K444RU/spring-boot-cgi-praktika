package com.cgi.praktika.movie.business.movie.model;

import lombok.Getter;

@Getter
public enum Language {

    ESTONIAN(1, "Estonian"),
    ENGLISH(2, "English"),
    MULTILINGUAL(3, "Multilingual");

    private final int id;
    private final String language;

    Language(int id, String language) {
        this.id = id;
        this.language = language;
    }
}
