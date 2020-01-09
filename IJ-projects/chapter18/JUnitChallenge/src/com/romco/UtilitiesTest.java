package com.romco;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    private Utilities util = new Utilities();
    
    static Stream<Arguments> getRemovePairsTestSet() {
        return(Stream.of(
                Arguments.of("AABCDDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB"),
                Arguments.of("A", "A")
                ));
    }
    
    @Test
    void everyNthChar1() {
        assertArrayEquals(new char[] {'e', 'l'}, util.everyNthChar("hello".toCharArray(), 2));
    }
    
    @Test
    void everyNthChar2() {
        assertArrayEquals("hello".toCharArray(), util.everyNthChar("hello".toCharArray(), 7));
    }
    
    
    @MethodSource("getRemovePairsTestSet")
    @ParameterizedTest
    void removePairsParametrized(String input, String expectedOutput) {
        assertEquals(expectedOutput, util.removePairs(input));
    }
//
//    @Test
//    void removePairs2() {
//        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
//    }
//
//    @Test
//    void removePairs3() {
//        assertEquals("ABCABDEF", util.removePairs("ABCCCABDEEF"));
//    }
//
//    @Test
//    void removePairs4() {
//        assertEquals("", util.removePairs(""));
//    }
//
    @Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
    }
    
    @Test
    void converterException() {
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }
    
    @Test
    void nullIfOddLengthNotNull() {
        assertNotNull(util.nullIfOddLength("abcd"));
    }
    
    @Test
    void nullIfOddLengthNull() {
        assertNull(util.nullIfOddLength("abc"));
    }
}
