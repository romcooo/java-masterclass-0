package com.roman.chapter11.packages.example.game;

import java.util.List;

public interface ISaveable {
    List<String> save();
    void load(List<String> loader);
}
