package com.roman.Chapter9.InnerClasses.Challenge;

import java.time.Duration;

public class Song {
    private String title;
    private Duration duration;

    public Song(final String title, final Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    public Song(final String title, final String durationString) {
        if (!PlaylistFormatter.isDurationStringValid(durationString)) {
            System.out.println("Album - Invalid song duration format.");
            throw new IllegalArgumentException();
        } else {
            this.title = title;
            this.duration = PlaylistFormatter.getDuration(durationString);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getTitleAndDurationString() {
        return this.title + ", " + this.getDurationString();
    }

    public Duration getDuration() {
        return duration;
    }

    public String getDurationString() {
        return PlaylistFormatter.getDurationString(this.duration);
    }

    public Song createSong(String title, Duration duration) {
        return new Song(title, duration);
    }
}
