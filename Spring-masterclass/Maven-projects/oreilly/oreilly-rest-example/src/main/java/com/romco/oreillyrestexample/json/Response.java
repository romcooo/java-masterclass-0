package com.romco.oreillyrestexample.json;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response {
    private List<Result> results;
    private String status;
    
    public Location getLocation() {
        return results.get(0).getGeometry().getLocation();
    }
    
    public String getFormattedAddress() {
        return results.get(0).getFormattedAddress();
    }
}
