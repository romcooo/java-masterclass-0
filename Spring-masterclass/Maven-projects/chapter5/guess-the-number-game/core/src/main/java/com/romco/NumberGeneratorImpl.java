package com.romco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
    
    // == fields ==
    private final Random random = new Random();

//    @Autowired
//    @MaxNumber
    private final int maxNumber;
//    @Autowired
//    @MinNumber
    private final int minNumber;
    
    // == constructors ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,
                               @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }
    
    // == public methods ==
    @Override
    public int next() {
        return minNumber + random.nextInt(maxNumber - minNumber);
    }
    
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
    
    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
