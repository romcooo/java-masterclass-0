package com.roman.Chapter10.Generics.Challenge;

import com.roman.Chapter10.Generics.Challenge.Sports.Sport;
import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Sport> {
    private String name;
    private ArrayList<Team<T>> teams;

    public League(final String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public boolean addTeam (Team<T> teamToAdd) {
        if (this.teams.contains(teamToAdd)) {
            System.out.println("Team already in the league, will not add.");
            return false;
        }
        this.teams.add(teamToAdd);
        System.out.println("Added team: " + teamToAdd.getName());
        return true;
    }

    public boolean playMatch(Team<T> team1, Team<T> team2, int score1, int score2) {
        if (teams.contains(team1) && teams.contains(team2)) {
            System.out.println(name + " league match:");
            team1.matchResult(team2, score1, score2);
            return true;
        } else {
            System.out.println("At least one of the teams is not in this league!");
            return false;
        }
    }

    public ArrayList<Team<T>> getTeams() {
        Collections.sort(teams);
        Collections.reverse(teams);
        for (Team team:teams) {
            System.out.println(team.getName() + ": " + team.ranking());
        }
        return teams;
    }
}
