package com.roman.Chapter10.Generics;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);

        printDoubled(items);*/

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer tim = new BaseballPlayer("Tim");
        SoccerPlayer mac = new SoccerPlayer("Mac");

        Team<FootballPlayer> duklaTrencin = new Team<>("Dukla Trencin");
        duklaTrencin.addPlayer(joe);
//        duklaTrencin.addPlayer(tim);
//        duklaTrencin.addPlayer(mac);

        Team<BaseballPlayer> baseballPlayerTeam = new Team<>("Baseball Team");
        baseballPlayerTeam.addPlayer(tim);

//        Team<String> someTeam = new Team<>("asd");

        Team<SoccerPlayer> soccerTeam = new Team<>("Trencin");
        soccerTeam.addPlayer(mac);

        Team<SoccerPlayer> soccerTeam2 = new Team<>("Bratislava");


        soccerTeam.matchResult(soccerTeam2, 1, 0);
        soccerTeam.matchResult(soccerTeam2, 1, 0);

        System.out.println("The difference of ranking between " + soccerTeam.getName() + " and " + soccerTeam2.getName() + " is: " + soccerTeam.compareTo(soccerTeam2));

        soccerTeam.matchResult(soccerTeam2, 0, 1);
        soccerTeam.matchResult(soccerTeam2, 0, 1);

        System.out.println("The difference of ranking between " + soccerTeam.getName() + " and " + soccerTeam2.getName() + " is: " + soccerTeam.compareTo(soccerTeam2));

        ArrayList<Team> teams = new ArrayList<>();
        teams.add(soccerTeam);
        teams.add(soccerTeam2);
        Collections.sort(teams);


    }

    private static void printDoubled(ArrayList<Integer> n) {
        for(int i : n) { //autoboxing
            System.out.println(i * 2);
        }
    }
}


