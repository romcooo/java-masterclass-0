package com.romco.oreillyrestexample.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
//    @JsonProperty("formatted_address")
    private String formattedAddress;
    private Geometry geometry;
}