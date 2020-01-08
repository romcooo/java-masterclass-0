package com.romco.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParametrized {
    private BankAccount account;
    
    @BeforeEach
    public void setup() {
        account = new BankAccount("rom", "stu", 1000.00d, BankAccount.CHECKING);
    }
    
    public static Stream<Arguments> setParam() {
        return Stream.of(
                Arguments.of(100.00d, true, 1100.00d),
                Arguments.of(200.00d, true, 1200.00d));
    }
    
    @ParameterizedTest
    @MethodSource("setParam")
    void getBalance_deposit(double x, boolean b, double y) {
        account.deposit(x, b);
        assertEquals(y, account.getBalance(), 0);
    }
    
    
    
}
