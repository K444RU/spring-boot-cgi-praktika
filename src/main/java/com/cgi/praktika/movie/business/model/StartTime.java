package com.cgi.praktika.movie.business.model;

import java.time.LocalTime;

public enum StartTime {
    TIME_9_00(LocalTime.of(9,0)),
    TIME_10_00(LocalTime.of(10,0)),
    TIME_11_00(LocalTime.of(11,0)),
    TIME_12_00(LocalTime.of(12,0)),
    TIME_13_00(LocalTime.of(13,0)),
    TIME_14_00(LocalTime.of(14,0)),
    TIME_15_00(LocalTime.of(15,0)),
    TIME_16_00(LocalTime.of(16,0)),
    TIME_17_00(LocalTime.of(17,0)),
    TIME_18_00(LocalTime.of(18,0)),
    TIME_19_00(LocalTime.of(19,0));

    private final LocalTime localTime;

    StartTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public int getHour() {
        return localTime.getHour();
    }
}
