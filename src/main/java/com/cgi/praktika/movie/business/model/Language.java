package com.cgi.praktika.movie.business.model;

public enum Language {
    ESTONIAN("Estonian"),
    ENGLISH("English"),
    MULTILINGUAL("Multilingual");

    private final String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
