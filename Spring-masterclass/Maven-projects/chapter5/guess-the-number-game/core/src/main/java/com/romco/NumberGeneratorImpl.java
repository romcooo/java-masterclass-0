package com.romco;

import java.util.Random;

//@Component
public class NumberGeneratorImpl implements NumberGenerator {
    
    // == fields ==
    private final Random random = new Random();
    private int maxNumber = 1023;
    
    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }
    
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
