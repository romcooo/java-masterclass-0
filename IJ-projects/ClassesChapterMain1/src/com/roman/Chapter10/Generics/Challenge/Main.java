package com.roman.Chapter10.Generics.Challenge;

import com.roman.Chapter10.Generics.Challenge.Sports.Baseball;
import com.roman.Chapter10.Generics.Challenge.Sports.Football;
import com.roman.Chapter10.Generics.Challenge.Sports.Soccer;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======START=======");

        Player<Soccer> beckham = new Player<>("Beckham");
        Player<Soccer> raul = new Player<>("Raul");
        Player<Soccer> divis = new Player<>("Divis");
        Player<Soccer> aaron = new Player<>("Aaron");
        Player<Soccer> baron = new Player<>("Baron");
        Player<Soccer> clarke = new Player<>("Clarke");

//        Player<Football> tim = new Player<>("Tim");
//        Player<Football> tom = new Player<>("Tom");
//        Player<Football> tony = new Player<>("Tony");
//
//        Player<Baseball> buck = new Player<>("Buck");
//        Player<Baseball> bane = new Player<>("Bane");
//        Player<Baseball> bradley = new Player<>("Bradley");


        Team<Soccer> arsenal = new Team<>("Arsenal London");
        Team<Soccer> barcelona = new Team<>("Barcelona Kokots");
        Team<Soccer> manchester = new Team<>("Man United");
        Team<Soccer> slovan = new Team<>("Slovan");
        Team<Soccer> dortumund = new Team<>("Dortmund");
        Team<Soccer> nitra = new Team<>("Nitra");

        arsenal.addPlayer(beckham);
        barcelona.addPlayer(raul);
        manchester.addPlayer(divis);
        slovan.addPlayer(aaron);
        dortumund.addPlayer(baron);
        nitra.addPlayer(clarke);

//        Team<Baseball> ducks = new Team<>("Manhattan Ducks");
//        Team<Football> lions = new Team<>("Lions");

        League<Soccer> fifa = new League<>("FIFA World Cup");

        fifa.addTeam(arsenal);
        fifa.addTeam(barcelona);
        fifa.addTeam(manchester);
        fifa.addTeam(slovan);
        fifa.addTeam(dortumund);
        fifa.addTeam(nitra);

        System.out.println("======");

        fifa.playMatch(arsenal, manchester, 1, 0);
        fifa.playMatch(arsenal, barcelona, 1, 0);
        fifa.playMatch(arsenal, manchester, 0, 3);
        fifa.playMatch(slovan, barcelona, 3,1);
        fifa.playMatch(dortumund, nitra, 1, 0);
        fifa.playMatch(dortumund, manchester, 3, 1);
        fifa.playMatch(dortumund, barcelona, 2, 1);
        fifa.playMatch(dortumund, manchester, 2, 2);

        fifa.getTeams();
    }
}
