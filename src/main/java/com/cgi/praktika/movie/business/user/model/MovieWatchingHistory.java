package com.cgi.praktika.movie.business.user.model;

import lombok.Data;

@Data
public class MovieWatchingHistory {
    private int id;
    private int userId;
    private int HistoryMoviesId;

    public MovieWatchingHistory(int id, int userId, int HistoryMoviesId) {
        this.id = id;
        this.userId = userId;
        this.HistoryMoviesId = HistoryMoviesId;
    }
}