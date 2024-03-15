package com.cgi.praktika.movie.business.movie.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {

    private int id;
    private int tmdbId;
    private String name;
    private String time;
    private String genre;
    private String ageRestriction;
    private String language;
    private String weekDay;
    private String imageUrl;
    private double rating;
}