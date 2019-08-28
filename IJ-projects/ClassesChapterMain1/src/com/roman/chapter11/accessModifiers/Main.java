package com.roman.chapter11.accessModifiers;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account("Roman");
        myAccount.deposit(1000);
        myAccount.withdraw(200);
        myAccount.withdraw(-300);
        myAccount.deposit(-500);
        System.out.println(myAccount.getBalance());
    }
}
