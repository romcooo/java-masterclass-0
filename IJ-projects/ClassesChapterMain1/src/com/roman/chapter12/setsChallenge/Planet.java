package com.roman.chapter12.setsChallenge;


public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon instanceof Moon) {
            return super.addSatellite(moon);
        } else {
            System.out.println("Cannot add a non-moon as a satellite of a Planet.");
            return false;
        }

    }
}
