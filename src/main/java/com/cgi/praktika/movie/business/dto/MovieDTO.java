package com.cgi.praktika.movie.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDTO {
    private int id;
    private String name;
    private String time;
    private String genre;
    private String ageRestriction;
    private String language;
    private String weekDay;
}