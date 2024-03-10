package com.cgi.praktika.movie.business.user.model;

import com.cgi.praktika.movie.business.movie.model.AgeRestriction;
import com.cgi.praktika.movie.business.movie.model.Genre;
import com.cgi.praktika.movie.business.movie.model.Language;
import com.cgi.praktika.movie.business.movie.model.StartTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcodedData {
    public static User getHardcodedUser() {
        return new User(1, 1, "oleg@cgi.com", "123");
    }

    public static MovieWatchingHistory getHardcodedMovieWatchingHistory() {
        return new MovieWatchingHistory(1, 1, 1);
    }

    public static List<HistoryMovies> getHardcodedMovies() {
        return new ArrayList<>(Arrays.asList(
                new HistoryMovies(1, "Oppenheimer", Genre.DRAMA,
                        AgeRestriction.ALLA_12,
                        Language.ENGLISH, StartTime.TIME_9_00),
                new HistoryMovies(2, "Past Lives", Genre.DRAMA,
                        AgeRestriction.ALLA_12,
                        Language.MULTILINGUAL, StartTime.TIME_10_00),
                new HistoryMovies(3, "Poor Things", Genre.DRAMA,
                        AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_11_00),
                new HistoryMovies(4, "The Holdovers", Genre.DRAMA,
                        AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_12_00),
                new HistoryMovies(5, "Killers of the Flower Moon", Genre.DRAMA,
                        AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_17_00),
                new HistoryMovies(6, "About Dry Grasses", Genre.DRAMA,
                        AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, StartTime.TIME_17_00),
                new HistoryMovies(7, "Anathomy of a Fall", Genre.THRILLER,
                        AgeRestriction.ALLA_14_KEELATUD,
                        Language.MULTILINGUAL, StartTime.TIME_17_00),
                new HistoryMovies(8, "Fallen Leaves", Genre.COMEDY,
                        AgeRestriction.ALLA_14_KEELATUD,
                        Language.MULTILINGUAL, StartTime.TIME_18_00),
                new HistoryMovies(9, "The tast of things", Genre.FAMILY,
                        AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_18_00),
                new HistoryMovies(10, "Spider-man: Across the spdier-verse", Genre.CARTOON,
                        AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, StartTime.TIME_19_00),
                new HistoryMovies(11, "American fiction", Genre.COMEDY,
                        AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_17_00),
                new HistoryMovies(12, "Mission: impossible - Dead Reckoning part One", Genre.THRILLER,
                        AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, StartTime.TIME_18_00)
        ));
    }
}