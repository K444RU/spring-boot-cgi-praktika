package com.cgi.praktika.movie.business.user.model;

import lombok.Data;

@Data
public class UserMovieHistory {

    private int id;
    private int userId;
    private int movieId;

    public UserMovieHistory(int id, int userId, int movieId) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
    }
}
