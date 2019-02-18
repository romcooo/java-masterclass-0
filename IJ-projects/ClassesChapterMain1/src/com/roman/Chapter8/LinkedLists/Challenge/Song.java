package com.roman.Chapter8.LinkedLists.Challenge;

import java.time.Duration;

public class Song {
    private String title;
    private Duration duration;

    public Song(final String title, final Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    public Song(final String title, final String durationString) {
        if (!durationString.matches("\\d+:\\d+")) {
            System.out.println("Album - Invalid song duration format.");
            throw new IllegalArgumentException();
        } else {
            this.title = title;
            this.duration = getDurationFromString(durationString);
        }
    }

    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getDurationString() {
        long minutes = this.duration.toMinutes();
        long seconds = this.duration.minusMinutes(minutes).toMillis()/1000;
        return minutes + ":" + seconds;
    }

    private Duration getDurationFromString(String durationString) {
        String[] values = durationString.split(":");
        Duration duration = Duration.ofMinutes(Integer.parseInt(values[0]))
                                    .plusSeconds(Integer.parseInt(values[1]));
        return duration;
    }

    public Song createSong(String title, Duration duration) {
        return new Song(title, duration);
    }
}
