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
        solarSystem.put(tempMoon.getTypeAndName(), tempMoon);
        temp.addSatellite(tempMoon);


        HeavenlyBody planet1 = new Planet("Jupiter", 400d);
        HeavenlyBody moon1 = new Moon("Jupiter", 30d);


        //2
        System.out.println(planet1.equals(moon1));
        System.out.println(moon1.equals(planet1));

        System.out.println(planet1.equals(new Planet("Jupiter", 300d)));

        System.out.println("Planets:");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getProperties());
        }

        System.out.println("Solar System:");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println("\t" + heavenlyBody.getProperties());
        }

        //3 & 4
        temp = new Planet("Earth", 600d);
        System.out.println("Adding duplicate to a Map: " + solarSystem.put(temp.getTypeAndName(), temp));
        System.out.println("Adding duplicate to a Set: " + planets.add(temp));

        System.out.println("Planets:");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getProperties());
        }
        System.out.println("Solar System:");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println("\t" + heavenlyBody.getProperties());
        }

        temp = new Star("Earth", 10000d);
        System.out.println("Adding a same name but different type to a Map: " + solarSystem.put(temp.getTypeAndName(), temp));
        System.out.println("Adding a same name but different type to a Set: " + planets.add(temp));

        System.out.println("Planets:");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getProperties());
        }
        System.out.println("Solar System:");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println("\t" + heavenlyBody.getProperties());
        }
    }

    private class SolarSystem {
//        private final String name;
        private Set<HeavenlyBody> heavenlyBodies = new HashSet<>();
        
    }
}
