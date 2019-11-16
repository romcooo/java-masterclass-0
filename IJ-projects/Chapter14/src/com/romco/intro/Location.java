package com.romco.intro;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(final String description, int locationID, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits==null) {
            this.exits = new HashMap<>();
        } else {
            this.exits = new HashMap<>(exits);
        }
        this.exits.put("Q", 0);
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
