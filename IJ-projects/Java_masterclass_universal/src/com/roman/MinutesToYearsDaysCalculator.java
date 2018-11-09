package com.roman;

public class MinutesToYearsDaysCalculator {
    public static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    public static final int MINUTE_TO_YEAR_DIVIDER = 60*24*365;

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
            return;
        }
        long years = minutes / MINUTE_TO_YEAR_DIVIDER;
        long remainingMinutes = minutes % MINUTE_TO_YEAR_DIVIDER;
        long days = remainingMinutes / (60*24);
//        remainingMinutes = minutes % (60*24);
        if (years > 99) years = 99;
//        String yearsString = String.valueOf(years) + " y and ";
//        String daysString = String.valueOf(days) + " d";
//        String minutesString = String.valueOf(remainingMinutes + " m");
//        if (years < 10) yearsString = "0"+ yearsString;
//        if (remainingMinutes < 10) minutesString = "0" + minutesString;
//        String initialMinutesString = String.valueOf(minutes) + " min = ";
//        String result = initialMinutesString + yearsString + daysString;
        String result = minutes + " min = "+years+" y and "+days+" d";
        System.out.println(result);
    }

    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(105321123);
    }
}
