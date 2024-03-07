package com.cgi.praktika.movie.business.model;

public enum AgeRestriction {
    ALLA_6("Alla 6 a. mittesoovitav"),
    ALLA_12("Alla 12 a. mittesoovitav"),
    PEREFILM("Perefilm"),
    ALLA_12_KEELATUD("Alla 12 a. keelatud"),
    LUBATUD_KOIGILE("Lubatud kõigile"),
    ALLA_14_KEELATUD("Alla 14 a. keelatud");

    private final String description;

    AgeRestriction(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
