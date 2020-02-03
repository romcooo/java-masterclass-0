package com.romco.oreillyrestexample.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JokeResponse {
    private String status;
    private Value value;
}
