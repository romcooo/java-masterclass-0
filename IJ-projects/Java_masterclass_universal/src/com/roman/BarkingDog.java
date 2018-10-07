package com.roman;

public class BarkingDog {
    public static boolean bark(boolean barking, int hourOfDay){
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }
        if (((hourOfDay < 8)||(hourOfDay > 22)) && barking) {
            return true;
        }
        return false;
    }
}
