package com.romco.banking;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    
    private BankAccount account;
    
    @org.junit.jupiter.api.BeforeEach
    private void setup() {
        this.account = new BankAccount("rom", "stu", 1000.00d, BankAccount.CHECKING);
    }
    
    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00d, true);
        assertEquals(1200.00d, balance, 0);
    }
    
    @org.junit.jupiter.api.Test
    void withdraw_overLimit_inBranch() {
        double balance = account.withdraw(600, true);
        assertEquals(400.00d, balance, 0);
    }
    
    @org.junit.jupiter.api.Test
    void withdraw_overLimit_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600, false));
    }
    
    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00d, true);
        assertEquals(1200.00d, account.getBalance(), 0);
    }
    
    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00d, true);
        assertEquals(800.00d, account.getBalance(), 0);
    }
    
    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "This account is NOT a checking account");
    }
}