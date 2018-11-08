package com.roman;


public class Main {

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println("Player "+playerName+" managed to get into position "+position+" on the high score table.");
    }

    public static int calculateHighScorePosition(int score){
        if (score >= 1000) {
            return 1;
        } else if (500 <= score) {
            return 2;
        } else if (100 <= score) {
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) {
	// write your code here
        String playerName1 = "player 1", playerName2 = "player 2";
        String playerName3 = "player 3", playerName4 = "player 4";
        int score1 = 1500, score2 = 900, score3 = 400, score4 = 50;
        displayHighScorePosition(playerName1, calculateHighScorePosition(score1));
        displayHighScorePosition(playerName2, calculateHighScorePosition(score2));
        displayHighScorePosition(playerName3, calculateHighScorePosition(score3));
        displayHighScorePosition(playerName4, calculateHighScorePosition(score4));
    }
}
