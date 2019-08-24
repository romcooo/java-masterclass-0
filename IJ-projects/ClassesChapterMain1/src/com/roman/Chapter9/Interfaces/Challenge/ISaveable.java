package com.roman.Chapter9.Interfaces.Challenge;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    List<String> save();
    void load(List<String> loader);
}
