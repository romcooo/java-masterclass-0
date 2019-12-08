package com.romcooo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount account = new BankAccount(1000.00d,"1234-678" );

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (account) {
                    account.deposit(300d);
                    account.withdraw(50d);
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75d);
                account.withdraw(100d);
            }
        }).start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    public void deposit ( double amount) {
        try {
            if (this.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println("Deposit of " + amount + ", remainder: " + this.balance);
                } finally {
                    this.lock.unlock();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }

    public void withdraw(double amount) {
        // could be sync'd here using synchronized(this) {...}
        try {
            if (this.lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println("Withdrawal of " + amount + ", remainder: " + this.balance);
                } finally {
                    this.lock.unlock();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + this.accountNumber);
    }
}