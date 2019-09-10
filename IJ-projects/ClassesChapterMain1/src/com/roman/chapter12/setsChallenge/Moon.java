package com.roman.chapter12.setsChallenge;

import static com.roman.chapter12.setsChallenge.HeavenlyBody.BodyTypes.MOON;

public class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, MOON);
    }

}
