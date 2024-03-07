package com.cgi.praktika.movie.business.model;

public enum Genre {
    COMEDY(1),
    DRAMA(2),
    THRILLER(3),
    HORROR(4),
    ACTION(5),
    CARTOON(6),
    SCIFI(7),
    FAMILY(8);

    private final int id;

    Genre(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}
