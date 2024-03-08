package com.cgi.praktika.movie.business.model;

import java.util.Arrays;

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

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static AgeRestriction fromId(int id) {
        return Arrays.stream(values())
                .filter(value -> value.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for id: " + id));
    }

    public static AgeRestriction fromDescription(String description) {
        return Arrays.stream(values())
                .filter(value -> value.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for description: " + description));
    }
}
