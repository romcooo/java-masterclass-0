package com.romco.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicStringTest {
    MagicString magicString = new MagicString("asd");

    @Test
    void getNumberOfVowels() {
        assertEquals(1, magicString.getNumberOfVowels());
    }
}