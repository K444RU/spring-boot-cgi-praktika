package com.cgi.praktika.movie.business.movie.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum AgeRestriction {

    ALLA_6(1, "Alla 6 a. mittesoovitav"),
    ALLA_12(2, "Alla 12 a. mittesoovitav"),
    PEREFILM(3, "Perefilm"),
    ALLA_12_KEELATUD(4, "Alla 12 a. keelatud"),
    LUBATUD_KOIGILE(5, "Lubatud kõigile"),
    ALLA_14_KEELATUD(6, "Alla 14 a. keelatud");

    private final int id;
    private final String description;

    AgeRestriction(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
