package com.romco.oreillyrestexample.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Site {
    private Integer id;
    private String name;
    private double latitude, longitude;
    
    public Site() {
    }
    
    public Site(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
