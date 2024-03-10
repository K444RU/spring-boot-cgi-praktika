package com.cgi.praktika.movie.business.user.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private int movieWatchingHistoryId;
    private String email;
    private String password;

    public User(int id, int movieWatchingHistoryId, String email, String password) {
        this.id = id;
        this.movieWatchingHistoryId = movieWatchingHistoryId;
        this.email = email;
        this.password = password;
    }
}
