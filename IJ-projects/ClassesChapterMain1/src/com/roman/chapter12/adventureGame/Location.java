package com.roman.chapter12.adventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(final String description, int locationID) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
    }

    public void addExit(String direction, int locationID) {
        exits.put(direction, locationID);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits); //REALLY IMPORTANT - this returns a new entity, meaning the private exits cannot be changed
    }
}
