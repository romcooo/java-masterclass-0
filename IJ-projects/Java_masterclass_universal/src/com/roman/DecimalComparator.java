package com.roman;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {
        int firstToInt = (int) (first*1000);
        int secondtoInt = (int) (second*1000);

        double diff = firstToInt - secondtoInt;
        System.out.println(diff);
        if(diff >= 1 || diff <= -1) {
            return false;
        }
        return true;

    }
}
