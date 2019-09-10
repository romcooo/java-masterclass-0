package com.roman.chapter12.setsChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88d);
        solarSystem.put(temp.getTypeAndName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225d);
        solarSystem.put(temp.getTypeAndName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365d);
        solarSystem.put(temp.getTypeAndName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon",  27);
        solarSystem.put(temp.getTypeAndName(), tempMoon);
        temp.addSatellite(tempMoon);

        System.out.println("Planets:");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        System.out.println("Moons of Earth");
        for(HeavenlyBody moon : solarSystem.get("PLANET: Earth").getSatellites() ) {
            System.out.println(moon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons:");
        for (HeavenlyBody moon : moons) {
            System.out.println(moon.getName());
        }

        HeavenlyBody planet1 = new Planet("Jupiter", 400d);
        HeavenlyBody moon1 = new Planet("Jupiter", 30d);

        System.out.println(planet1.equals(moon1));

    }

    private class SolarSystem {
//        private final String name;
        private Set<HeavenlyBody> heavenlyBodies = new HashSet<>();
        
    }
}
