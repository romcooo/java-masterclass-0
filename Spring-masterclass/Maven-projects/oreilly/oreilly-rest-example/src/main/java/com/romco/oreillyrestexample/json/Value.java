package com.romco.oreillyrestexample.json;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Value {
    private int id;
    private String joke;
    private List<String> categories;
}
