package com.roman.Chapter9.InnerClasses.Challenge;

import java.time.Duration;

public class PlaylistFormatter {
    public static boolean isDurationStringValid(String durationString) {
        if (durationString.matches("\\d+:\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDurationString(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).toMillis()/1000;
        return minutes + ":" + seconds;
    }

    public static Duration getDuration(String durationString) {
        if (!isDurationStringValid(durationString)) {
            return null;
        }
        String[] values = durationString.split(":");
        Duration duration = Duration.ofMinutes(Integer.parseInt(values[0]))
                .plusSeconds(Integer.parseInt(values[1]));
        return duration;
    }
}
