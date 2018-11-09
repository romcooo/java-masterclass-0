package com.romcooo;

public class Main {

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return "Invalid value";
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        if (hours > 99) hours = 99;
        String formatHours = String.valueOf(hours)+"h ";
        String formatMinutes = String.valueOf(remainingMinutes)+"m ";
        String formatSeconds = String.valueOf(seconds)+"s";
        if (hours < 10) formatHours = "0"+formatHours;
        if (minutes < 10) formatMinutes = "0"+formatMinutes;
        if (seconds == 0) formatSeconds = "0"+formatSeconds;
        String result = (formatHours+formatMinutes+formatSeconds);
        return result;
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid value";
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(getDurationString(1, 50));
        System.out.println(getDurationString(120060));
        System.out.println(getDurationString(0));
    }
}
