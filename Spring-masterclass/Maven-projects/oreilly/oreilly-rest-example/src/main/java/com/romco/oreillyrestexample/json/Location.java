package com.romco.oreillyrestexample.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private double lat, lng;
    
    @Override
    public String toString() {
        return String.format("(%s,%s)", lat, lng);
    }
}
