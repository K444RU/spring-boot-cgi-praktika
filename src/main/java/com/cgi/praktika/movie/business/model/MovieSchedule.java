package com.cgi.praktika.movie.business.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieSchedule {
    public static List<Movie> getMovies() {
        return new ArrayList<>(Arrays.asList(
                //Monday scheduled movies
                new Movie(1, "Dune: Part Two", StartTime.TIME_9_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.MONDAY),
                new Movie(2, "The Beekeeper", StartTime.TIME_10_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(3, "Kung Fu Panda 4", StartTime.TIME_10_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(4, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(5, "Elu ja armastus", StartTime.TIME_17_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.MONDAY),
                new Movie(6, "Migration", StartTime.TIME_19_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.MONDAY),
                //Tuesday scheduled movies
                new Movie(7, "Dune: Part Two", StartTime.TIME_9_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.TUESDAY),
                new Movie(8, "Kung Fu Panda 4", StartTime.TIME_10_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(9, "The Beekeeper", StartTime.TIME_11_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(10, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(11, "Migration", StartTime.TIME_19_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(12, "Elu ja armastus", StartTime.TIME_17_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.TUESDAY),
                //Wednesday scheduled movies
                new Movie(13, "Migration", StartTime.TIME_9_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(14, "Elu ja armastus", StartTime.TIME_10_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.WEDNESDAY),
                new Movie(15, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(16, "Kung Fu Panda 4", StartTime.TIME_12_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(17, "The Beekeeper", StartTime.TIME_15_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(18, "Dune: Part Two", StartTime.TIME_18_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.WEDNESDAY),
                //Thursday scheduled movies
                new Movie(19, "Dune: Part Two", StartTime.TIME_9_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.MONDAY),
                new Movie(20, "The Beekeeper", StartTime.TIME_10_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(21, "Kung Fu Panda 4", StartTime.TIME_10_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(22, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.MONDAY),
                new Movie(23, "Elu ja armastus", StartTime.TIME_17_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.MONDAY),
                new Movie(24, "Migration", StartTime.TIME_19_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.MONDAY),
                //Friday scheduled movies
                new Movie(25, "Dune: Part Two", StartTime.TIME_9_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.TUESDAY),
                new Movie(26, "Kung Fu Panda 4", StartTime.TIME_10_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(27, "The Beekeeper", StartTime.TIME_11_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(28, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(29, "Migration", StartTime.TIME_19_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.TUESDAY),
                new Movie(30, "Elu ja armastus", StartTime.TIME_17_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.TUESDAY),
                //Saturday scheduled movies
                new Movie(31, "Migration", StartTime.TIME_9_00,
                        Genre.CARTOON, AgeRestriction.LUBATUD_KOIGILE,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(32, "Elu ja armastus", StartTime.TIME_10_00,
                        Genre.DRAMA, AgeRestriction.ALLA_12,
                        Language.ESTONIAN, WeekDay.WEDNESDAY),
                new Movie(33, "Anyone But You", StartTime.TIME_11_00,
                        Genre.COMEDY, AgeRestriction.ALLA_12_KEELATUD,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(34, "Kung Fu Panda 4", StartTime.TIME_12_00,
                        Genre.FAMILY, AgeRestriction.PEREFILM,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(35, "The Beekeeper", StartTime.TIME_15_00,
                        Genre.ACTION, AgeRestriction.ALLA_14_KEELATUD,
                        Language.ENGLISH, WeekDay.WEDNESDAY),
                new Movie(36, "Dune: Part Two", StartTime.TIME_18_00,
                        Genre.SCIFI, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.WEDNESDAY),
                //Sunday scheduled movies
                new Movie(37, "The Royal Ballet - Swan Lake", StartTime.TIME_9_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(38, "The Royal Ballet - Swan Lake", StartTime.TIME_10_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(39, "The Royal Ballet - Swan Lake", StartTime.TIME_11_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(40, "The Royal Ballet - Swan Lake", StartTime.TIME_12_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(41, "The Royal Ballet - Swan Lake", StartTime.TIME_13_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(42, "The Royal Ballet - Swan Lake", StartTime.TIME_14_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(43, "The Royal Ballet - Swan Lake", StartTime.TIME_15_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(44, "The Royal Ballet - Swan Lake", StartTime.TIME_16_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(45, "The Royal Ballet - Swan Lake", StartTime.TIME_17_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(46, "The Royal Ballet - Swan Lake", StartTime.TIME_18_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY),
                new Movie(47, "The Royal Ballet - Swan Lake", StartTime.TIME_19_00,
                        Genre.DRAMA, AgeRestriction.LUBATUD_KOIGILE,
                        Language.MULTILINGUAL, WeekDay.SUNDAY)

        ));
    }
}