package com.roman;

public class TeenNumberChecker {
    public static boolean hasTeen(int first, int second, int third) {
        if (
                (first > 12 && first < 20)
                        ||(second > 12 && second < 20)
                        || (third > 12 && third < 20)
                ) {
            return true;
        }
        return false;
    }
}
