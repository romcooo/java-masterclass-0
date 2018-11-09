package com.roman;

public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature){
        if (temperature < 25) {
            return false;
        }
        if ((!summer && temperature > 35) || (summer & temperature > 45)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 45));
    }
}
