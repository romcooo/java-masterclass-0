package com.roman.chapter12.setsChallenge;

import static com.roman.chapter12.setsChallenge.HeavenlyBody.BodyTypes.STAR;

public class Star extends HeavenlyBody {
    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.STAR);
    }
}
